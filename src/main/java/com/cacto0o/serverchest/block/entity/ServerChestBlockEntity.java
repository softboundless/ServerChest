package com.cacto0o.serverchest.block.entity;

import com.cacto0o.serverchest.ServerChestMod;
import com.cacto0o.serverchest.storage.ServerChestSavedData;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

/**
 * Positional proxy for the one world-wide inventory.
 *
 * <p>It deliberately exposes no sided slots and no NeoForge item-handler capability. Players use
 * the vanilla menu, while hoppers and Create-style automation have no supported inventory route.</p>
 */
public final class ServerChestBlockEntity extends BaseContainerBlockEntity implements WorldlyContainer {
    private static final Component DEFAULT_NAME = Component.translatable("container.serverchest.server_chest");
    private static final int[] NO_AUTOMATION_SLOTS = new int[0];

    private final NonNullList<ItemStack> clientFallback =
            NonNullList.withSize(ServerChestSavedData.SLOT_COUNT, ItemStack.EMPTY);

    public ServerChestBlockEntity(BlockPos pos, BlockState state) {
        super(ServerChestMod.SERVER_CHEST_BLOCK_ENTITY.get(), pos, state);
    }

    @Override
    public int getContainerSize() {
        return ServerChestSavedData.SLOT_COUNT;
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return getLevel() instanceof ServerLevel serverLevel
                ? ServerChestSavedData.get(serverLevel).items()
                : clientFallback;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> items) {
        NonNullList<ItemStack> target = getItems();
        for (int slot = 0; slot < target.size(); slot++) {
            target.set(slot, slot < items.size() ? items.get(slot) : ItemStack.EMPTY);
        }
        setChanged();
    }

    @Override
    public ItemStack removeItemNoUpdate(int slot) {
        ItemStack removed = ContainerHelper.takeItem(getItems(), slot);
        if (!removed.isEmpty()) {
            setChanged();
        }
        return removed;
    }

    @Override
    public void clearContent() {
        // A physical block never owns the shared inventory, so generic block-removal paths must
        // not be allowed to clear it. Slot-level changes (including CoreProtectNeo rollbacks) still
        // go through setItem/removeItem and are persisted normally.
    }

    @Override
    public void setChanged() {
        if (getLevel() instanceof ServerLevel serverLevel) {
            ServerChestSavedData.get(serverLevel).setDirty();
        }
        super.setChanged();
    }

    @Override
    protected Component getDefaultName() {
        return DEFAULT_NAME;
    }

    @Override
    protected AbstractContainerMenu createMenu(int containerId, Inventory inventory) {
        return ChestMenu.threeRows(containerId, inventory, this);
    }

    @Override
    public int[] getSlotsForFace(Direction side) {
        return NO_AUTOMATION_SLOTS;
    }

    @Override
    public boolean canPlaceItemThroughFace(int index, ItemStack stack, @Nullable Direction direction) {
        return false;
    }

    @Override
    public boolean canTakeItemThroughFace(int index, ItemStack stack, Direction direction) {
        return false;
    }

    @Override
    public boolean canPlaceItem(int slot, ItemStack stack) {
        return false;
    }

    @Override
    public boolean canTakeItem(Container target, int slot, ItemStack stack) {
        return false;
    }

    @Override
    protected void applyImplicitComponents(BlockEntity.DataComponentInput componentInput) {
        // Consume and discard these components instead of importing them into the shared inventory.
        componentInput.get(DataComponents.CONTAINER);
        componentInput.get(DataComponents.CUSTOM_NAME);
        componentInput.get(DataComponents.LOCK);
    }

    @Override
    protected void collectImplicitComponents(DataComponentMap.Builder components) {
        // Never copy the shared inventory into a dropped or pick-block item.
    }

    @Override
    public void removeComponentsFromTag(CompoundTag tag) {
        tag.remove("Items");
        tag.remove("CustomName");
        tag.remove("Lock");
    }
}

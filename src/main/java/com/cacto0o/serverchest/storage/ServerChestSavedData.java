package com.cacto0o.serverchest.storage;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.saveddata.SavedData;

public final class ServerChestSavedData extends SavedData {
    public static final int SLOT_COUNT = 27;
    private static final String DATA_FILE_ID = "serverchest_storage";
    private static final Factory<ServerChestSavedData> FACTORY =
            new Factory<>(ServerChestSavedData::new, ServerChestSavedData::load);

    private final NonNullList<ItemStack> items = NonNullList.withSize(SLOT_COUNT, ItemStack.EMPTY);

    public static ServerChestSavedData get(ServerLevel level) {
        ServerLevel overworld = level.getServer().overworld();
        return overworld.getDataStorage().computeIfAbsent(FACTORY, DATA_FILE_ID);
    }

    public NonNullList<ItemStack> items() {
        return items;
    }

    private static ServerChestSavedData load(CompoundTag tag, HolderLookup.Provider registries) {
        ServerChestSavedData data = new ServerChestSavedData();
        ContainerHelper.loadAllItems(tag, data.items, registries);
        return data;
    }

    @Override
    public CompoundTag save(CompoundTag tag, HolderLookup.Provider registries) {
        return ContainerHelper.saveAllItems(tag, items, registries);
    }
}

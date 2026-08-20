package com.cacto0o.serverchest;

import com.cacto0o.serverchest.block.ServerChestBlock;
import com.cacto0o.serverchest.block.entity.ServerChestBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(ServerChestMod.MOD_ID)
public final class ServerChestMod {
    public static final String MOD_ID = "serverchest";

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MOD_ID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MOD_ID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, MOD_ID);

    public static final DeferredBlock<ServerChestBlock> SERVER_CHEST = BLOCKS.register(
            "server_chest",
            () -> new ServerChestBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ENDER_CHEST))
    );

    public static final DeferredItem<BlockItem> SERVER_CHEST_ITEM = ITEMS.register(
            "server_chest",
            () -> new BlockItem(SERVER_CHEST.get(), new Item.Properties().stacksTo(64))
    );

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ServerChestBlockEntity>> SERVER_CHEST_BLOCK_ENTITY =
            BLOCK_ENTITY_TYPES.register(
                    "server_chest",
                    () -> BlockEntityType.Builder.of(ServerChestBlockEntity::new, SERVER_CHEST.get()).build(null)
            );

    public ServerChestMod(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        BLOCK_ENTITY_TYPES.register(modEventBus);
        modEventBus.addListener(this::addToCreativeTab);
    }

    private void addToCreativeTab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.accept(SERVER_CHEST_ITEM);
        }
    }
}

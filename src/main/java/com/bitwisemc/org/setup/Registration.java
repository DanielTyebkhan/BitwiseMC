package com.bitwisemc.org.setup;

import com.bitwisemc.org.core.AndGateBlock;
import com.bitwisemc.org.core.ExclusiveOrGateBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.bitwisemc.org.BitwiseMC.MODID;

public class Registration {
    private static final DeferredRegister<Block> BLOCKS  = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    private static final DeferredRegister<Item> ITEMS    = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static void init() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(bus);
        ITEMS.register(bus);
    }

    // Base properties
    public static final Item.Properties ITEM_PROPERTIES = new Item.Properties().tab( ModSetup.ITEM_GROUP);

    // Block and Item registrations
    public static final RegistryObject<Block> AND_GATE = BLOCKS.register("and_gate", () -> new AndGateBlock(BlockBehaviour.Properties.of(Material.DECORATION)));
    public static final RegistryObject<Item> AND_GATE_ITEM = fromBlock(AND_GATE);
    public static final RegistryObject<Block> EXCLUSIVE_OR_GATE = BLOCKS.register("xor_gate", () -> new ExclusiveOrGateBlock(BlockBehaviour.Properties.of(Material.DECORATION)));
    public static final RegistryObject<Item> EXCLUSIVE_OR_GATE_ITEM = fromBlock(EXCLUSIVE_OR_GATE);

    public static <B extends Block> RegistryObject<Item> fromBlock(RegistryObject<B> block) {
        return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), ITEM_PROPERTIES));
    }


}

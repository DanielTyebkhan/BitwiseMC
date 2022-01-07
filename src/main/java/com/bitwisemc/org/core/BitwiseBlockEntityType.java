package com.bitwisemc.org.core;

import com.bitwisemc.org.setup.Registration;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ComparatorBlockEntity;

public class BitwiseBlockEntityType<T extends BlockEntity> extends net.minecraftforge.registries.ForgeRegistryEntry<net.minecraft.world.level.block.entity.BlockEntityType<?>> {
    // public static final BlockEntityType<AndGateBlockEntity> AND_GATE = Registry.register("and_gate", BlockEntityType.Builder.of(() -> new AndGateBlock()));
}

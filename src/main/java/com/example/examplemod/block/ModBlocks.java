package com.example.examplemod.block;

import java.util.function.Supplier;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.block.custom.BeeTable;
import com.example.examplemod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {   
    public static final DeferredRegister<Block> BLOCKS =
   DeferredRegister.create(ForgeRegistries.BLOCKS, ExampleMod.MODID);
   
   
   public static final RegistryObject<Block> BEE_TABLE = registerBlock("bee_table",
            () -> new BeeTable(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);
                    
   private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
    RegistryObject<T> toReturn = BLOCKS.register(name, block);
    registerBlockItem(name, toReturn, tab);
    return toReturn;
   }
public static <T extends Block> RegistryObject<Item> registerBlockItem(String name, Supplier<T> block, CreativeModeTab tab) {
    return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
   }
   public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
    
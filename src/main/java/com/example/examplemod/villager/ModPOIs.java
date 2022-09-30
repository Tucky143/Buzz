package com.example.examplemod.villager;


import com.example.examplemod.ExampleMod;

import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModPOIs {
    public static final DeferredRegister<PoiType> POI
            = DeferredRegister.create(ForgeRegistries.POI_TYPES, ExampleMod.MODID);

    public static void register(IEventBus eventBus) {
        POI.register(eventBus);
    }
}
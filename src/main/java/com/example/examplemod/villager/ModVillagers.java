package com.example.examplemod.villager;
import com.example.examplemod.ExampleMod;
import com.google.common.collect.ImmutableSet;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.InvocationTargetException;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES
            = DeferredRegister.create(ForgeRegistries.POI_TYPES, ExampleMod.MODID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS
            = DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, ExampleMod.MODID);

    public static final RegistryObject<PoiType> BEE_KEEPER_POI = POI_TYPES.register("bee_poi",
            () -> new PoiType(ImmutableSet.copyOf(Blocks.BEE_NEST.getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final RegistryObject<VillagerProfession> BEE_KEEPER =
            VILLAGER_PROFESSIONS.register("bee_master",
                    () -> new VillagerProfession("bee_master", x -> x.get() == BEE_KEEPER_POI.get(),
                            x -> x.get() == BEE_KEEPER_POI.get(), ImmutableSet.of(), ImmutableSet.of(),
                            SoundEvents.VILLAGER_WORK_WEAPONSMITH));


    public static void registerPOIs() {
        try {
            ObfuscationReflectionHelper.findMethod(PoiType.class,
                    "registerBlockStates", PoiType.class).invoke(null, BEE_KEEPER_POI.get());
        } catch(InvocationTargetException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
    }

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
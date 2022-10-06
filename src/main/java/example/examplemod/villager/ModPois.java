package example.examplemod.villager;

import example.examplemod.examplemod;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModPois {
    public static final DeferredRegister<PoiType> POI
            = DeferredRegister.create(ForgeRegistries.POI_TYPES, examplemod.MODID);
    public static void register(IEventBus eventBus) {
        POI.register(eventBus);
    }
}
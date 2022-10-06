package example.examplemod;

import com.mojang.logging.LogUtils;

import example.examplemod.villager.ModPois;
import example.examplemod.villager.ModVillagers;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(examplemod.MODID)
public class examplemod
{
    public static final String MODID = "examplemod";
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public examplemod()
    {                              
            IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
            ModPois.register(modEventBus);
            ModVillagers.register(modEventBus);
            

            modEventBus.addListener(this::commonSetup);
    
            MinecraftForge.EVENT_BUS.register(this);
        }
    
        private void commonSetup(final FMLCommonSetupEvent event) {
            event.enqueueWork(() -> {
                ModVillagers.registerPOIs();
            });
    
        }
    
        // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
        @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
        public static class ClientModEvents {
            @SubscribeEvent
            public static void onClientSetup(FMLClientSetupEvent event) {
            
            }
        }
        @Mod.EventBusSubscriber(modid = MODID, bus = Bus.MOD)
public class ModEvents {
}
    }
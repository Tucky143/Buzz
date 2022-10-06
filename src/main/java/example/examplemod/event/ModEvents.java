package example.examplemod.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

import example.examplemod.examplemod;
import example.examplemod.villager.ModVillagers;



@Mod.EventBusSubscriber(modid = examplemod.MODID)
public class ModEvents {

    //Villager Trades
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if(event.getType() == ModVillagers.BEE_MASTER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(Items.FLOWERING_AZALEA, 1);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 2),
                    stack,10,8,0.02F));
        }
        if(event.getType() == ModVillagers.BEE_MASTER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(Items.HONEY_BOTTLE, 1);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.HONEYCOMB, 1),
                    stack,8,8,0.1F));
        }
        if(event.getType() == ModVillagers.BEE_MASTER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(Items.HONEYCOMB, 1);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.HONEY_BOTTLE, 1),
                    stack,8,8,0.1F));
        }
        if(event.getType() == ModVillagers.BEE_MASTER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(Items.BEEHIVE, 1);
                        int villagerLevel = 2;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.HONEYCOMB_BLOCK, 2),
                    stack,9,9,0.2F));
        } 
        if(event.getType() == ModVillagers.BEE_MASTER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(Items.BONE_MEAL, 25);
                        int villagerLevel = 3;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.BEE_NEST, 5),
                    stack,10,10,0.2F));
        }
        }
        // End of Villager trades

    public static void register(IEventBus eventBus) {
    }
    }
package com.sharkron.new_mod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import com.sharkron.new_mod.NewMod;
import com.sharkron.new_mod.block.ModBlocks;

public class ModCreativeTabs {
    // Adding own creative tab
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create
        (Registries.CREATIVE_MODE_TAB, NewMod.MODID);

    // Creates a creative tab with the id "new_mod:new_tab" for the example item, that is placed after the combat tab
    public static final RegistryObject<CreativeModeTab> NEW_MOD_TAB = CREATIVE_MODE_TABS.register("new_tab", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> ModItems.NIGHT_STAR.get().getDefaultInstance())
            .title(Component.translatable("creativetab.new_tab"))
            .displayItems((parameters, output) -> {
                output.accept(ModItems.NIGHT_STAR.get()); // Add items to the tab. For your own tabs, this method is preferred over the event
                output.accept(ModItems.TNT_GUN.get()); 
                output.accept(ModBlocks.TOPAZ_BLOCK.get());
                output.accept(ModBlocks.RAW_SAPPHIRE_BLOCK.get()); 
            }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}

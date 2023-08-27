package com.sharkron.new_mod.item;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import net.minecraft.world.item.Item;
import com.sharkron.new_mod.NewMod;

public class ModItems {
    // basically just registers the MODID's items (like in /give @p [MODID]:shit_block)
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NewMod.MODID);

    // adding the actual items
    public static final RegistryObject<Item> NIGHT_STAR = ITEMS.register("night_star",
        () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TNT_GUN = ITEMS.register("tnt_gun",
        () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}

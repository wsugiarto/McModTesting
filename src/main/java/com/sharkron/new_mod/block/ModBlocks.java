package com.sharkron.new_mod.block;
import com.google.common.base.Supplier;
import com.sharkron.new_mod.NewMod;
import com.sharkron.new_mod.item.ModItems;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    // Deferred register
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, NewMod.MODID);
    
    // Creating the new blocks
    public static final RegistryObject<Block> TOPAZ_BLOCK = registerBlock("topaz_block",
        () -> new Block(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK).sound(SoundType.AMETHYST_CLUSTER)));
        // copying the block property of Gold Block, but using the soundtype of Amethyst Cluster
        // (can also get from ground up, ctrl click the block for template)

    public static final RegistryObject<Block> RAW_SAPPHIRE_BLOCK = registerBlock("raw_sapphire_block",
        () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));

        
    // Register the block itself, AND the item associated with it
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    
    // Register item associated with a block
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }


    // The .register above isn't this one, but instead the one that's from the forge library
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}

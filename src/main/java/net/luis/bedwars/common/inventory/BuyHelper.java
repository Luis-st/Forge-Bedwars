package net.luis.bedwars.common.inventory;

import java.util.ArrayList;
import java.util.List;

import net.luis.bedwars.common.base.villager.VillagerTradeHelper;
import net.luis.bedwars.common.inventory.container.VillagerContainer.Page;
import net.luis.bedwars.init.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class BuyHelper {
	
	private final PlayerEntity player;
	private final Page page;
	private final VillagerTradeHelper tradeHelper;
	
	public BuyHelper(PlayerEntity player, Page page) {
		
		this.player = player;
		this.page = page;
		this.tradeHelper = new VillagerTradeHelper();
		
	}
	
	public BuyingItem getBuyingItem(int slot) {
		
		switch (this.page) {
		case BLOCKS: return this.getBlockBuyingItem(slot);
		case WEAPONS: return this.getWeaponBuyingItem(slot);
		case ARMOR: return this.getArmorBuyingItem(slot);
		case TOOLS: return this.getToolsBuyingItem(slot);
		case BOWS: return this.getBowsBuyingItem(slot);
		case FOOT: return this.getFoodBuyingItem(slot);
		case POTIONS: return this.getPotionsBuyingItem(slot);
		case MISC: return this.getMiscBuyingItem(slot);
		case DEFAULT: return null;
		}
		
		return null;
		
	}
	
	public BuyingItem getBlockBuyingItem(int slot) {
		
		switch (slot) {
		case 38: return new BuyingItem(new ItemStack(Items.CUT_SANDSTONE, 2), this.creatBronze(1));
		case 39: return new BuyingItem(new ItemStack(Items.PACKED_ICE), this.creatBronze(4));	
		case 40: return new BuyingItem(new ItemStack(Items.GLASS), this.creatBronze(2));
		case 41: return new BuyingItem(new ItemStack(Items.SANDSTONE_STAIRS), this.creatBronze(2));
		case 42: return new BuyingItem(new ItemStack(Items.END_STONE), this.creatBronze(8));
		}
		
		return null;
		
	}
	
	public BuyingItem getWeaponBuyingItem(int slot) {
		
		switch (slot) {
		case 38: return new BuyingItem(this.tradeHelper.enchantedStick(), this.creatBronze(8));
		case 39: return new BuyingItem(this.tradeHelper.enchantedGoldSword1(), this.creatIron(1));
		case 40: return new BuyingItem(this.tradeHelper.enchantedGoldSword2(), this.creatIron(3));	
		case 41: return new BuyingItem(this.tradeHelper.enchantedIronSword1(), this.creatGold(5));
		case 42: return new BuyingItem(this.tradeHelper.enchantedIronSword2(), this.creatGold(9));
		}
		
		return null;
		
	}
	
	public BuyingItem getArmorBuyingItem(int slot) {
		
		switch (slot) {
		case 27: return new BuyingItem(this.tradeHelper.enchantedLeatherArmor(Items.LEATHER_HELMET), this.creatBronze(1));
		case 36: return new BuyingItem(this.tradeHelper.enchantedLeatherArmor(Items.LEATHER_LEGGINGS), this.creatBronze(1));
		case 45: return new BuyingItem(this.tradeHelper.enchantedLeatherArmor(Items.LEATHER_BOOTS), this.creatBronze(1));
		case 29: return new BuyingItem(this.tradeHelper.enchantedChainArmor(Items.CHAINMAIL_HELMET), this.creatIron(2));
		case 38: return new BuyingItem(this.tradeHelper.enchantedChainArmor(Items.CHAINMAIL_LEGGINGS), this.creatIron(2));
		case 47: return new BuyingItem(this.tradeHelper.enchantedGoldBoots(), this.creatIron(4));
		case 41: return new BuyingItem(this.tradeHelper.enchantedChainChestplate1(), this.creatIron(1));	
		case 42: return new BuyingItem(this.tradeHelper.enchantedChainChestplate2(), this.creatIron(3));
		case 43: return new BuyingItem(this.tradeHelper.enchantedChainChestplate3(), this.creatIron(7));
		case 44: return new BuyingItem(this.tradeHelper.enchantedChainChestplate4(), this.creatGold(4));
		}
		
		return null;
		
	}
	
	public BuyingItem getToolsBuyingItem(int slot) {
		
		switch (slot) {
		case 38: return new BuyingItem(this.tradeHelper.enchantedWoodPickaxe(), this.creatBronze(4));
		case 39: return new BuyingItem(this.tradeHelper.enchantedStonePickaxe(), this.creatIron(2));
		case 40: return new BuyingItem(this.tradeHelper.enchantedIronPickaxe(), this.creatGold(1));	
		case 41: return new BuyingItem(this.tradeHelper.fishingRod(), this.creatIron(5));
		case 42: return new BuyingItem(this.tradeHelper.enchantedFlintAndSteel(), this.creatIron(3));
		}
		
		return null;
		
	}
	
	public BuyingItem getBowsBuyingItem(int slot) {
		
		switch (slot) {
		case 38: return new BuyingItem(this.tradeHelper.enchantedBow1(), this.creatGold(3));
		case 39: return new BuyingItem(this.tradeHelper.enchantedBow2(), this.creatGold(7));
		case 40: return new BuyingItem(this.tradeHelper.enchantedBow3(), this.creatGold(13));	
		case 42: return new BuyingItem(new ItemStack(Items.ARROW), this.creatGold(1));
		}
		
		return null;
		
	}
	
	public BuyingItem getFoodBuyingItem(int slot) {
		
		switch (slot) {
		case 39: return new BuyingItem(new ItemStack(Items.APPLE), this.creatBronze(1));
		case 40: return new BuyingItem(new ItemStack(Items.COOKED_PORKCHOP), this.creatBronze(2));	
		case 41: return new BuyingItem(new ItemStack(Items.GOLDEN_APPLE), this.creatGold(2));
		}
		
		return null;
		
	}
	
	public BuyingItem getPotionsBuyingItem(int slot) {
		
		switch (slot) {
		case 37: return new BuyingItem(this.tradeHelper.potionHealing1(), this.creatIron(3));
		case 38: return new BuyingItem(this.tradeHelper.potionHealing2(), this.creatIron(5));
		case 39: return new BuyingItem(this.tradeHelper.potionLeaping(), this.creatIron(7));	
		case 40: return new BuyingItem(this.tradeHelper.potionSwiftness(), this.creatIron(7));
		case 42: return new BuyingItem(this.tradeHelper.potionStrength(), this.creatGold(7));
		case 43: return new BuyingItem(this.tradeHelper.potionSlowFalling(), this.creatGold(4));
		}
		
		return null;
		
	}
	
	public BuyingItem getMiscBuyingItem(int slot) {
		
		switch (slot) {
		case 37: return new BuyingItem(new ItemStack(Items.LADDER), this.creatBronze(2));
		case 38: return new BuyingItem(new ItemStack(Items.COBWEB), this.creatBronze(8));
		case 39: return new BuyingItem(new ItemStack(ModItems.GUNPOWDER.get()), this.creatIron(3));	
		case 40: return new BuyingItem(new ItemStack(ModItems.BLAZE_ROD.get()), this.creatGold(3));
		case 41: return new BuyingItem(new ItemStack(Items.ENDER_PEARL), this.creatGold(11));
		case 42: return new BuyingItem(new ItemStack(Items.CHEST), this.creatIron(1));
		case 43: return new BuyingItem(new ItemStack(Items.ENDER_CHEST), this.creatGold(1));
		}
		
		return null;
		
	}
	
	public boolean hasItemToBuy(Item item, int count) {
		
		IItemHandler itemHandler = player.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).orElseThrow(
				() -> new NullPointerException());
		
		for (int i = 0; i < itemHandler.getSlots(); i++) {
			
			ItemStack stack = itemHandler.getStackInSlot(i);
			
			if (stack.getItem() == item && stack.getCount() >= count) {
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	public List<ItemStack> getAllItemsToBye(Item item) {
		
		List<ItemStack> stacks = new ArrayList<ItemStack>();
		IItemHandler itemHandler = player.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).orElseThrow(
				() -> new NullPointerException());
		
		for (int i = 0; i < itemHandler.getSlots(); i++) {
			
			ItemStack stack = itemHandler.getStackInSlot(i);
			
			if (stack.getItem() == item) {
				
				stacks.add(stack);
				
			}
			
		}
		
		return stacks;
		
	}
	
	protected ItemStack creatBronze(int count) {
		
		return new ItemStack(Items.BRICK, count);
		
	}
	
	protected ItemStack creatIron(int count) {
		
		return new ItemStack(Items.IRON_INGOT, count);
		
	}
	
	protected ItemStack creatGold(int count) {
		
		return new ItemStack(Items.GOLD_INGOT, count);
		
	}

}

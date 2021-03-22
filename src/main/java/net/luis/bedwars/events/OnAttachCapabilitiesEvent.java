package net.luis.bedwars.events;

import net.luis.bedwars.Bedwars;
import net.luis.bedwars.init.ModCapability;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = Bedwars.MOD_ID, bus = Bus.FORGE)
public class OnAttachCapabilitiesEvent {
	
	@SubscribeEvent
	public static void AttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
		
		if (event.getObject() instanceof PlayerEntity) {
			
			event.addCapability(new ResourceLocation(Bedwars.MOD_ID, "bedwars_capability"), new ModCapability.BagpackProvider());
			
		}
		
	}

}

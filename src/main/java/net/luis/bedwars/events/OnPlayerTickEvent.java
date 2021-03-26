package net.luis.bedwars.events;

import net.luis.bedwars.Bedwars;
import net.luis.bedwars.init.ModBedwarsCapability;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = Bedwars.MOD_ID, bus = Bus.FORGE)
public class OnPlayerTickEvent {
	
	@SubscribeEvent
	public static void WorldTick(TickEvent.PlayerTickEvent event) {
		
		PlayerEntity player = event.player;
		
		if (player.getEntityWorld().getGameTime() % 20 == 0) {
			
			if (event.phase == Phase.START && player instanceof ServerPlayerEntity) {
				
				player.getCapability(ModBedwarsCapability.BEDWARS, null).ifPresent(bedwarsHandler -> {
					
					if (bedwarsHandler.getGunpowderCooldown() > 0) {
						
						bedwarsHandler.setGunpowderCooldown(bedwarsHandler.getGunpowderCooldown() - 1);
						
					}
					
				});
				
			}
			
		}
		
	}

}
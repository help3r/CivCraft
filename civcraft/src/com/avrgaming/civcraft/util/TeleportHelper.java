package com.avrgaming.civcraft.util;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;

import com.earth2me.essentials.I18n;
import com.earth2me.essentials.Trade;
import com.earth2me.essentials.User;

public class TeleportHelper {
	
	public static void TeleportLocation(String Name, Location loc) throws Exception
	{
		net.ess3.api.IEssentials cc = (net.ess3.api.IEssentials) Bukkit.getPluginManager().getPlugin("Essentials");
	
		User player = cc.getUser(Name);
		if (!(player.isTeleportEnabled())) {
			throw new Exception(I18n.tl("teleportDisabled", new Object[] { player.getDisplayName() }));
		}
		
		Trade charge = new Trade("tp", cc);
		try{
			player.getTeleport().teleport(loc, charge, TeleportCause.COMMAND);
		}catch (Exception e){
			player.sendMessage(I18n.tl("cooldownWithMessage", new Object[] {e.getMessage()}));
		}
	}
}

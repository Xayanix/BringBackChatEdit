package pl.xayanix.bbce.bungee.listeners;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PluginMessageEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

/*
    created by: Xayanix at 2022-06-21 12:23
*/
public class PluginMessageListener implements Listener {

    @EventHandler
    public void onChat(PluginMessageEvent event){
        if(event.getSender() instanceof ProxiedPlayer && event.getTag().equalsIgnoreCase("bbce:chatsign"))
            event.setCancelled(true);

    }

}

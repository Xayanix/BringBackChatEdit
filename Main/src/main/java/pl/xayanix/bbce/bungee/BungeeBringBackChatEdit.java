package pl.xayanix.bbce.bungee;

import net.md_5.bungee.api.plugin.Plugin;
import pl.xayanix.bbce.bungee.listeners.ChatListener;
import pl.xayanix.bbce.bungee.listeners.PluginMessageListener;

/*
    created by: Xayanix at 2022-06-21 12:21
*/
public class BungeeBringBackChatEdit extends Plugin {

    @Override
    public void onEnable(){
        this.getProxy().getPluginManager().registerListener(this, new ChatListener());
        this.getProxy().getPluginManager().registerListener(this, new PluginMessageListener());
        this.getProxy().registerChannel("bbce:chatsign");
    }

}

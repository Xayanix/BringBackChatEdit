package pl.xayanix.bbce.bukkit;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.apache.commons.io.*;

/*
    created by: Xayanix at 2022-06-21 12:29
*/
public class BukkitBringBackChatEdit extends JavaPlugin implements PluginMessageListener {

    @Override
    public void onEnable(){
        Bukkit.getMessenger().registerIncomingPluginChannel(this, "bbce:chatsign", this);
    }


    public void onPluginMessageReceived(String s, Player player, byte[] bytes) {
        if(s.equalsIgnoreCase("bbce:chatsign")){
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            byteArrayInputStream.skip(2);
            try {
                String message = IOUtils.toString(byteArrayInputStream, StandardCharsets.UTF_8);
                player.chat(message);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}

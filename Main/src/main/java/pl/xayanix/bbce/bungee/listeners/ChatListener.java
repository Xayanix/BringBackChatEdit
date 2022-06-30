package pl.xayanix.bbce.bungee.listeners;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import net.md_5.bungee.event.EventPriority;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/*
    created by: Xayanix at 2022-06-21 12:23
*/
public class ChatListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onChat(ChatEvent event) throws IOException {
        if(event.isCommand() || event.isCancelled() || event.isProxyCommand()) return;

        ProxiedPlayer player = (ProxiedPlayer) event.getSender();
        if(player.getPendingConnection().getVersion() < 759)
            return;

        event.setCancelled(true);
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        try (DataOutputStream out = new DataOutputStream(b)) {
            out.writeUTF(event.getMessage());
            player.getServer().sendData("bbce:chatsign", b.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

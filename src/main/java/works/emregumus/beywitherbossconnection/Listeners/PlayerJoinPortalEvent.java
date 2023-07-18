package works.emregumus.beywitherbossconnection.Listeners;

import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.guis.Gui;
import dev.triumphteam.gui.guis.GuiItem;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import works.emregumus.beywitherbossconnection.BeyWitherBossConnection;

import java.util.List;

public class PlayerJoinPortalEvent implements Listener {

    @EventHandler
    public void onPlayerJoinPortalEvent(PlayerPortalEvent event) {
        event.setCancelled(true);

        Player player = event.getPlayer();
        Location from = event.getFrom();

        World world = from.getWorld();
        int x = BeyWitherBossConnection.getInstance().getConfigFile().getInt("Boss.Options.Portal.X");
        int y = BeyWitherBossConnection.getInstance().getConfigFile().getInt("Boss.Options.Portal.Y");
        int z = BeyWitherBossConnection.getInstance().getConfigFile().getInt("Boss.Options.Portal.Z");
        float yaw = BeyWitherBossConnection.getInstance().getConfigFile().getInt("Boss.Options.Portal.Yaw");
        float pitch = BeyWitherBossConnection.getInstance().getConfigFile().getInt("Boss.Options.Portal.Pitch");
        Location location = new Location(world, from.getX() - x, from.getY() - y, from.getZ() - z, from.getYaw() - yaw, from.getPitch() - pitch);
        player.teleport(location);

        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), BeyWitherBossConnection.getInstance().getConfigFile().getStringList("Commands").toString().replace("%player%", player.getName()));
    }

}

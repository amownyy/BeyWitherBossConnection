package works.emregumus.beywitherbossconnection;

import org.bukkit.plugin.java.JavaPlugin;
import works.emregumus.beywitherbossconnection.Api.Config.FileCreator;
import works.emregumus.beywitherbossconnection.Listeners.PlayerJoinPortalEvent;

public final class BeyWitherBossConnection extends JavaPlugin {

    public static BeyWitherBossConnection instance;

    private FileCreator config;

    @Override
    public void onEnable() {
        instance = this;

        config = new FileCreator(this, "config.yml");

        getServer().getPluginManager().registerEvents(new PlayerJoinPortalEvent(), this);
    }

    @Override
    public void onDisable() {
        instance = null;
    }
    public static BeyWitherBossConnection getInstance() {
        return instance;
    }
    public FileCreator getConfigFile() {
        return config;
    }
}

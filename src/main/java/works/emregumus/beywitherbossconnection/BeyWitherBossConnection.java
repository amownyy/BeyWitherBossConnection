package works.emregumus.beywitherbossconnection;

import org.bukkit.plugin.java.JavaPlugin;

public final class BeyWitherBossConnection extends JavaPlugin {

    public static BeyWitherBossConnection instance;

    @Override
    public void onEnable() {
        instance = this;
    }

    @Override
    public void onDisable() {
        instance = null;
    }
    public static BeyWitherBossConnection getInstance() {
        return instance;
    }
}

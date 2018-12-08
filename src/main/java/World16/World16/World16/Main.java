package World16.World16.World16;

import Commands.*;
import Events.OnJoin;
import Events.OnJoinTittle;
import Events.OnLeave;
import Utils.Translate;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.plugin.PluginBase;

import java.util.HashMap;

public class Main extends PluginBase {

  public static Main plugin;
  HashMap<String, String> keyDataM = OnJoin.keydatam;

  public static Main getInstance() {
    return plugin;
  }

  // MySQL mysql = new MySQL(Main.plugin.getConfig().getString("MysqlHOST"),
  // Main.plugin.getConfig().getString("MysqlDATABASE"),
  // Main.plugin.getConfig().getString("MysqlUSER"),
  // Main.plugin.getConfig().getString("MysqlPASSWORD"));
  // GOT THE MYSQL API AT https://www.spigotmc.org/resources/simple-easy-mysql-api.36447/
  // GOT THE TITLE API AT https://www.spigotmc.org/resources/titleapi-1-8-1-13.1325/
  public void onLoad() {
    plugin = this;
  }

  @Override
  public void onEnable() {
    plugin = this;
    YmlConfigGen();
    FileConfigGen();
    regEvents();
    regCommands();
    getLogger().info("[World1-6Essentials] is now loaded!");
    // START OF UPDATER
    // FROM https://www.spigotmc.org/resources/api-pluginupdater-with-website.5578/
    // FINISH OF UPDATER
  }

  public void onDisable() {
    //JUST IN CASE
    keyDataM.clear();
    getLogger().info("[World1-6Essentials] is now disabled.");
  }

  public void regCommands() {
    new afk("afk");
    new bed("bed");
    new clear("clear");
    new colors("colors");
    new day("day");
    new echest("echest");
    new feed("feed");
    new fly("fly");
    //
    new gmc("gmc");
    new gms("gms");
    new gmsp("gmsp");
    //
    new heal("heal");
    new night("night");
    new sign("sign");
    new debug("debug1-6");
  }

  public void regEvents() {
    new OnJoin(this);
//    new OnJoinTittle(this); -> TODO TO FIX
    new OnLeave(this);
  }

  public void FileConfigGen() {
    this.saveDefaultConfig();
    this.saveConfig();
  }

  public void YmlConfigGen() {
  }

  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    {
      Player p = (Player) sender;

      if (cmd.getName().equalsIgnoreCase("World1-6Ess")) {
        if (args.length == 0) {
          p.sendMessage(Translate.chat("&6Made By Andrew121410 My -> Discord: Andrew121410#2035"));
          return true;
        }
      }
    }
    return true;
  }
}
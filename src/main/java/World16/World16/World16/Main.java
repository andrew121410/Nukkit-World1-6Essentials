package World16.World16.World16;

import Commands.afk;
import Commands.bed;
import Commands.clear;
import Commands.colors;
import Commands.day;
import Commands.echest;
import Commands.feed;
import Commands.fly;
import Commands.gmc;
import Commands.gms;
import Commands.gmsp;
import Commands.heal;
import Commands.night;
import Commands.setspawn;
import Commands.sign;
import Commands.spawn;
import Events.OnDeathEvent;
import Events.OnJoinEvent;
import Events.OnLeaveEvent;
import Utils.CustomYmlManger;
import Utils.Translate;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.plugin.PluginBase;

public class Main extends PluginBase {

  private static Main plugin;
  private CustomYmlManger customyml;
//  HashMap<String, String> keyDataM = OnJoinEvent.keydatam;

  public static Main getInstance() {
    return plugin;
  }

  public void onLoad() {
    plugin = this;
  }

  @Override
  public void onEnable() {
    plugin = this;
    CustomYmlConfigGEN();
    FileConfigGen();
    regEvents();
    regCommands();
    getLogger().info("[World1-6Essentials] is now loaded!");
  }

  public void onDisable() {
    //JUST IN CASE
//    keyDataM.clear();
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
//    new debug("debug1-6");
    new setspawn("setspawn", customyml);
    new spawn("spawn", customyml);
  }

  public void regEvents() {
    new OnJoinEvent(this);
//    new OnJoinTittleEvent(this); -> TODO TO FIX
    new OnLeaveEvent(this);
    new OnDeathEvent(this);
  }

  public void FileConfigGen() {
    this.saveDefaultConfig();
    this.saveConfig();
  }

  public void CustomYmlConfigGEN() {
    customyml = new CustomYmlManger();
    // Shit.yml
    customyml.setupshit();
    customyml.saveshit();
    customyml.reloadshit();
    // END OF Shit.yml
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

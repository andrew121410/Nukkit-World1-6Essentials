package World16.Commands;

import World16.Main.Main;
import World16.Utils.API;
import World16.Utils.Translate;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;

public class night extends Command {

  private static Main plugin = Main.getInstance();
  API api = new API();
  
  public night(String name) {
    super(name);
    this.setPermission("world16." + name + "." + "permission");
    this.setDescription("Set's the time too night.");
    this.plugin.getServer().getCommandMap().register("night", this);
  }

  @Override
  public boolean execute(CommandSender sender, String label, String[] args) {
    if (!(sender instanceof Player)) {
      sender.sendMessage("Only Players Can Use This Command.");
      return true;
    }

    Player p = (Player) sender;

    if (!p.hasPermission("world16.night.permission")) {
      p.sendMessage(api.PERMISSION_ERROR_MESSAGE);
      return true;
    }
    p.getLevel().setTime(13000);
    p.sendMessage(Translate.chat("&6The time was set to &9night&r."));
    return true;
  }
}

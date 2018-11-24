package Commands;

import Utils.API;
import Utils.Translate;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;

public class day extends Command {

  API api = new API();
  
  public day(String name) {
    super(name);
    this.setPermission("world16." + name + "." + "permission");
  }

  @Override
  public boolean execute(CommandSender sender, String label, String[] args) {
    if (!(sender instanceof Player)) {
      sender.sendMessage("Only Players Can Use This Command.");
      return true;
    }

    Player p = (Player) sender;

    if (!p.hasPermission("world16.day.permission")) {
      p.sendMessage(api.PERMISSION_ERROR_MESSAGE);
      return true;
    }
    p.getLevel().setTime(1000);
    p.sendMessage(Translate.chat("&6The time was set to &eday&r."));
    return true;
  }
}

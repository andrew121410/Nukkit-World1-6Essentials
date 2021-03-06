package World16.Utils;

import World16.Commands.afk;
import World16.Commands.fly;
import World16.Events.OnDeathEvent;
import World16.Main.Main;
import cn.nukkit.Player;
import cn.nukkit.level.Level;
import cn.nukkit.level.Location;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class API {

    //    HashMap<String, String> keyDataM = OnJoinEvent.keyDataM;
    LinkedHashMap<String, Location> backmap = OnDeathEvent.backmap;
    ArrayList<String> Afk1 = afk.Afk;
    ArrayList<String> Fly1 = fly.Fly;

    private static Main plugin = Main.getInstance();
    private CustomYmlManger configinstance = null;

//    ViaAPI viaapi = Via.getAPI(); // https://docs.viaversion.com/display/VIAVERSION/Basic+API+usage

    //finals
    public static final Integer VERSION = 4;
    public static final String DATE_OF_VERSION = "1/12/2019";
    public static final String PREFIX = "[&9World1-6Ess&r]";
    public static final String USELESS = "" + PREFIX + "->[&bUSELESS&r]";
//    public static final String TOO_DAMN_OLD = "Your mc version is too damn old 1.11 up too 1.13.2 please.";
    public static final String SOMETHING_WENT_WRONG = "Something went wrong.";
    public static final String PERMISSION_ERROR_MESSAGE = Translate.chat(PREFIX + " &cYou Do Not Have Permission To Use This Command.");

    // FOR MYSQL
    private String HOST = plugin.getConfig().getString("MysqlHOST");
    private String DATABASE = plugin.getConfig().getString("MysqlDATABASE");
    private String USER = plugin.getConfig().getString("MysqlUSER");
    private String PASSWORD = plugin.getConfig().getString("MysqlPASSWORD");
    private String PORT = plugin.getConfig().getString("MysqlPORT");
    // END MYSQL

    // MAIN
    public API() {
    }

    public API(CustomYmlManger configinstance) {
        this.configinstance = configinstance;
    }

    // END MAIN
    // START OF MYSQL

    public String getHOST() {
        if (this.HOST != null) {
            return this.HOST;
        } else {
            return null;
        }
    }

    public String getDATABASE() {
        if (this.DATABASE != null) {
            return this.DATABASE;
        } else {
            return null;
        }
    }

    public String getUSER() {
        if (this.USER != null) {
            return this.USER;
        } else {
            return null;
        }
    }

    public String getPASSWORD() {
        if (this.PASSWORD != null) {
            return this.PASSWORD;
        } else {
            return null;
        }
    }

    public String getPORT() {
        if (this.PORT != null) {
            return this.PORT;
        } else {
            return null;
        }
    }
    // END OF MYSQL

    public boolean isAfk(Player p) {
        if (Afk1.contains(p.getDisplayName())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFlying(Player p) {
        if (Fly1.contains(p.getDisplayName())/** || p.isFlying()**/) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<String> getAfkArrayList() {
        return Afk1;
    }

    public void clearArrayListAndHashMaps(Player p) {
//        keyDataM.remove(p.getDisplayName());
//        ClearHashMapMessage("World16.Events.OnJoinEvent.keyDataM", p);
        backmap.remove(p.getDisplayName());
        ClearHashMapMessage("World16.Events.OnDeathEvent.backmap", p);
        Afk1.remove(p.getDisplayName());
        ClearArrayListMessage("World16.Commands.afk.Afk", p);
        Fly1.remove(p.getDisplayName());
        ClearArrayListMessage("World16.Commands.fly.Fly", p);
    }

    public void clearArrayListAndHashMaps() {
//        keyDataM.clear();
//        ClearHashMapMessage("World16.Events.OnJoinEvent.keyDataM");
        backmap.clear();
        ClearHashMapMessage("World16.Events.OnDeathEvent.backmap");
        Afk1.clear();
        ClearArrayListMessage("World16.Commands.afk.Afk");
        Fly1.clear();
        ClearArrayListMessage("World16.Commands.fly.Fly");
    }

    public void clearAllHashMaps(Player p) {
//        keyDataM.remove(p.getDisplayName());
//        ClearHashMapMessage("World16.Events.OnJoinEvent.keyDataM", p);
        backmap.clear();
        ClearHashMapMessage("World16.Events.OnDeathEvent.backmap", p);
    }

    public void clearAllHashMaps() {
//        keyDataM.clear();
//        ClearHashMapMessage("World16.Events.OnJoinEvent.keyDataM");
        backmap.clear();
        ClearHashMapMessage("World16.Events.OnDeathEvent.backmap");
    }

    public void clearAllArrayList(Player p) {
        Afk1.remove(p.getDisplayName());
        ClearArrayListMessage("World16.Commands.afk.Afk", p);
        Fly1.remove(p.getDisplayName());
        ClearArrayListMessage("World16.Commands.fly.Fly", p);
    }

    public void clearAllArrayList() {
        Afk1.clear();
        ClearArrayListMessage("World16.Commands.afk.Afk");
        Fly1.clear();
        ClearArrayListMessage("World16.Commands.fly.Fly");
    }

    public String FormatTime(LocalDateTime time) {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
        String formattedDate = time.format(myFormatObj);

        return formattedDate;
    }

    public String Time() {
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
        String formattedDate = time.format(myFormatObj);

        return formattedDate;
    }

    private String spawnname;
    private String spawnname1;

    public Location GetSpawn(String spawnname) {
        this.spawnname = spawnname.toLowerCase();
        double x = this.configinstance.getshit().getInt("Spawn." + this.spawnname + ".Data.X");
        double y = this.configinstance.getshit().getInt("Spawn." + this.spawnname + ".Data.Y");
        double z = this.configinstance.getshit().getInt("Spawn." + this.spawnname + ".Data.Z");
        float yaw = (float) this.configinstance.getshit()
            .getInt("Spawn." + this.spawnname + ".Data.Yaw");
        float pitch = (float) this.configinstance.getshit()
            .getInt("Spawn." + this.spawnname + ".Data.Pitch");
        Level world = this.plugin.getServer()
            .getLevelByName(
                this.configinstance.getshit().getString("Spawn." + this.spawnname + ".Data.World"));

        Location spawn = new Location(x, y, z, yaw, pitch, world);
        return spawn;
    }

    public void SetSpawn(Player p, double x, double y, double z, double yaw, double pitch,
        String worldname, String spawnname) {
        this.spawnname1 = spawnname.toLowerCase();
        this.configinstance.getshit().set("Spawn." + this.spawnname1 + ".Data.X", x);
        this.configinstance.getshit().set("Spawn." + this.spawnname1 + ".Data.Y", y);
        this.configinstance.getshit().set("Spawn." + this.spawnname1 + ".Data.Z", z);
        this.configinstance.getshit().set("Spawn." + this.spawnname1 + ".Data.Yaw", yaw);
        this.configinstance.getshit().set("Spawn." + this.spawnname1 + ".Data.Pitch", pitch);
        this.configinstance.getshit().set("Spawn." + this.spawnname1 + ".Data.World", worldname);
        this.configinstance.getshit()
            .set("Spawn." + this.spawnname1 + ".Player.Data.NAME", p.getDisplayName());
        this.configinstance.getshit()
            .set("Spawn." + this.spawnname1 + ".Player.Data.UUID", p.getUniqueId().toString());
        this.configinstance.reloadshit();
    }

    public void PermissionErrorMessage(Player p) {
        p.sendMessage(
            Translate.chat(this.PREFIX + " &cYou Do Not Have Permission To Use This Command."));
    }

    public void ClearHashMapMessage(String place) {
        this.plugin.getServer().getConsoleSender().sendMessage(Translate.chat(this.USELESS
            + " Class: World16.Utils.API has cleared the HashMap of " + place
            + " For EVERY PLAYER"));
    }

    public void ClearHashMapMessage(String place, Player p) {
        this.plugin.getServer().getConsoleSender().sendMessage(Translate.chat(this.USELESS
            + " Class: World16.Utils.API has cleared the HashMap of " + place + " For Player: " + p
            .getDisplayName()));
    }

    public void ClearArrayListMessage(String place) {
        this.plugin.getServer().getConsoleSender().sendMessage(Translate.chat(this.USELESS
            + " Class: World16.Utils.API has cleared the ArrayList of " + place
            + " For EVERY PLAYER"));
    }

    public void ClearArrayListMessage(String place, Player p) {
        this.plugin.getServer().getConsoleSender().sendMessage(Translate.chat(this.USELESS
            + " Class: World16.Utils.API has cleared the ArrayList of " + place + " For Player: "
            + p
            .getDisplayName()));
    }
}
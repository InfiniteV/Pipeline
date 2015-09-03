package org.pipelinemc.Pipeline;

import org.pipelinemc.Pipeline.configuration.Config;
import org.pipelinemc.Pipeline.configuration.ConfigManager;

import java.io.BufferedReader;

public class Server {
    private Config serverconfig;
    private boolean online;
    private boolean pvp;
    private int gamemode;
    private boolean spawnnpc;
    private boolean spawnmob;
    private int port;
    private int viewdistance;
    private String motd;
    private String ip;

    public Server() {

    }

    public void loadServer() {
        serverconfig = ConfigManager.getNewConfig("server.yml", "");//yml for proper formatting.
        createConfig();
    }

    public void startConsole(BufferedReader reader) {
        new ConsoleReader();
    }

    public void startServer() {

    }

    private void createConfig() {
        online = serverconfig.getBoolean("online-mode");
        pvp = serverconfig.getBoolean("pvp");
        ip = serverconfig.getString("server-ip");
        port = serverconfig.getInt("server-port");
        gamemode = serverconfig.getInt("gamemode");
        spawnnpc = serverconfig.getBoolean("spawn-npc");
        spawnmob = serverconfig.getBoolean("spawn-mobs");
        viewdistance = serverconfig.getInt("view-distance");
        motd = serverconfig.getString("motd");
    }

    public boolean isOnlineMode() {
        return online;
    }

    public boolean pvpEnabled() {
        return pvp;
    }

    public boolean spawnMobs() {
        return spawnmob;
    }

    public boolean spawnNPC() {
        return spawnnpc;
    }

    public String getIP() {
        return ip;
    }

    public String getMOTD() {
        return motd;
    }

    public void setMOTD(String newMOTD) {
        this.motd = newMOTD;
    }

    public int getPort() {
        return port;
    }

    public int getGamemode() {
        return gamemode;
    }

    public int getViewDistance() {
        return viewdistance;
    }
}

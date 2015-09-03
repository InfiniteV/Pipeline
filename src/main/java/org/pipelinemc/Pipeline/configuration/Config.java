package org.pipelinemc.Pipeline.configuration;

import org.pipelinemc.Pipeline.configuration.configuration.ConfigurationSection;
import org.pipelinemc.Pipeline.configuration.file.FileConfiguration;
import org.pipelinemc.Pipeline.configuration.file.YamlConfiguration;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public class Config {
    private ConfigManager manager;

    private File file;
    private FileConfiguration config;

    public Config(File configFile) {
        this.manager = new ConfigManager();
        this.file = configFile;
        this.config = YamlConfiguration.loadConfiguration(configFile);
    }

    public Object get(String path) {
        return this.config.get(path);
    }

    public String getString(String path) {
        return this.config.getString(path);
    }

    public int getInt(String path) {
        return this.config.getInt(path);
    }

    public boolean getBoolean(String path) {
        return this.config.getBoolean(path);
    }

    public void createSection(String path) {
        this.config.createSection(path);
    }

    public ConfigurationSection getConfigurationSection(String path) {
        return this.config.getConfigurationSection(path);
    }

    public double getDouble(String path) {
        return this.config.getDouble(path);
    }

    public BigDecimal getDecimal(String path) {
        return new BigDecimal(getDouble(path));
    }

    public List<?> getList(String path) {
        return this.config.getList(path);
    }

    public List<String> getStringList(String path) {
        return this.config.getStringList(path);
    }

    public boolean contains(String path) {
        return this.config.contains(path);
    }

    public Set<String> getKeys() {
        return this.config.getKeys(false);
    }

    public void removeKey(String path) {
        this.config.set(path, null);
        this.saveConfig();
    }

    public void add(String path, Object value) {
        if (!this.config.contains(path)) {
            this.config.set(path, value);
            this.saveConfig();
        }
    }

    public void set(String path, Object value) {
        this.config.set(path, value);
        this.saveConfig();
    }

    public void saveConfig() {
        String config = this.config.saveToString();
        ConfigManager.saveConfig(config, this.file);
        this.config = YamlConfiguration.loadConfiguration(file);
    }
}

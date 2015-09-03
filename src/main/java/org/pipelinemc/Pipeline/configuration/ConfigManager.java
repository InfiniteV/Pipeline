package org.pipelinemc.Pipeline.configuration;

import org.pipelinemc.Pipeline.plugin.JavaPlugin;

import java.io.*;
import java.nio.charset.Charset;

public class ConfigManager {
    public static Config getNewConfig(String filePath, JavaPlugin p) {
        File file = getConfigFile(filePath, p);

        if (!file.exists()) {
            try {
                file.getParentFile().mkdirs();
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Config config = new Config(file);
        return config;
    }

    public static Config getNewConfig(String filePath, String path) {
        File file = getConfigFile(filePath, path);

        if (!file.exists()) {
            try {
                file.getParentFile().mkdirs();
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Config config = new Config(file);
        return config;
    }

    private static File getConfigFile(String file, JavaPlugin p) {
        if (file.isEmpty())
            return null;
        File configFile;
        if (file.contains("/"))
            if (file.startsWith("/"))
                configFile = new File(p.getDataFolder() + file.replace("/", File.separator));
            else
                configFile = new File(p.getDataFolder() + File.separator + file.replace("/", File.separator));
        else
            configFile = new File(p.getDataFolder(), file);
        return configFile;
    }

    private static File getConfigFile(String file, String path) {
        if (file.isEmpty())
            return null;
        return new File(path, file);
    }

    public static InputStream getConfigContent(File file) {
        if (!file.exists())
            return null;
        try {
            String addLine;
            String currentLine;
            String mName = getPluginName();
            StringBuilder whole = new StringBuilder("");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((currentLine = reader.readLine()) != null)
                whole.append(currentLine + "\n");
            String config = whole.toString();
            InputStream configStream = new ByteArrayInputStream(config.getBytes(Charset.forName("UTF-8")));
            reader.close();
            return configStream;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static InputStream getConfigContent(String filePath, JavaPlugin p) {
        return getConfigContent(getConfigFile(filePath, p));
    }

    private static String prepareConfigString(String configString) {
        String[] lines = configString.split("\n");
        StringBuilder config = new StringBuilder("");
        for (String line : lines) {
            config.append(line + "\n");
        }
        return config.toString();
    }

    public static void saveConfig(String configString, File file) {
        String configuration = prepareConfigString(configString);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(configuration);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getPluginName() {
        return "TODO";
    }

    private static void copyResource(InputStream resource, File file) {
        try {
            OutputStream out = new FileOutputStream(file);
            int lenght;
            byte[] buf = new byte[1024];
            while ((lenght = resource.read(buf)) > 0)
                out.write(buf, 0, lenght);
            out.close();
            resource.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

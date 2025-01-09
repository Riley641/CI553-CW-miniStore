package clients.config;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import debug.DEBUG;
import org.json.*;

/**
 * Implements the Model of the config client
 */
public class ConfigModel extends Observable  {

  private boolean isDarkMode;
  public ConfigModel() {
    loadSettings();
  }
    public boolean isDarkMode() {
        return isDarkMode;
    }

    public void setDarkMode() {
        isDarkMode = true;
        setChanged();
        notifyObservers();
    }

    public void setLightMode() {
        isDarkMode = false;
        setChanged();
        notifyObservers();
    }

    public void saveSettings() {
        // Save settings to file
        JSONObject obj = new JSONObject();
        obj.put("isDarkMode", isDarkMode);
        try {
            FileWriter file = new FileWriter("settings.json");
            file.write(obj.toString());
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadSettings() {
        // Load settings from file
        try {
            JSONObject obj = new JSONObject(Files.readString(Path.of("settings.json")));
            DEBUG.trace(obj.toString());
            isDarkMode = obj.getBoolean("isDarkMode");
        } catch (Exception e) {
            // Default settings
            isDarkMode = false;
            return;
        }
    }


    public void forceUpdate() {
        setChanged();
        notifyObservers("Test");
    }
}

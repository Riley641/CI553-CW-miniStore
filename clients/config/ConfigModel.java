package clients.config;

import catalogue.Basket;
import catalogue.BetterBasket;
import catalogue.Product;
import debug.DEBUG;
import middle.*;

import java.util.*;

/**
 * Implements the Model of the config client
 */
public class ConfigModel extends Observable  {

  private boolean isDarkMode = false;
  public ConfigModel() {

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



    public interface SettingListener {
        void onSettingChanged();
    }

}

package clients.config;


import java.util.concurrent.atomic.AtomicBoolean;

/**
 * The Cashier Controller
 */

public class ConfigController {
  private ConfigModel model = null;
  private ConfigView view = null;

  /**
   * Constructor
   *
   * @param model The model
   * @param view  The view from which the interaction came
   */
  public ConfigController(ConfigModel model, ConfigView view) {
    this.view = view;
    this.model = model;
  }

  public void setDiscount( double discount) {

    model.setDiscount(discount);
  }

  public boolean isDarkMode() {
    return model.isDarkMode();
  }

  /**
   * Set the dark mode
   */
  public void setDarkMode() {
    model.setDarkMode();
  }

  /**
   * Set the light mode
   */
  public void setLightMode() {
    model.setLightMode();
  }

  public void saveSettings() {
    model.saveSettings();
  }
}
package clients.config;


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
}
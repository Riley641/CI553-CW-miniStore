package clients.config;


import javax.swing.*;

/**
 * The standalone Cashier Client.
 */


public class ConfigClient
{
   public static void main (String args[])
   {
    displayGUI();                       // Create GUI
  }


  private static void displayGUI()
  {     
    JFrame  window = new JFrame();
     
    window.setTitle( "Cashier Client (MVC RMI)");
    window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    
    ConfigModel model = new ConfigModel();
    ConfigView view  = new ConfigView( window, 0, 0 );
    ConfigController cont  = new ConfigController( model, view );
    view.setController( cont );

    model.addObserver( view );       // Add observer to the model
    model.forceUpdate();
    window.setVisible(true);         // Display Screen
  }
}

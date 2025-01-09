package clients.config;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLightLaf;
import debug.DEBUG;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;



/**
 * View of the model 
 */
public class ConfigView implements Observer
{
  private static final int H = 300;       // Height of window pixels
  private static final int W = 400;       // Width  of window pixels
  

  private final JLabel      pageTitle  = new JLabel();
  private final JCheckBox   theDarkMode = new JCheckBox("Dark Mode");
  private final JButton     theSaveButton = new JButton("Save");
  private ConfigController cont       = null;
  
  /**
   * Construct the view
   * @param rpc   Window in which to construct
   * @param x     x-coordinate of position of window on screen
   * @param y     y-coordinate of position of window on screen  
   */
          
  public ConfigView(RootPaneContainer rpc, int x, int y  )
  {
    Container cp         = rpc.getContentPane();    // Content Pane
    Container rootWindow = (Container) rpc;         // Root Window
    cp.setLayout(null);                             // No layout manager
    rootWindow.setSize( W, H );                     // Size of Window
    rootWindow.setLocation( x, y );

    Font f = new Font("Monospaced",Font.PLAIN,12);  // Font f is

    pageTitle.setBounds( 110, 0 , 270, 20 );       
    pageTitle.setText( "Configs" );
    theDarkMode.setBounds( 110, 20, 100, 20 );
    theDarkMode.addItemListener( e -> {
      if (theDarkMode.isSelected()) {
        cont.setDarkMode();
      } else {
        cont.setLightMode();
      }

    });

    theSaveButton.setBounds( 110, 40, 100, 20 );
    theSaveButton.addActionListener(e -> {cont.saveSettings();});


    cp.add( pageTitle );
    cp.add( theDarkMode );
    cp.add( theSaveButton );

    rootWindow.setVisible( true );                  // Make visible

  }

  /**
   * The controller object, used so that an interaction can be passed to the controller
   * @param c   The controller
   */

  public void setController( ConfigController c )
  {
    cont = c;
  }

  /**
   * Update the view
   * @param modelC   The observed model
   * @param arg      Specific args 
   */
  @Override
  public void update( Observable modelC, Object arg )
  {
    ConfigModel model  = (ConfigModel) modelC;
    String      message = (String) arg;
    theDarkMode.setSelected(cont.isDarkMode());

    if (cont.isDarkMode()) {
      FlatDarculaLaf.setup();
    } else {
      FlatLightLaf.setup();
    }

    for (Frame j : Frame.getFrames()) {
      SwingUtilities.updateComponentTreeUI(j);
    }
  }

}

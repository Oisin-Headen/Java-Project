package lms.view.components;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

//The panel that contains all the holdingFields
@SuppressWarnings("serial")
public class MainPanel extends JPanel
{
   // The background is set to white
   public MainPanel()
   {  
      setBackground(Color.WHITE);
   }
   
   // sets the layout to the new number of columns
   public void setColumns(int columns)
   {
      setLayout(new GridLayout(0, columns));
   }
}

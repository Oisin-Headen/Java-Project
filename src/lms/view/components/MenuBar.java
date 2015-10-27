package lms.view.components;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar
{
   private JMenu file = new JMenu("File");
   private JMenu library = new JMenu("Library");
   private JMenu holdings = new JMenu("Holdings");
   private JMenu help = new JMenu("Help");
   
   public MenuBar()
   {
      file.add("Save");
      file.add("Open");
      file.add("Close");
      
      add(file);
      add(library);
      add(holdings);
      add(help);
   }

}

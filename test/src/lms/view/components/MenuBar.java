package lms.view.components;

import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import lms.controller.AddHoldingController;
import lms.controller.AddTestHoldingsController;
import lms.controller.ExitApplicationController;
import lms.controller.LMSMainController;
import lms.controller.RemoveHoldingController;
import lms.controller.ResetCollectionController;

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar
{
   // All of this could just as easily be local variables
   private JMenu holdings = new JMenu("Holdings");
   private JMenu library = new JMenu("Library");
   private JMenu application = new JMenu("Application");
   
   private JMenuItem addHolding = new JMenuItem("Add Holding", KeyEvent.VK_A);
   private JMenuItem removeHolding = new JMenuItem("Remove Holding", KeyEvent.VK_R);
   
   private JMenuItem addTestHoldings = new JMenuItem("Add Test Holdings", KeyEvent.VK_T);
   private JMenuItem reset = new JMenuItem("Reset Collection", KeyEvent.VK_R);
   
   private JMenuItem exit = new JMenuItem("Exit", KeyEvent.VK_X);
   
   public MenuBar(LMSMainController controller)
   {
      // Menus' mnemonics are set and menu items are added
      holdings.setMnemonic(KeyEvent.VK_H);
      library.setMnemonic(KeyEvent.VK_L);
      application.setMnemonic(KeyEvent.VK_A);
      
      holdings.add(addHolding);
      holdings.add(removeHolding);
      
      library.add(addTestHoldings);
      library.add(reset);
      
      application.add(exit);
      
      // The main controller is passed down to the many other controllers
      addHolding.addActionListener(new AddHoldingController(controller));
      removeHolding.addActionListener(new RemoveHoldingController(controller));
      
      addTestHoldings.addActionListener(new AddTestHoldingsController(controller));
      reset.addActionListener(new ResetCollectionController(controller));
      
      exit.addActionListener(new ExitApplicationController(controller.getMainView()));
      
      // Menus are added
      add(holdings);
      add(library);
      add(application);
      
   }

}

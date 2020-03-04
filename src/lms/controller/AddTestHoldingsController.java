package lms.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// This class sets up the test data
public class AddTestHoldingsController implements ActionListener
{
   LMSMainController mainController;

   public AddTestHoldingsController(LMSMainController controller)
   {
      mainController = controller;
   }

   // tells the main controller to setup the test data
   @Override
   public void actionPerformed(ActionEvent e)
   {
      mainController.setupTestData();
   }

}

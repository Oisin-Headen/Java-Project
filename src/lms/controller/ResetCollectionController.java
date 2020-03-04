package lms.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lms.view.dialogs.LMSConfirmationDialog;

// Handles the resetting of the collection
public class ResetCollectionController implements ActionListener
{
   private LMSMainController mainController;
   private LMSConfirmationDialog confirm;

   public ResetCollectionController(LMSMainController controller)
   {
      this.mainController = controller;
   }

   @Override
   public void actionPerformed(ActionEvent e)
   {
      // Two dialogs use this as their controller, so this finds out which action was performed
      switch(e.getActionCommand())
      {
         // If it was the reset collection action, from the tool bar or menu bar, 
         // then this creates a LMSConfirmationDialog with this as the listener
         case "Reset Collection":
            confirm = new LMSConfirmationDialog("Are you sure you want to reset the collection?", this, mainController.getMainView());
            break;
            
            // If the action was from the LMSConfirmationDialog, then the dialog is disposed,
            // and the collection is reset if the user clicked yes
         case "Yes":
            mainController.resetCollection();
            confirm.dispose();
            break;
         case "No":
            confirm.dispose();
            break;
      }
   }

}

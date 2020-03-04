package lms.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import lms.model.Holding;
import lms.view.dialogs.LMSConfirmationDialog;
import lms.view.dialogs.LMSErrorDialog;
import lms.view.dialogs.RemoveHoldingDialog;

// This controller handles the removing of multiple holdings at once
public class RemoveHoldingController implements ActionListener
{

   private LMSMainController mainController;
   private RemoveHoldingDialog dialog;
   private Holding[] holdings;
   
   private LMSConfirmationDialog confirm;

   public RemoveHoldingController(LMSMainController controller)
   {
      this.mainController = controller;
   }

   @Override
   public void actionPerformed(ActionEvent e)
   {      
      // Many different commands could be received, so a switch checks which one it is
      switch(e.getActionCommand())
      {
         // If the command was from the menu or tool bar, then the collection's holdings are checked
         case "Remove Holding": 
            holdings = mainController.getAllHoldings();
            if(holdings != null)
            {
               // If there are any holdings, a RemoveHoldingDialog is popped up
               dialog = new RemoveHoldingDialog(this, holdings, mainController.getMainView());
            }
            else
            {
               // If there are no holdings in the collection, then an error message pops up
               new LMSErrorDialog("There are no holdings to remove", mainController.getMainView());
            }            
            break;
            
          // Delete and Cancel come from the RemoveHoldingDialog
         case "Delete":
            // "Delete" creates a confirmation dialog
            confirm = new LMSConfirmationDialog("Are you sure you want to delete?", this, mainController.getMainView());
            break;
            
         case "Cancel":
            // "Cancel" disposes the RemoveHoldingDialog
            dialog.dispose();
            break;
            
         // Yes and No are from the confirmation box  
         case "Yes":
            // "Yes" cycles through the selected holdings telling the main controller to remove them, 
            // then redisplay
            confirm.dispose();
            List<Integer> list = dialog.getList().getSelectedValuesList();
            for(Iterator<Integer> iter = list.iterator(); iter.hasNext();)
            {
               mainController.removeHolding(iter.next());
            }
            mainController.redisplay();
            dialog.dispose();
            break;
            
         case "No":
            // "No" just disposes the confirmation box. The RemoveHoldingDialog is not disposed,
            // so the user can decide to remove different holdings.
            confirm.dispose();
            break;
      }
   }
}

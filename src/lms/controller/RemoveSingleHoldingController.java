package lms.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import lms.view.dialogs.LMSConfirmationDialog;

// This class handles the behavior of double click to remove holding
public class RemoveSingleHoldingController implements MouseListener, ActionListener
{

   private LMSConfirmationDialog dialog;
   private LMSMainController mainController;
   private String code;
   

   public RemoveSingleHoldingController(String code, LMSMainController controller)
   {
      this.code = code;
      this.mainController = controller;
   }


   @Override
   public void mouseClicked(MouseEvent e)
   {
      // Makes sure this is a double click
      if(e.getClickCount() == 2)
      {
         // confirms the removal, using this as a controller
         dialog = new LMSConfirmationDialog("Are you sure you want to remove this holding?", this, mainController.getMainView());
      }
   }


   @Override
   public void actionPerformed(ActionEvent e)
   {
      switch(e.getActionCommand())
      {
         case "Yes":
            // If they selected "Yes", then the holding is removed, and the field is redisplayed
            mainController.removeHolding(new Integer(code));
            mainController.redisplay();
            dialog.dispose();
            break;
         case "No":
            dialog.dispose();
            break;
         // either way, the confirmation dialog is disposed
      }
   }
   
   
   
   
   
   @Override
   public void mousePressed(MouseEvent e)
   {
      // TODO Auto-generated method stub

   }

   @Override
   public void mouseReleased(MouseEvent e)
   {
      // TODO Auto-generated method stub

   }

   @Override
   public void mouseEntered(MouseEvent e)
   {
      // TODO Auto-generated method stub

   }

   @Override
   public void mouseExited(MouseEvent e)
   {
      // TODO Auto-generated method stub

   }


}

package lms.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import lms.view.dialogs.LMSConfirmationDialog;

// This class handles the exiting of the application
public class ExitApplicationController implements WindowListener, ActionListener
{
   private LMSConfirmationDialog confirmation;
   private Component location;

   public ExitApplicationController(Component location)
   {
      // A component to set the location of the confirmation box relative to
      this.location = location;
   }

   @Override
   public void windowClosing(WindowEvent e)
   {
      // If the user pressed the close button, a confirmation box is created, with this as the controller
      confirmation = new LMSConfirmationDialog("Are you sure you want to exit?", this, location);
   }

   @Override
   public void actionPerformed(ActionEvent e)
   {
      switch(e.getActionCommand())
      {
         case "Yes":
            // If the user does want to exit, the system is exited, ending the program
            System.exit(0);
            break;
         case "No":
            // If the user does not want to exit, the dialog is disposed
            confirmation.dispose();
            break;
            
         // If the menu creates this instance, then this will be called instead of windowClosing
         case "Exit":
            confirmation = new LMSConfirmationDialog("Are you sure you want to exit?", this, location);
            break;
      }
      
   }
   
   
   @Override
   public void windowClosed(WindowEvent e)
   {
      // TODO Auto-generated method stub

   }

   @Override
   public void windowIconified(WindowEvent e)
   {
      // TODO Auto-generated method stub

   }

   @Override
   public void windowDeiconified(WindowEvent e)
   {
      // TODO Auto-generated method stub

   }

   @Override
   public void windowActivated(WindowEvent e)
   {
      // TODO Auto-generated method stub

   }

   @Override
   public void windowDeactivated(WindowEvent e)
   {
      // TODO Auto-generated method stub

   }
   
   @Override
   public void windowOpened(WindowEvent e)
   {
      // TODO Auto-generated method stub

   }
}

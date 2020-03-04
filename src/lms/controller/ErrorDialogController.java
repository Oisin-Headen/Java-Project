package lms.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lms.view.dialogs.LMSErrorDialog;

// This class handles the error dialog
public class ErrorDialogController implements ActionListener
{
   private LMSErrorDialog errorBox;

   public ErrorDialogController(LMSErrorDialog errorBox)
   {
      this.errorBox = errorBox;
   }

   // The only thing using this class is the error dialog, so no need for a switch
   // This method disposes the error dialog
   @Override
   public void actionPerformed(ActionEvent e)
   {
      errorBox.dispose();
   }

}

package lms.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lms.view.dialogs.CollectionSetupDialog;

// This class handles the logic of adding a collection
public class CollectionSetupController implements ActionListener
{
   private CollectionSetupDialog colDialog;
   private LMSMainController lmsMainController;
   
   public CollectionSetupController(CollectionSetupDialog colDialog, LMSMainController lmsMainController)
   {
      this.colDialog = colDialog;
      this.lmsMainController = lmsMainController;
   }

   // When the user clicks OK, this takes a library collection from the setup dialog,
   // and gives it to the main controller. Then the dialog is disposed
   @Override
   public void actionPerformed(ActionEvent e)
   {
      lmsMainController.setupModelAndView(colDialog.getNewLibraryCollection());
      colDialog.dispose();
   }



}

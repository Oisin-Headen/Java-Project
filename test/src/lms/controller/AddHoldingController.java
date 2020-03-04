package lms.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lms.model.Book;
import lms.model.Video;
import lms.view.dialogs.AddHoldingDialog;
import lms.view.dialogs.LMSErrorDialog;

// This class takes the information from the user to create new holdings
public class AddHoldingController implements ActionListener
{
   private LMSMainController mainController;
   private AddHoldingDialog dialog;

   public AddHoldingController(LMSMainController controller)
   {
      this.mainController = controller;
   }
   
   @Override
   public void actionPerformed(ActionEvent e)
   {
      String code, title, state;
      
      boolean addedSuccessfully;
      
      int finalCode, fee; 
      // This controller is listening for multiple events, so a switch statement is 
      // used to get the action command and perform the required operation
      switch(e.getActionCommand())
      {
         // If the call came from the menu bar or tool bar, 
         // then a new dialog box is created
         case "Add Holding":
            dialog = new AddHoldingDialog(this, mainController.getMainView());
            break;
            
         // If the user doesn't want to add a holding, then the dialog is disposed
         case "Cancel":
            dialog.dispose();
            break;

         // Takes the data and tries to make a holding out of it
         case "Submit":
            try
            {
               state = dialog.getComboBoxState();
               if (state.equals("Book"))
               {
                  // the code for entering a book
                  code = dialog.getCodeArea().getText();
                  title = dialog.getTitleArea().getText();

                  // checking for errors
                  if (code.length() != 7 && title.length() < 3)
                  {
                     // both tests failed
                     new LMSErrorDialog("Book code must be seven digits, " +
                              "and title must be at least three characters long", mainController.getMainView());
                  } 
                  else if(code.length() != 7)
                  {
                     // if code is not exactly seven digits
                     new LMSErrorDialog("Book code must be seven digits", mainController.getMainView());
                  } 
                  else if(title.length() < 3)
                  {
                     // if the title is not long enough
                     new LMSErrorDialog("Title must be at least three characters long", mainController.getMainView());
                  } 
                  else
                  {
                     // no errors in entered data
                     finalCode = new Integer(code);
                     addedSuccessfully = mainController.addHolding(new Book(finalCode, title));
                     
                     if (addedSuccessfully)
                        dialog.dispose();
                     else
                        // If the model rejects the holding, then that
                        // code has been used already
                        new LMSErrorDialog("A holding with that code already exists", mainController.getMainView());
                  }
               }
               else
               {
               // the code for entering a video, almost the exact same as for books
                  code = dialog.getCodeArea().getText();
                  title = dialog.getTitleArea().getText();
                  fee = dialog.getFee();

                  // checking for errors
                  if (code.length() != 7 && title.length() < 3)
                  {
                     // both tests failed
                     new LMSErrorDialog("Video code must be seven digits, " +
                              "and title must be at least three characters long", mainController.getMainView());
                  } 
                  else if(code.length() != 7)
                  {
                     // if code is not exactly seven digits
                     new LMSErrorDialog("Video code must be seven digits", mainController.getMainView());
                  } 
                  else if(title.length() < 3)
                  {
                     // if the title is not long enough
                     new LMSErrorDialog("Title must be at least three characters long", mainController.getMainView());
                  } 
                  else
                  {
                     // no errors in entered data
                     finalCode = new Integer(code);
                     addedSuccessfully = mainController.addHolding(new Video(finalCode, title, fee));
                     
                     if (addedSuccessfully)
                        dialog.dispose();
                     else
                        // If the model rejects the holding, then that
                        // code has been used already
                        new LMSErrorDialog("A holding with that code already exists", mainController.getMainView());
                  }
               }
            }
            catch(NumberFormatException notInt)
            {
               // if a NumberFormatException if thrown, then the user entered
               // non numeric data for the code
               new LMSErrorDialog("Holding code must be all numeric characters", mainController.getMainView());
            }
            break;
         
         // When the combo box changes, the dialog is set to the new state   
         case "comboBoxChanged":
            state = dialog.getComboBoxState();
            if (state.equals("Book"))
               dialog.setBookDialog();
            else
               dialog.setVideoDialog();
            break;
      }
   }

}

package lms.view.dialogs;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import lms.controller.CollectionSetupController;
import lms.controller.LMSMainController;
import lms.model.LibraryCollection;

@SuppressWarnings("serial")
public class CollectionSetupDialog extends JDialog
{
   private CollectionSetupController controller;
   private JTextField codeField, titleField;

   public CollectionSetupDialog(LMSMainController lmsMainController)
   {
      // This creates a controller for itself
      controller = new CollectionSetupController(this, lmsMainController);
      
      // No need for a fancy layout on this dialog
      setLayout(new FlowLayout());
      
      // The text and area for the library code
      JPanel codeHolder = new JPanel();
      codeHolder.add(new JLabel("Library Code: "));
      codeField = new JTextField(10);
      codeHolder.add(codeField);
      add(codeHolder);
      
      // The text and area for the library title
      JPanel titleHolder = new JPanel();
      titleHolder.add(new JLabel("Library Title: "));
      titleField = new JTextField(10);
      titleHolder.add(titleField);
      add(titleHolder);
      
      // The button
      JButton button = new JButton();
      button.setText("OK");
      button.addActionListener(controller);
      add(button);
      
      // Allows the user to press enter to press "OK"
      getRootPane().setDefaultButton(button);
      
      // Finishes the dialog. For this Dialog, the user is not allowed to press the X button,
      // so a library code and title must be entered
      setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
      pack();
      this.setLocationRelativeTo(null);
      setVisible(true);      

   }
   
   // Method used by the controller to get a new Library Collection from the textFields 
   public LibraryCollection getNewLibraryCollection()
   {
      return new LibraryCollection(codeField.getText(), titleField.getText());
   }
}

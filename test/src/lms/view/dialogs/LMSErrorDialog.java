package lms.view.dialogs;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import lms.controller.ErrorDialogController;


// The generic Error Dialog, which pops up to inform the user of errors
@SuppressWarnings("serial")
public class LMSErrorDialog extends JDialog
{
   
   public LMSErrorDialog(String message, Component location)
   {
      Box box = new Box(BoxLayout.Y_AXIS);
      this.add(box);
      
      setTitle("Error!");

      // Adds some space at the top of the dialog
      box.add(Box.createVerticalStrut(5));
      
      // The error message the user needs to be informed about
      JLabel label = new JLabel();
      label.setText(message);
      box.add(label);
      label.setAlignmentX(CENTER_ALIGNMENT);
      label.setVisible(true);
      
      // Some space between the text and the button
      box.add(Box.createHorizontalStrut(label.getPreferredSize().width + 20));
      
      // The button, pressed to close the dialog
      JButton button = new JButton("OK");
      box.add(button);
      button.setAlignmentX(CENTER_ALIGNMENT);
      button.addActionListener(new ErrorDialogController(this));
      
      // Some space at the bottom of the dialog
      box.add(Box.createVerticalStrut(5));
      
      // Allows the user to use the enter key to press the button
      getRootPane().setDefaultButton(button);
      
      // Finishes setting up the dialog
      pack();
      this.setLocationRelativeTo(location);
      setVisible(true);
   }
}

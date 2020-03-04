package lms.view.dialogs;

import java.awt.Component;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

// The generic Confirmation Dialog, to provide user response to a yes/no question
@SuppressWarnings("serial")
public class LMSConfirmationDialog extends JDialog
{
   // As well as a message and a location, this dialog takes a controller to deal with it
   public LMSConfirmationDialog(String message, ActionListener listener, Component location)
   {
      Box box = new Box(BoxLayout.Y_AXIS);
      this.add(box);
      
      box.add(Box.createVerticalStrut(5));
      
      // Displays the question
      JLabel label = new JLabel();
      label.setText(message);
      box.add(label);
      label.setAlignmentX(CENTER_ALIGNMENT);
      
      // The buttons
      JPanel buttonHolder = new JPanel();
      JButton yesButton = new JButton("Yes");
      JButton noButton = new JButton("No");
      yesButton.addActionListener(listener);
      noButton.addActionListener(listener);
      buttonHolder.add(yesButton);
      buttonHolder.add(noButton);
      box.add(buttonHolder);
      buttonHolder.setAlignmentX(CENTER_ALIGNMENT);
      
      // Adds some space for easier reading
      box.add(Box.createHorizontalStrut(Math.max(label.getPreferredSize().width + 20, buttonHolder.getPreferredSize().width + 20)));
      box.add(Box.createVerticalStrut(5));
            
      // Allows the user to select "yes" by pressing the enter key
      getRootPane().setDefaultButton(yesButton);
      
      // Finishes the setup
      pack();
      this.setLocationRelativeTo(location);
      setVisible(true);
   }
} 

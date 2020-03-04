package lms.view.dialogs;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import lms.controller.RemoveHoldingController;
import lms.model.Holding;

@SuppressWarnings("serial")
public class RemoveHoldingDialog extends JDialog
{
   JList<Integer> list;

   public RemoveHoldingDialog(RemoveHoldingController removeHoldingController, Holding[] holdings, Component location)
   {  
      // A box is used, so everything is centered and so struts can be used
      Box box = new Box(BoxLayout.Y_AXIS);
      this.add(box);
      
      // Gives some space so the text is more readable
      box.add(Box.createVerticalStrut(5));
      
      //Creates and aligns the text
      JLabel title = new JLabel();
      JLabel hint = new JLabel();
      title.setText("Select the holdings to remove:");
      hint.setText("(Use the command key to select multiple holdings)");
      title.setAlignmentX(CENTER_ALIGNMENT);
      hint.setAlignmentX(CENTER_ALIGNMENT);
      box.add(title);
      box.add(hint);
      
      
      //Creates a list of possible holdings to remove
      DefaultListModel<Integer> holdingList = new DefaultListModel<Integer>();
      for(int i = 0; i < holdings.length; i++)
      {
         holdingList.addElement(holdings[i].getCode());
      }
      list = new JList<Integer>(holdingList);
      JPanel listPanel = new JPanel();
      listPanel.add(list);
      box.add(listPanel);


      // The buttons, added to a button holder, so they can be put side-by-side
      JButton delete = new JButton("Delete");
      JButton cancel = new JButton("Cancel");
      JPanel buttonHolder = new JPanel();
      delete.addActionListener(removeHoldingController);
      cancel.addActionListener(removeHoldingController);
      buttonHolder.add(cancel);
      buttonHolder.add(delete);
      box.add(buttonHolder);


      // Gives some space so the text is more readable
      box.add(Box.createHorizontalStrut(hint.getPreferredSize().width + 20));
      box.add(Box.createVerticalStrut(10));

      // Allows the user to use the enter key to press the delete button
      getRootPane().setDefaultButton(delete);
      
      // Finishing up the dialog, and setting its location to the entered component
      pack();
      this.setLocationRelativeTo(location);
      setVisible(true);
   }

   
   // For the controller to access the list
   public JList<Integer> getList()
   {
      return list;
   }
}

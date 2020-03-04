package lms.view.dialogs;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import lms.controller.AddHoldingController;

@SuppressWarnings("serial")
public class AddHoldingDialog extends JDialog
{
   private JComboBox<String> holdingType;
   
   private JTextField codeArea;
   private JTextField titleArea;
   private JComboBox<Integer> feeArea;
   
   private JLabel enterFee;
   
   public AddHoldingDialog(AddHoldingController addHoldingController, Component location)
   {
      
      Box box = new Box(BoxLayout.Y_AXIS);
      JLabel title = new JLabel();
      
      // Sets up the type combo box
      holdingType = new JComboBox<String>();
      holdingType.addItem("Book");
      holdingType.addItem("Video");
      
      // Sets up the text
      JLabel enterCode = new JLabel();
      JLabel enterTitle = new JLabel();
      enterFee = new JLabel();

      // The textFields
      codeArea = new JTextField(10);
      titleArea = new JTextField(10);
      
      // The fee combo box
      feeArea = new JComboBox<Integer>();
      feeArea.addItem(4);
      feeArea.addItem(6);
      
      // The holders, so the areas can be grouped together in the box
      JPanel codeHolder = new JPanel();
      JPanel titleHolder = new JPanel();
      JPanel feeHolder = new JPanel();
      
      // The buttons
      JPanel buttonHolder = new JPanel();
      JButton submitButton = new JButton("Submit");
      JButton cancelButton = new JButton("Cancel");
      
      this.add(box);
      
      // Some space
      box.add(Box.createVerticalStrut(5));
      
      // Adds the text
      title.setText("Enter values to create a new holding");
      box.add(title);
      title.setAlignmentX(CENTER_ALIGNMENT);
      
      // Adds space
      box.add(Box.createVerticalStrut(3));
      
      // Adds the type combo box
      box.add(holdingType);
      holdingType.addActionListener(addHoldingController);
      holdingType.setAlignmentX(LEFT_ALIGNMENT);
      
      
      // Adds the "enter code" section
      enterCode.setText("Enter holding code:");
      codeHolder.add(enterCode);
      codeHolder.add(codeArea);
      box.add(codeHolder);
      codeHolder.setAlignmentX(CENTER_ALIGNMENT);
      
      // Adds the "enter title" section
      enterTitle.setText("Enter holding title:");
      titleHolder.add(enterTitle);
      titleHolder.add(titleArea);
      box.add(titleHolder);
      titleHolder.setAlignmentX(CENTER_ALIGNMENT);
      
      // Adds the "select fee" combo box
      enterFee.setText("Select holding fee:");
      feeHolder.add(enterFee);
      feeHolder.add(feeArea);
      box.add(feeHolder);
      feeHolder.setAlignmentX(CENTER_ALIGNMENT);
      
      // The combo box starts on book selected, so fee needs to be disabled
      enterFee.setEnabled(false);
      feeArea.setEnabled(false);
      
      // Adds the buttons
      submitButton.addActionListener(addHoldingController);
      cancelButton.addActionListener(addHoldingController);
      buttonHolder.add(cancelButton);
      buttonHolder.add(submitButton);
      box.add(buttonHolder);
      buttonHolder.setAlignmentX(LEFT_ALIGNMENT);
      
      // Allows the user to press enter as the submit button
      getRootPane().setDefaultButton(submitButton);
      
      // Gives some space so the text is more readable
      box.add(Box.createHorizontalStrut(Math.max(title.getPreferredSize().width + 20, buttonHolder.getPreferredSize().width + 20)));
      box.add(Box.createVerticalStrut(5));
      
      pack();
      this.setLocationRelativeTo(location);
      setVisible(true);
   }
   
   
   public String getComboBoxState()
   {
      return (String) holdingType.getSelectedItem();
   }

   
   public void setVideoDialog()
   {
      enterFee.setEnabled(true);
      feeArea.setEnabled(true);
   }

   public void setBookDialog()
   {
      enterFee.setEnabled(false);
      feeArea.setEnabled(false);
   }

   public JTextField getCodeArea()
   {
      return codeArea;
   }

   public int getFee()
   {
      return (Integer) feeArea.getSelectedItem();
   }

   public JTextField getTitleArea()
   {
      return titleArea;
   }
   
   
   
}
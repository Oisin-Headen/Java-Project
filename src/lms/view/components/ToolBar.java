package lms.view.components;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import lms.controller.AddHoldingController;
import lms.controller.HoldingsSortController;
import lms.controller.LMSMainController;
import lms.controller.RemoveHoldingController;
import lms.controller.ResetCollectionController;

@SuppressWarnings("serial")
public class ToolBar extends JPanel
{
   public ToolBar(LMSMainController controller)
   {
      Box box = new Box(BoxLayout.X_AXIS);
      this.add(box);

      // The buttons, with icons
      JButton addHoldingButton = new JButton(new ImageIcon("src/lms/view/Add Holding Icon.jpg", "Add Holding"));
      JButton removeHoldingButton = new JButton(new ImageIcon("src/lms/view/Remove Holding Icon.jpg", "Remove Holding"));
      JButton resetButton = new JButton(new ImageIcon("src/lms/view/Reset collection Icon.jpg", "Reset Collection"));

      addHoldingButton.addActionListener(new AddHoldingController(controller));
      removeHoldingButton.addActionListener(new RemoveHoldingController(controller));
      resetButton.addActionListener(new ResetCollectionController(controller));

      // Sets the action commands, so they can be distinguished
      addHoldingButton.setActionCommand("Add Holding");
      removeHoldingButton.setActionCommand("Remove Holding");
      resetButton.setActionCommand("Reset Collection");
      
      // The radio buttons
      ButtonGroup group = new ButtonGroup();
      JPanel radioButtonHolder = new JPanel();
      JRadioButton defaultSort = new JRadioButton("Default");
      JRadioButton codeSort = new JRadioButton("Code");
      JRadioButton typeSort = new JRadioButton("Type");
      
      radioButtonHolder.add(new JLabel("Sort by:"));
      radioButtonHolder.add(defaultSort);
      radioButtonHolder.add(codeSort);
      radioButtonHolder.add(typeSort);
      
      // the radio buttons are grouped together
      group.add(defaultSort);
      group.add(codeSort);
      group.add(typeSort);
      
      HoldingsSortController radioButtonContoller = new HoldingsSortController(defaultSort, controller);
      
      defaultSort.addActionListener(radioButtonContoller);
      codeSort.addActionListener(radioButtonContoller);
      typeSort.addActionListener(radioButtonContoller);
      
      box.add(addHoldingButton);
      box.add(removeHoldingButton);
      box.add(resetButton);

      // The radio buttons
      box.add(radioButtonHolder);
      
   }
}

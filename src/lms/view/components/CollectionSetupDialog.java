package lms.view.components;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import lms.model.LibraryCollection;

@SuppressWarnings("serial")
public class CollectionSetupDialog extends JDialog
{
   String code, title;

   public CollectionSetupDialog()
   {
      super();
      
      code = "A";
      title = "3";
      setLayout(new FlowLayout());
      
      add(new JLabel("Library Code: "));
      add(new JTextField(10));
      
      add(new JLabel("Library Code: "));
      add(new JTextField(10));
      
      JButton button = new JButton();
      button.setText("OK");
      add(button);
      
      pack();
      setVisible(true);
   }
   
   public LibraryCollection getCollection()
   {
      return new LibraryCollection(code, title);
   }
}

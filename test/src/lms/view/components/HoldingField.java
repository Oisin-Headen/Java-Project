package lms.view.components;

import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JViewport;
import javax.swing.border.LineBorder;

import lms.controller.LMSMainController;
import lms.controller.RemoveSingleHoldingController;

// This is the object for displaying holdings graphically
@SuppressWarnings("serial")
public class HoldingField extends JScrollPane
{
   // could be just local variables
   private JTextArea text;
   private JViewport port;
   
   // Takes all the parameters needed to display a holding, and the main controller
   public HoldingField(String code, String title, String loanFee, String loanPeriod, String type, LMSMainController controller)
   {
      // This is a scrollpane, so the text is added to its viewport
      // the text is made un-editable 
      port = this.getViewport();
      text = new JTextArea();
      port.add(text);
      text.setEditable(false);
      
      // The background is set gray
      text.setBackground(Color.LIGHT_GRAY);
      
      // Sets the border colour blue or red depending on whether 
      // this holding field is of a book or video
      if(type.equals("BOOK"))
      {
         this.setBorder(new LineBorder(Color.BLUE, 3));
      }
      else
      {
         this.setBorder(new LineBorder(Color.RED, 3));
      }
      // sets the text
      text.setText("Holding ID: " + code +
                   "\nTitle: " + title +
                   "\nStandard Loan Fee: " + loanFee +
                   "\nLoan Period: " + loanPeriod);
      
      // adds a mouse listener to incorporate double-click to remove functionality.
      text.addMouseListener(new RemoveSingleHoldingController(code, controller));
   }
}

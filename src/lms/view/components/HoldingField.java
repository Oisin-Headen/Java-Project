package lms.view.components;

import java.awt.Color;
import java.util.StringTokenizer;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JViewport;
import javax.swing.border.LineBorder;

import lms.model.Holding;

@SuppressWarnings("serial")
public class HoldingField extends JScrollPane
{
   private JTextArea text;
   private JViewport port;
   
   private String code;
   private String title;
   private String loanFee;
   private String loanPeriod;
   
   private String type;

   public HoldingField(Holding holding)
   {
      port = this.getViewport();
      text = new JTextArea();
      port.add(text);
      text.setEditable(false);
      
      text.setBackground(Color.LIGHT_GRAY);
      
      StringTokenizer tokenizer = new StringTokenizer(holding.toString() + ":", ":");
      
      code = tokenizer.nextToken();
      title = tokenizer.nextToken();
      loanFee = tokenizer.nextToken();
      loanPeriod = tokenizer.nextToken();
      
      type = tokenizer.nextToken();
      
      if(type.equals("BOOK"))
      {
         this.setBorder(new LineBorder(Color.BLUE, 3));
      }
      else
      {
         this.setBorder(new LineBorder(Color.RED, 3));
      }
      
      text.setText("Holding ID: " + code +
                   "\nTitle: " + title +
                   "\nStandard Loan Fee: " + loanFee +
                   "\nLoan Period: " + loanPeriod);
   }
}

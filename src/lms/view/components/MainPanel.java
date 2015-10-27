package lms.view.components;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JPanel;

import lms.model.Book;
import lms.model.Holding;
import lms.model.Video;

@SuppressWarnings("serial")
public class MainPanel extends JPanel
{

   public MainPanel()
   {  
      setLayout(new GridLayout(0, 4));
      setBackground(Color.WHITE);
   }
   
   public void add(Holding holding)
   {
      add(new HoldingField(holding));
   }
}

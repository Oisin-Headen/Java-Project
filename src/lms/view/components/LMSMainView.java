package lms.view.components;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import lms.model.Video;


@SuppressWarnings("serial")
public class LMSMainView extends JFrame
{
   public MainPanel mainPanel;
   private StatusBar statusBar;
   private MenuBar menuBar;
   
   public LMSMainView(String title)
   {
      super(title);
      setSize(1000, 600);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Use a WindowListener to close
      setLayout(new BorderLayout());
      
      mainPanel = new MainPanel();
      add(mainPanel, BorderLayout.CENTER);
      
      statusBar = new StatusBar();
      add(statusBar, BorderLayout.SOUTH);
      
      menuBar = new MenuBar();
      add(menuBar, BorderLayout.NORTH);
      
      mainPanel.add(new HoldingField(new Video(111,"Oisin's headache, the movie", 6)));
      
      this.validate();
   }
}

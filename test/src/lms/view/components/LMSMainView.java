package lms.view.components;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import lms.controller.ExitApplicationController;
import lms.controller.LMSMainController;


@SuppressWarnings("serial")
public class LMSMainView extends JFrame
{
   private MainPanel mainPanel;
   private StatusBar statusBar;
   private MenuBar menuBar;
   private LMSMainController mainController;
   private ToolBar toolBar;
   
   public LMSMainView(String title, LMSMainController controller)
   {
      super(title);
      setSize(1000, 600);
      
      // Using a WindowListener to close the program, so there can't be a default close operation
      setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 
      setLayout(new BorderLayout());
      
      // The main controller will be passed down to subcomponents until they pass
      // it to their controllers
      this.mainController = controller;
      
      // Adds the main panel
      mainPanel = new MainPanel();
      add(mainPanel, BorderLayout.CENTER);
      mainPanel.setVisible(true);
      
      // The status bar
      statusBar = new StatusBar();
      add(statusBar, BorderLayout.SOUTH);
      
      // The menu bar
      menuBar = new MenuBar(mainController);
      this.setJMenuBar(menuBar);
      
      // The tool bar
      toolBar = new ToolBar(mainController);
      this.add(toolBar, BorderLayout.NORTH);
      
      this.validate();
      
      // The window listener
      this.addWindowListener(new ExitApplicationController(this));
   }
   
   // Used by the mainController to add a holdingfield
   public void addHolding(HoldingField holdingField)
   {
      mainPanel.add(holdingField);
   }

   // sets the number of columns in the main panel
   public void setColumns(int columns)
   {
      mainPanel.setColumns(columns);
   }

   // removes all the holdingFields from the main panel
   public void reset()
   {
      mainPanel.removeAll();
   }

   // sets the status bar
   public void setStatus(String collectionCode, int totalBooks, int totalVideos)
   {
      statusBar.setStatus(collectionCode, totalBooks, totalVideos);
   }

   // Updates the status bar 
   public void updateStatusBar(int countBooks, int countVideos)
   {
      statusBar.updateStatusBar(countBooks, countVideos);
   }

   // redisplays this view, and repaints the model
   public void updateChanges()
   {
      revalidate();
      mainPanel.repaint();
   }
}

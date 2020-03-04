package lms.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;

import javax.swing.JRadioButton;

import lms.controller.sorter.CodeSorter;
import lms.controller.sorter.DefaultSorter;
import lms.controller.sorter.TypeSorter;
import lms.model.Holding;

// This class changes the holdings sort order of the view, using three comparators
public class HoldingsSortController implements ActionListener
{
   // could be local variable
   private JRadioButton defaultSort;
   
   // The comparators, one for each sorting order
   private static final Comparator<Holding> defaultSorter = new DefaultSorter(), codeSorter = new CodeSorter(), typeSorter = new TypeSorter();
   
   private LMSMainController mainController;
   
   
   public HoldingsSortController(JRadioButton startSort, LMSMainController mainController)
   {
      // Takes the input button, and sets its state to selected
      this.defaultSort = startSort;
      this.defaultSort.setSelected(true);
      
      this.mainController = mainController;
   }

   @Override
   public void actionPerformed(ActionEvent e)
   {
      // If a button is pressed, then the main controller's
      // current sort order is changed to a different sort order,
      // and the view is updated.
      switch(e.getActionCommand())
      {
         case "Default":
            mainController.setCurrentSortOrder(defaultSorter);
            break;
            
         case "Code":
            mainController.setCurrentSortOrder(codeSorter);
            break;
            
         case "Type":
            mainController.setCurrentSortOrder(typeSorter);
            break;
      }
      mainController.redisplay();
   }

}

package lms.controller;

import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.Arrays;

import lms.controller.sorter.DefaultSorter;
import lms.model.Holding;
import lms.model.LibraryCollection;
import lms.model.facade.LMSFacade;
import lms.model.facade.LMSModel;
import lms.view.components.HoldingField;
import lms.view.components.LMSMainView;
import lms.view.dialogs.*;
import lms.view.util.Tester;


// This is the main class in the program, handling all interaction with the model, and updating the view.
public class LMSMainController
{
   private LMSModel model;
   private LMSMainView view;
   private Tester tester = new Tester();
   
   // Holds the current sorting order, starting at default
   private Comparator<Holding> currentSortOrder = new DefaultSorter();

   // The constructor sets up the view and model, and creates a new CollectionSetupDialog which will setup the collection
   // This controller is passed down to the view, so that controllers for the components can use this object
   public LMSMainController()
   {
      this.model = new LMSFacade();
      this.view = new LMSMainView("Assignment 2", this);
      
      new CollectionSetupDialog(this);
   }   
   
   
   // Function for making holdingFields from holdings
   // Only used by this class, so it's private
   private HoldingField createFieldFromHolding(Holding holding)
   {
      String code, title, loanFee, loanPeriod, type;
      StringTokenizer tokenizer = new StringTokenizer(holding.toString() + ":", ":");
      
      code = tokenizer.nextToken();
      title = tokenizer.nextToken();
      loanFee = tokenizer.nextToken();
      loanPeriod = tokenizer.nextToken();
      
      type = tokenizer.nextToken();
      
      return new HoldingField(code, title, loanFee, loanPeriod, type, this);
   }
   
   
   // Protected methods so only other controllers can invoke them.
   
   // Called by the CollectionSetupController to finish setting this object up
   protected void setupModelAndView(LibraryCollection collection)
   {
      String collectionCode;
      
      // The new collection is added to the model
      model.addCollection(collection);
      
      // The collection code is extracted from the collection, 
      // and passed to the view in order to set the status
      StringTokenizer tokenizer = new StringTokenizer(model.getCollection().toString(), ":");
      try
      {
      collectionCode = tokenizer.nextToken();
      }
      catch(Exception e)
      {
         // If the user didn't enter a code, then the tokenizer will complain,
         // so this catches the complaint, and sets collectionCode to an empty string
         collectionCode = "";
      }
     
      // sets the status and position
      view.setStatus(collectionCode, model.countBooks(), model.countVideos());
      view.setLocationRelativeTo(null);
      view.setVisible(true);
   }
   
   // Called by the AddTestHoldingsController
   protected void setupTestData()
   {
      tester.setupTestData(model);
      redisplay();
   }

   // Method to redisplay the collection. Used by various classes
   protected void redisplay()
   {
      Holding[] holdings = model.getAllHoldings();
      int columns;
      
      // Blanks the view, to re-add the holdings with the correct amount of columns and
      // correct sorting order
      view.reset();

      // Makes sure the array of holdings in not null
      if(holdings != null)
      {
         // Sorts the holding array according to the
         Arrays.sort(holdings, currentSortOrder);
         
         // Gets the correct amount of columns based on the number of holdings
         switch(holdings.length)
         {
            case 1:
               columns = 1;
               break;
            case 2:
               columns = 2;
               break;
            case 3:
               columns = 3;
               break;
            default:
               columns = 4;
               break;
         }
         
         // Sets the view's columns to the new amount of columns
         view.setColumns(columns);

         // Adds the holdings back into the view as holdingFields
         for(int i = 0; i < holdings.length; i++)
         {
            view.addHolding(createFieldFromHolding(holdings[i]));
         }
      }
      
      // Updates the status bar, and then tells the view to display the changes
      view.updateStatusBar(model.countBooks(), model.countVideos());
      view.updateChanges();
   }

   // Used by the ResetCollectionController
   protected void resetCollection()
   {  
      Holding[] holdings = model.getAllHoldings();
      int tempCode;
      
      // Makes sure the array of holdings in not null
      if (holdings != null)
      {
         // The model currently lacks a reset method,
         // so this code loops through the holdings and deletes them
         for(int i = 0; i < holdings.length; i++)
         {
            tempCode = holdings[i].getCode();
            model.removeHolding(tempCode);
         }
      }
      // The end result is displayed
      redisplay();
   }

   // Used by the AddHoldingController
   protected boolean addHolding(Holding holding)
   {
      // tries to add the holding to the model, 
      // and returns the value the model returned
      boolean success = model.addHolding(holding);
      if (success)
      {
         redisplay();
      }
      return success;
   }

   // Used by various controllers to position dialogs
   public LMSMainView getMainView()
   {
      return view;
   }

   // Used by the DeleteHoldingController to get holdingIds to display
   protected Holding[] getAllHoldings()
   {
      return model.getAllHoldings();
   }

   // Used by the DeleteHoldingController and DeleteSingleHoldingController
   // to remove holdings from the model. Changes made to the model have to be redisplayed by the caller
   protected void removeHolding(int holdingId)
   {
      model.removeHolding(holdingId);
   }
   
   // Used by the HoldingsSortController to set the comparator used
   protected void setCurrentSortOrder(Comparator<Holding> comp)
   {
      this.currentSortOrder = comp;
   }
}

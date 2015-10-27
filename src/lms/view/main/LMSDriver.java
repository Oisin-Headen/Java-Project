package lms.view.main;

import lms.model.Book;
import lms.model.Video;
import lms.model.facade.*;
import lms.view.components.*;
import lms.view.util.Tester;


public class LMSDriver
{   
   public static LMSMainView view;
   public static LMSModel model = new LMSFacade();
   
   public static void main(String[] args)
   {
      LMSModel model = new LMSFacade();
      Tester tester = new Tester();
      
      CollectionSetupDialog collectionDialog = new CollectionSetupDialog();
      model.addCollection(collectionDialog.getCollection());
      
      view = new LMSMainView("Assignment 2");
      view.setVisible(true);
      
      tester.setupTestData(model);     
      view.setVisible(true);
      
      
      view.mainPanel.add(new Book(111,"Oisin's headache"));
//      view.mainPanel.add(new HoldingField(new Video(111,"Oisin's headache, the movie", 6)));
   }
}


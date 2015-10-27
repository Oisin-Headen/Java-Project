package lms.model;

import java.util.*;

public class LibraryCollection
{
   // This class holds all the logic for all the holding related functions of LMS,
   // and holds the library's collection of holdings
   
   private String code;
   private String name;
   private LinkedHashMap<Integer, Holding> holdings = new LinkedHashMap<Integer, Holding>();
   
   public LibraryCollection(String code, String name)
   {
      this.code = code;
      this.name = name;
   }

   public boolean addHolding(Holding holding)
   {
   // if the collection already contains the holding, 
   // then the method returns the failure signal
      if (holdings.containsValue(holding))
      {
         return false;
      }
   // otherwise the holding is added to the collection,
   // and the success signal is returned
      else
      {
         holdings.put(holding.getCode(), holding);
         return true;
      }
   }

   public boolean removeHolding(int holdingId)
   {
      
      boolean success = false;
      Holding tempHolding = holdings.get(holdingId);
      if (!tempHolding.isOnLoan())
      {   
         // Checks if the holding is on loan, if it is not then it is removed
         // from the collection and success is changed to true. Then success will
         // be returned, false if this condition failed true if it did not
         holdings.remove(holdingId);
         success = true;
      }
      return success;
   }

   public Holding getHolding(int holdingId)
   {
      return holdings.get(holdingId);
   }

   public LinkedHashMap<Integer, Holding> getAllHoldings()
   {
      // If there are no holdings, then null is returned, 
      // otherwise the holdings map is returned
      if (holdings.isEmpty())
      {
         return null;
      }
      else
      {
         return holdings;
      }
   }

   public int countBooks()
   {
      // Uses an iterator to loop through the map, checking for books
      // and increasing the total books found. Then the total is returned.
      int totalBooks = 0;      
      for(Iterator<Holding> iter = holdings.values().iterator(); iter.hasNext();)
      {
         Holding tempHolding = iter.next();
         if (tempHolding instanceof Book)
         {
            totalBooks++;
         }
      }
      return totalBooks;
   }
   
   public int countVideos()
   {
      // Same as countBooks, but checking for videos instead.
      int totalVideos = 0;
      for(Iterator<Holding> iter = holdings.values().iterator(); iter.hasNext();)
      {
         Holding tempHolding = iter.next();
         if (tempHolding instanceof Video)
         {
            totalVideos++;
         }
      }
      return totalVideos;
   }
   
   public String toString()
   {
      String endString = code + ":" + name;
      Iterator<Holding> iter = holdings.values().iterator();
      if (iter.hasNext())
      {
         // The first book in the collection shouldn't put a comma in front of it,
         // so it needs to be handled separately.
         endString = endString + ":" + iter.next().getCode();
      
         // Then if there are more holdings, they are added with commas in front of them
         for(;iter.hasNext();)
         {         
            endString = endString + "," + iter.next().getCode();
         }
      }
      return endString;
   }
}

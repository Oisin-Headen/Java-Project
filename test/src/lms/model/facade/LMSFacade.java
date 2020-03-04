package lms.model.facade;

import java.util.*;

import lms.model.*;
import lms.model.exception.*;
import lms.model.util.*;

public class LMSFacade implements LMSModel {

   private Library library;
   
   // All methods in this class just delegate the job to the library,
   // except for the last method, which uses the DateUtil class
   
   public LMSFacade()
   {
      library = new Library();
   }
   
   public void addMember(Member member)
   {
      library.addMember(member); 
   }

   public void addCollection(LibraryCollection collection)
   {
      library.addCollection(collection);
   }


   public Member getMember()
   {
      return library.getMember();
   }


   public LibraryCollection getCollection()
   {
      return library.getCollection();
   }


   public boolean addHolding(Holding holding)
   {
      return library.addHolding(holding);
   }

   public boolean removeHolding(int holdingId)
   {
      return library.removeHolding(holdingId);
   }

   public Holding getHolding(int holdingId)
   {
      return library.getHolding(holdingId);
   }

   public Holding[] getAllHoldings()
   {
      LinkedHashMap<Integer, Holding> holdings = library.getAllHoldings();
      // It is possible that there are no holdings in the library collection,
      // so this needs to check for null here, the only way to avoid this would 
      // be to convert to an array earlier
      if (holdings != null)
         return holdings.values().toArray(new Holding[1]);
      else
         return null;
   }

   public int countBooks()
   {
      return library.countBooks();
   }

   public int countVideos()
   {
      return library.countVideos();
   }

   public void borrowHolding(int holdingId) throws InsufficientCreditException, MultipleBorrowingException
   {
      library.borrowHolding(holdingId);
   }

   public void returnHolding(int holdingId) throws OverdrawnCreditException
   {
      library.returnHolding(holdingId);
   }

   public HistoryRecord[] getBorrowingHistory()
   {      
      // if the member hasn't got any history records, then this will return
      // null, otherwise it will convert the records to a collection, then to an array
      LinkedHashMap<Holding, HistoryRecord> records = library.getHistoryRecords();
      if(!records.isEmpty())   
      {
         return records.values().toArray(new HistoryRecord[1]);
      }
      else
      {
         return null;
      }
   }

   public HistoryRecord getHistoryRecord(int holdingId)
   {
      return library.getHistoryRecord(holdingId);
   }

   public Holding[] getBorrowedHoldings()
   {
      // if the member hasn't got any borrowed holdings, then this will return
      // null, otherwise it will convert the holdings to an array
      ArrayList<Holding> holdings = library.getBorrowedHoldings();
      if(holdings != null)   
      {
         return holdings.toArray(new Holding[1]);
      }
      else
      {
         return null;
      }
   }

   public void resetMemberCredit()
   {
      library.resetMemberCredit();
   }

   public int calculateRemainingCredit()
   {
      return library.getCredit();
   }

   public int calculateTotalLateFees()
   {
      return library.calculateTotalLateFees();
   }

   public void setDate(String currentDate)
   {
      DateUtil.getInstance().setDate(currentDate);
   }
   
}
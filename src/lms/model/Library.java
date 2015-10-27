package lms.model;

import java.util.*;

import lms.model.exception.InsufficientCreditException;
import lms.model.exception.MultipleBorrowingException;
import lms.model.exception.OverdrawnCreditException;
import lms.model.util.DateUtil;

public class Library
{
   // The only jobs of this class are delegating functions to their places, 
   // and keeping track of the member and collection.
   
   private LibraryCollection collection;
   private Member member;
   
   public void addMember(Member member)
   {
      this.member = member;
   }
   
   public void addCollection(LibraryCollection collection)
   {
      this.collection = collection;
   }
   
   public Member getMember()
   {
      return member;
   }


   public LibraryCollection getCollection()
   {
      return collection;
   }

   public boolean addHolding(Holding holding)
   {
      return collection.addHolding(holding);
   }

   public boolean removeHolding(int holdingId)
   {
      return collection.removeHolding(holdingId);
   }

   public Holding getHolding(int holdingId)
   {
      return collection.getHolding(holdingId);
   }

   public LinkedHashMap<Integer, Holding> getAllHoldings()
   {   
      return collection.getAllHoldings();
   }

   public int countBooks()
   {
      return collection.countBooks();
   }

   public int countVideos()
   {
      return collection.countVideos();
   }
   
   public void borrowHolding(int holdingId) throws InsufficientCreditException, MultipleBorrowingException
   {
      // Uses the getHolding method to get the holding for a holding ID,
      // then has the member borrow it
      Holding tempHolding = getHolding(holdingId);
      member.borrowHolding(tempHolding, DateUtil.getInstance().getDate());
   }
   
   public void returnHolding(int holdingId) throws OverdrawnCreditException
   {
      // Uses the getHolding method to get the holding for a holding ID,
      // then has the member return it
      Holding tempHolding = getHolding(holdingId);
      member.returnHolding(tempHolding);
   }

   public LinkedHashMap<Holding, HistoryRecord> getHistoryRecords()
   {
      return member.getHistoryRecords();
   }

   public HistoryRecord getHistoryRecord(int holdingId)
   {
      return member.getHistoryRecord(getHolding(holdingId));
   }

   public ArrayList<Holding> getBorrowedHoldings()
   {
      return member.getBorrowedHoldings();
   }

   public void resetMemberCredit()
   {
      member.resetMemberCredit();
   }

   public int getCredit()
   {
      return member.getCredit();
   }

   public int calculateTotalLateFees()
   {
      return member.calculateTotalLateFees();
   }
   
   
}

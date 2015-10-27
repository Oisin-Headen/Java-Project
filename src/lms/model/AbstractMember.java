package lms.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import lms.model.exception.*;
import lms.model.util.DateUtil;

public abstract class AbstractMember implements Member
{
   // This class provides all the basic functionality for members.
   
   private String ID;
   private String name;
   private int remainingCredit;
   private int initialCredit;
   private ArrayList<Holding> borrowed = new ArrayList<Holding>();
   private BorrowingHistory history = new BorrowingHistory();
   
   // A constructor so as to let the subclasses set the values of ID, name, and initialCredit
   public AbstractMember(String ID, String name, int initialCredit)
   {
      this.ID = ID;
      this.name = name;
      this.initialCredit = initialCredit;
      remainingCredit = initialCredit;
   }

   
   public void borrowHolding(Holding holding, String date) throws MultipleBorrowingException, InsufficientCreditException
   {
      // First, the borrowing history is checked for the provided holding
      boolean wasPreviouslyLoaned = history.containsRecord(holding);
      
      // Then the code checks the array for the holding, and if it is found,
      // wasPreviouslyLoaned is set to true
      if (borrowed.contains(holding))
      {
         wasPreviouslyLoaned = true;
      }
      
      // If either of the above checks were true, then a MultipleBorrowingException 
      // will be thrown
      if (wasPreviouslyLoaned)
      {
         throw new MultipleBorrowingException();
      }
      else
      {
         // Otherwise the member's credit is compared to
         // the loan fee of the holding, if there is not enough credit, an 
         // InsufficientCreditException is thrown.
         if (remainingCredit - holding.getLoanFee() < 0)
         {
            throw new InsufficientCreditException();
         }
         // If nothing has failed at all, then the loan fee is deducted from
         // the member's credit, and the holding is loaned, and added to the member's
         // borrowed holdings
         else
         {
            remainingCredit -= holding.getLoanFee();
            holding.loan(date);
            borrowed.add(holding);
         }
      }  
   }
   
   public int getCredit()
   {
      return remainingCredit;
   }

   public void resetMemberCredit()
   {
      remainingCredit = initialCredit;
   }
   
   public void returnHolding(Holding holding) throws OverdrawnCreditException
   {
      // This function assumes everything is OK to return the holding, and handles all the 
      // things required in the returning process. It must be overridden in the subclasses to provide the correct
      // functionality.
      int lateFee = holding.totalLateFee(DateUtil.getInstance().getElapsedDays(holding.getLoanDate()));
      remainingCredit -= lateFee;
      holding.returnHolding();
      history.addHistoryRecord(new HistoryRecord(holding, lateFee + holding.getLoanFee()));
      borrowed.remove(holding);
      
   }
   
   public ArrayList<Holding> getBorrowedHoldings()
   {
      // If the member has no borrowed holdings, then null is returned, 
      // rather than an empty ArrayList. Otherwise the Arraylist is returned.
      if (borrowed.isEmpty())
      {
         return null;
      }
      else
      {
         return borrowed;
      }
   }

   public String toString()
   {
      // This function is for the subclasses to get this class's variables
      // in their toString method
      String output = ID + ":" + name + ":" + remainingCredit;
      return output;
   }

   public int calculateTotalLateFees()
   {
      return history.calculateTotalLateFees();
   }

   public LinkedHashMap<Holding, HistoryRecord> getHistoryRecords()
   {
      return history.getAllHistoryRecords();
   }

   public HistoryRecord getHistoryRecord(Holding holding)
   {
      return history.getHistoryRecord(holding);
   }
}

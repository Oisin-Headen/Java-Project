package lms.model;

import java.util.*;

import lms.model.exception.InsufficientCreditException;
import lms.model.exception.MultipleBorrowingException;
import lms.model.exception.OverdrawnCreditException;

public interface Member
{
   // This interface exists to hide implementation from other parts of the code
   
   void borrowHolding(Holding tempHolding, String date) throws MultipleBorrowingException, InsufficientCreditException;

   void returnHolding(Holding tempHolding) throws OverdrawnCreditException;

   LinkedHashMap<Holding, HistoryRecord> getHistoryRecords();

   HistoryRecord getHistoryRecord(Holding holding);

   ArrayList<Holding> getBorrowedHoldings();

   void resetMemberCredit();

   int getCredit();

   int calculateTotalLateFees();

}

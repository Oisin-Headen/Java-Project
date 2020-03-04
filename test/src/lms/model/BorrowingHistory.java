package lms.model;

import java.util.*;

public class BorrowingHistory
{
   // This is a support class for the member class, just a holder 
   // for history records and handles the record-related logic 
   
   // Since each holding can only be borrowed once, it makes a great key for a map
   private LinkedHashMap<Holding, HistoryRecord> records = new LinkedHashMap<Holding, HistoryRecord>();
   
   public void addHistoryRecord(HistoryRecord record)
   {
      records.put(record.getHolding(), record);
   }
   
   public HistoryRecord getHistoryRecord(Holding holding)
   {
      return records.get(holding);
   }
   
   public int calculateTotalLateFees()
   {
      // The only complex piece of code for this class, this adds up
      // all the late fees from all the history records.
      int total = 0;
      
      Iterator<HistoryRecord> iter = records.values().iterator();
      for(;iter.hasNext();)
      {         
         total = total + iter.next().getLateFee();
      }
      
      return total;
   }
   
   public boolean containsRecord(Holding holding)
   {
      return records.containsKey(holding);
   }
   
   public LinkedHashMap<Holding, HistoryRecord> getAllHistoryRecords()
   {
      return records;
   }
}

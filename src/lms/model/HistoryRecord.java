package lms.model;

public class HistoryRecord
{
   // This class is an item in a borrowingHistory
   
   private Holding holding;
   private int holdingCode;
   private int payedFee;
   private int lateFee;
   
   public HistoryRecord(Holding holding, int payedFee)
   {
      int holdingCode = holding.getCode();
      
      this.holdingCode = holdingCode;
      this.payedFee = payedFee;
      this.holding = holding;
      // calculates the late fee based on the total fee and the 
      // holding's loan fee
      this.lateFee = payedFee - holding.getLoanFee();
   }
   
   public String toString()
   {
      String output = holdingCode + ":" + payedFee;
      return output;
   }
   
   public Holding getHolding()
   {
      return holding;
   }
   
   public int getLateFee()
   {
      return lateFee;
   }
}

package lms.model;

public interface Holding
{
   // This interface hides implementation from the rest of the program
   
   int getCode();

   boolean isOnLoan();

   int getLoanFee();

   void loan(String date);

   String getLoanDate();

   int totalLateFee(int daysBorrowed);

   void returnHolding();
}

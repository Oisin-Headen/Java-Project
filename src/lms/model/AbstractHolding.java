package lms.model;

public abstract class AbstractHolding implements Holding
{
   // This class provides most holding methods and all variables.
   
   private int code;
   private String title;
   private String loanDate = null;
   private int loanFee;
   private int dailyLateFee;
   private int maxLoanDays;
   
   // constructor for the subclass to initialize variables
   public AbstractHolding(int code, String title, int loanFee, int dailyLateFee, int maxLoanDays)
   {
      this.code = code;
      this.title = title;
      this.loanFee = loanFee;
      this.dailyLateFee = dailyLateFee;
      this.maxLoanDays = maxLoanDays;
   }
   
   public int getCode()
   {
      return code;
   }

   public int getLoanFee()
   {
      return loanFee;
   }

   public void loan(String date)
   {
      loanDate = date;
   }
   
   public boolean isOnLoan()
   {
      return loanDate != null;
   }
   
   public void returnHolding()
   {
      loanDate = null;
   }
   
   public int totalLateFee(int days)
   {
      // This checks the number of days this holding has been on loan against its
      // maximum loan days. If the result is greater than zero, then the late fee is calculated.
      if (days - maxLoanDays > 0)
      {
         return (days - maxLoanDays)  * dailyLateFee;
      }
      else
      {
         return 0;
      }
   }

   public String getLoanDate()
   {
      return loanDate;
   }
   
   // Lets the subclasses use these variables in their toString method
   public String toString()
   {
      String output = code + ":" + title + ":" + loanFee + ":" + maxLoanDays;
      return output;
   }
   
}

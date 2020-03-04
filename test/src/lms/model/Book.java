package lms.model;

public class Book extends AbstractHolding
{
   // This is a book class. It only has a constructor and a toString method,
   // which provide behavior unique to books
   
   // Not a lot of use, but the final statics makes them look less like magic numbers
   private final static int LOAN_FEE = 10;
   private final static int DAILY_LATE_FEE = 2;
   private final static int MAX_LOAN_DAYS = 28;   
   
   public Book(int code, String title)
   {
      super(code, title, LOAN_FEE, DAILY_LATE_FEE, MAX_LOAN_DAYS);
   }
   
   public String toString()
   {
      String output = super.toString();
      output = output + ":BOOK";
      return output;
   }
}

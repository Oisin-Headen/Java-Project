package lms.model;

public class Video extends AbstractHolding
{
   // Provides the LMS with videos and video specific behavior.
   
   private final static int MAX_LOAN_DAYS = 7;   
   
   public Video(int code, String name, int loanFee)
   {
      super(code, name, loanFee, loanFee/2, MAX_LOAN_DAYS);
   }
   
   public String toString()
   {
      String output = super.toString();
      output = output + ":VIDEO";
      return output;
   }
}

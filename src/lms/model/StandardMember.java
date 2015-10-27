package lms.model;

import lms.model.exception.OverdrawnCreditException;
import lms.model.util.DateUtil;

public class StandardMember extends AbstractMember
{
   // This class provides the standard member unique behavior
   
   // Not actually much point in this final static variable, as it is going to be stored in
   // the superclass variable, but it helps with readability
   private final static int INITIAL_CREDIT = 30;
   
   public StandardMember(String ID, String name)
   {
      super(ID, name, INITIAL_CREDIT);
   }

   public void returnHolding(Holding holding) throws OverdrawnCreditException
   {
      int daysBorrowed = DateUtil.getInstance().getElapsedDays(holding.getLoanDate());
      int lateFee = holding.totalLateFee(daysBorrowed);
      
      // If the late fee is more than the member can pay, 
      // a OverdrawnCreditException is thrown
      if (lateFee > getCredit())
      {
         throw new OverdrawnCreditException();
      }
      else
      {
         // Otherwise the holding is given to the superclass to return
         super.returnHolding(holding);
      }
   }
   
   public String toString()
   {
      // This just uses the superclass toString, and adds ":STANDARD" to it
      String output = super.toString();
      output = output + ":STANDARD";
      return output;
   }
   
}

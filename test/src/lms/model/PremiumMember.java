package lms.model;

import lms.model.exception.OverdrawnCreditException;

public class PremiumMember extends AbstractMember
{
   // This class provides the premium member unique behavior

   // As with Standard member, only here to improve readability, setting the 
   // credit to the "INITIAL_CREDIT" and not the arbitrary "45"
   private final static int INITIAL_CREDIT = 45;
   
   public PremiumMember(String ID, String name)
   {
      super(ID, name, INITIAL_CREDIT);
   }
   

   public void returnHolding(Holding holding) throws OverdrawnCreditException
   {  
      // A premium member can return holdings as long as he dosn't have negative credit,
      // if he does, then an OverdrawnCreditException will be thrown
      if (0 > getCredit())
      {
         throw new OverdrawnCreditException();
      }
      else
      {
         // If it is OK to return the holding, the superclass handles it
         super.returnHolding(holding);
      }
   }
   
   public String toString()
   {
      // Takes the superclass toString and adds ":PREMIUM" to itS
      String output = super.toString();
      output = output + ":PREMIUM";
      return output;
   }

}

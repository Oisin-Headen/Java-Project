package lms.controller.sorter;

import java.util.Comparator;
import java.util.StringTokenizer;

import lms.model.Holding;

public class TypeSorter implements Comparator<Holding>
{
   @Override
   public int compare(Holding o1, Holding o2)
   {
      String o1Type, o2Type;

      // The first holding's type
      StringTokenizer tokenizer = new StringTokenizer(o1.toString() + ":", ":");
      tokenizer.nextToken();
      tokenizer.nextToken();
      tokenizer.nextToken();
      tokenizer.nextToken();
      o1Type = tokenizer.nextToken();

      // The second holding's type
      StringTokenizer tokenizer2 = new StringTokenizer(o2.toString() + ":", ":");
      tokenizer2.nextToken();
      tokenizer2.nextToken();
      tokenizer2.nextToken();
      tokenizer2.nextToken();
      o2Type = tokenizer2.nextToken();
      
      
      // Compares the types to insure that books come before videos, same types are judged on their insertion order, 
      // and videos come after books, respectively
      if(o1Type.equals("BOOK") && o2Type.equals("VIDEO"))
      {
         return -1;
      }
      if(o1Type.equals(o2Type) )
      {
         return 0;
      }
      if(o1Type.equals("VIDEO") && o2Type.equals("BOOK"))
      {
         return 1; 
      }

      // Makes the compiler happy, will never actually get reached
      return 0;
   }

}

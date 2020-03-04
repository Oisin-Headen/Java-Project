package lms.controller.sorter;

import java.util.Comparator;

import lms.model.Holding;

public class CodeSorter implements Comparator<Holding>
{
   // A simple method for comparing two holding's codes
   @Override
   public int compare(Holding o1, Holding o2)
   {
      return o1.getCode() - o2.getCode();
   }

}

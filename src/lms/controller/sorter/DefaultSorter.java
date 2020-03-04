package lms.controller.sorter;

import java.util.Comparator;

import lms.model.Holding;

public class DefaultSorter implements Comparator<Holding>
{   
   @Override
   public int compare(Holding o1, Holding o2)
   {
      // This sort option is for the default order, so it dosen't compare anything
      return 0;
   }
}

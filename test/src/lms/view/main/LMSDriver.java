package lms.view.main;

import lms.controller.LMSMainController;

public class LMSDriver
{   
   // All this class does is create a new LMSMainController, and lets it do all the work
   // The Main method was interfering with the library collection setup
   public static void main(String[] args)
   {
      new LMSMainController();
   }
}


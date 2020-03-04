package lms.view.components;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class StatusBar extends JLabel
{
   // The collection code never changes, so it is saved
   String collectionCode;

   // Used to give the collection code and update the total books and total videos
   public void setStatus(String collectionCode, int totalBooks, int totalVideos)
   {
      this.collectionCode = collectionCode;
      this.setText("Collection Code: ["+collectionCode+"] | Total Books: ["+totalBooks+"] | Total Videos: ["+totalVideos+"]");
   }

   // The collection code is saved, so this just uses setStatus again
   public void updateStatusBar(int countBooks, int countVideos)
   {
      setStatus(collectionCode, countBooks, countVideos);
   }
}

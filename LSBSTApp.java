import javax.swing.*;
import java.io.*;
import javax.swing.*;
/**
 * @author Sanele Hlongwane
 */

public class LSBSTApp extends JFrame{
   private JPanel mainPanel;

   public LSBSTApp(String content){
      super(content);


      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setContentPane(mainPanel);
      this.pack();
   }

   /**
    * This is a Binary Search Tree Program that returns the areas experiencing loadshedding for the given parameters.
    * If the parameters are not valid, then "Invalid Parameters" is returned. Not parsing any parameters will return a list
    *  of all stages, days, times, and areas experiencing loadshedding
    * @param args
    * @throws IOException
    */
   public static void main ( String [] args ) throws IOException {
      JFrame frame = new LSBSTApp("LSBSTApp");
      frame.setVisible(true);


      String[] one = new String[3];
      int temp = 0;
      for(String s: args){
         one[temp] = s;
         temp ++;
      }
      BinarySearchTree bt = new BinarySearchTree ();

      FileInputStream fstream = new FileInputStream("2976.txt");
      BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
      String strLine;

      while ((strLine = br.readLine()) != null){
         bt.insert(strLine);
      }

      if(one[0]==null){bt.inOrder();}else{try{
      System.out.println ("Search "+one[0]+"_"+one[1]+"_"+one[2]+" : ");
      System.out.println("Areas: "+bt.find (one[0]+"_"+one[1]+"_"+one[2]).data.split(" ", 2)[1]);
      System.out.println("Number of operations: "+bt.counter);}catch(Exception e){System.out.println("Invalid Parameters");}}

   }



}

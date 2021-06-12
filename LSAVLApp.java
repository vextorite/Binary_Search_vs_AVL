import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class LSAVLApp
{
   public static void main ( String [] args )throws IOException
   {
      AVLTree bt = new AVLTree ();
      String[] one = new String[3];
      int temp = 0;
      for(String s: args){
         one[temp] = s;
         temp ++;
      }

      FileInputStream fstream = new FileInputStream("2976.txt");
      BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
      String strLine;

      while ((strLine = br.readLine()) != null){
         bt.insert(strLine);
      }

      if(one[0]==null){
         bt.inOrder();}else{try{
         System.out.println("-----------------------------------------------------------------");
         System.out.println ("Search for Stage: "+one[0]+"\nDay: "+one[1]+"\nStart Time: "+one[2]);
         System.out.println("-----------------------------------------------------------------");
         System.out.println("Areas experiencing load shedding: "+bt.find (one[0]+"_"+one[1]+"_"+one[2]).data.split(" ", 2)[1]);
         System.out.println("Comparison operations: "+bt.counter);
         System.out.println("Insertion and balance operations: "+bt.insertCount);
         }catch(Exception e){System.out.println("Invalid Parameters");}}

   }
}

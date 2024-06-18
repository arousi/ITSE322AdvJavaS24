import java.util.Arrays;
import java.util.List;
import java.util.*;
import java.util.ArrayList;

public class java1 {

   /* This is my first java program.
   ! Don't forget about comments
   ? can we make this faster?
   todo update team leader about the changes to the codebase
   ** are we gonna talk later?
   // are u ok?
   ! Be persistant
    * This will print 'Hello World' as the output
    */

   public static void main(String []args) {
      System.out.println("Hello World"); // prints Hello World
      int age = 25;
      char charcter = 'S';
      String name = "Sanad";
      System.out.println("Hello age: "+age+"\nHello charcter: "+charcter+"\nHello name: "+name);
      
      Integer Nums[] = {7485,6,4,89,46,5};
      //List<Integer> Nums = Arrays.asList(10,65,54,21,3);
      System.out.print("(");
      for(Integer x : Nums){
         System.out.print(x + ", ");
      }
      System.out.println(")");
      System.out.print("(");
      for(short i = 0 ; i <= Nums.length-1 ; i++){
         Arrays.sort(Nums, Collections.reverseOrder());
         System.out.print(Nums[i]+ ", ");
      }
      System.out.println(")");
   }
}
import java.util.*;


public class java3{
    public static void main(String args[]){
        
        Queue<String> str_Q1 = new LinkedList<>();

        str_Q1.add("S1");
        str_Q1.add("S2");
        str_Q1.add("S3");
        str_Q1.add("S4");

        System.out.println("\n\n"+str_Q1);
        str_Q1.remove();
        System.out.println(str_Q1);

    }
}
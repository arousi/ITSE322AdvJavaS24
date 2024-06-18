import java.util.LinkedList;
import java.util.Queue;

public class QImp {
    public static void main(String[] args) {

        Queue<String> Q1 = new LinkedList<>();
        // Adding elements to the Q1
        Q1.offer("Alice");
        Q1.offer("Bob");
        Q1.offer("Charlie");
        // Displaying the Q1
        System.out.println("Q1 elements: " + Q1);
        // Accessing and removing elements
        String firstElement = Q1.poll();
        System.out.println("First element: " + firstElement);
        System.out.println("Updated Q1: " + Q1);
        //Accessing the element at the front
        String frontElement = Q1.peek();
        System.out.println("Front element: " + frontElement); // Checking if the Q1 is empty
        boolean isEmpty = Q1.isEmpty();
        System.out.println("Is the Q1 empty? " + isEmpty);

        
        
    }
}

import java.util.Stack;

public class StackImp {
    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();
        // Pushing elements onto the Stack
        stack.push("Alice");
        stack.push("Bob");
        stack.push("Charlie");
        // Displaying the Stack
        System.out.println("Stack elements: " + stack);
        // Accessing and removing elements
        String topElement = stack.pop();
        System.out.println("Top element: " + topElement);
        System.out.println("Updated Stack: " + stack);
        // Accessing the element at the top
        String elementAtTop = stack.peek();
        System.out.println("Element at the top: " + elementAtTop); // Checking if the Stack is empty
        boolean isEmpty = stack.isEmpty();
        System.out.println("Is the Stack empty? " + isEmpty);
        

    }
}
import java.util.Stack;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input string from user
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        // Create a stack to hold characters
        Stack<Character> stack = new Stack<>();
        
        // Push all characters into stack
        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }
        
        // Pop characters from stack to get reversed string
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        
        // Print the reversed string
        System.out.println("Reversed String: " + reversed);
        
        scanner.close();
    }
}


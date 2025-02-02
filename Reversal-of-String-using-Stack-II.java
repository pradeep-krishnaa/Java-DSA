import java.util.Stack;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input sentence from user
        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();
        
        // Create a stack to store words
        Stack<String> stack = new Stack<>();
        
        // Split sentence into words and push into stack
        String[] words = input.split("\\s+");
        for (String word : words) {
            stack.push(word);
        }
        
        // Pop words from stack to form reversed sentence
        StringBuilder reversedSentence = new StringBuilder();
        while (!stack.isEmpty()) {
            reversedSentence.append(stack.pop()).append(" ");
        }
        
        // Print the reversed word order
        System.out.println("Reversed Sentence: " + reversedSentence.toString().trim());
        
        scanner.close();
    }
}


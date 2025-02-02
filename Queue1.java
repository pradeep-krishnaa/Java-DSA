import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Queue1 {
    public static void main(String[] args) {
        final int SIZE = 5;
        Queue<Integer> queue = new ArrayDeque<>(SIZE);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nQueue Operations:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display Queue");
            System.out.println("5. Check if Queue is Empty");
            System.out.println("6. Check if Queue is Full");
            System.out.println("7. Get Queue Size");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    if (queue.size() >= SIZE) {
                        System.out.println("Queue is full!");
                    } else {
                        System.out.print("Enter a number to enqueue: ");
                        int item = scanner.nextInt();
                        queue.offer(item);
                        System.out.println(item + " enqueued.");
                    }
                }
                case 2 -> {
                    if (queue.isEmpty()) {
                        System.out.println("Queue is empty!");
                    } else {
                        System.out.println(queue.poll() + " dequeued.");
                    }
                }
                case 3 -> {
                    if (queue.isEmpty()) {
                        System.out.println("Queue is empty!");
                    } else {
                        System.out.println("Front element: " + queue.peek());
                    }
                }
                case 4 -> System.out.println("Queue: " + queue);
                case 5 -> System.out.println("Queue is empty? " + queue.isEmpty());
                case 6 -> System.out.println("Queue is full? " + (queue.size() == SIZE));
                case 7 -> System.out.println("Queue size: " + queue.size());
                case 8 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}


import java.util.LinkedList;
import java.util.HashSet;
import java.util.Iterator;

class Main {

    // Method to remove duplicates from the LinkedList
    static void removeDuplicates(LinkedList<Integer> list) {
        HashSet<Integer> seen = new HashSet<>();
        Iterator<Integer> iterator = list.iterator();
        
        while (iterator.hasNext()) {
            int current = iterator.next();
            if (seen.contains(current)) {
                iterator.remove(); // Remove duplicate
            } else {
                seen.add(current); // Add unique element
            }
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        // Insert elements (with duplicates)
        list.add(10);
        list.add(20);
        list.add(10);
        list.add(30);
        list.add(20);
        list.add(40);

        System.out.println("Original List: " + list);

        // Call removeDuplicates method
        removeDuplicates(list);

        System.out.println("After Removing Duplicates: " + list);
    }
}


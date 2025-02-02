import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

    // Method to insert a new node in the BST
    Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        
        return root;
    }

    // Method to search for a node with a given value
    Node search(Node root, int data) {
        if (root == null || root.data == data) {
            return root;
        }
        if (data < root.data) {
            return search(root.left, data);
        }
        return search(root.right, data);
    }

    // Method to delete a node from the BST
    Node delete(Node root, int data) {
        if (root == null) {
            return root;
        }
        if (data < root.data) {
            root.left = delete(root.left, data);
        } else if (data > root.data) {
            root.right = delete(root.right, data);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.data = minValue(root.right);
            // Delete the inorder successor
            root.right = delete(root.right, root.data);
        }
        return root;
    }

    // Helper method to find the minimum value in a given subtree
    int minValue(Node root) {
        int minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

    // Inorder Traversal (Left, Root, Right)
    void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    // Preorder Traversal (Root, Left, Right)
    void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    // Postorder Traversal (Left, Right, Root)
    void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }
}

class Main {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Choose an operation:");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Inorder Traversal");
            System.out.println("5. Preorder Traversal");
            System.out.println("6. Postorder Traversal");
            System.out.println("0. Exit");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: // Insert
                    System.out.print("Enter value to insert: ");
                    int insertData = scanner.nextInt();
                    tree.root = tree.insert(tree.root, insertData);
                    break;

                case 2: // Delete
                    System.out.print("Enter value to delete: ");
                    int deleteData = scanner.nextInt();
                    tree.root = tree.delete(tree.root, deleteData);
                    break;

                case 3: // Search
                    System.out.print("Enter value to search: ");
                    int searchData = scanner.nextInt();
                    Node result = tree.search(tree.root, searchData);
                    if (result != null) {
                        System.out.println("Value " + searchData + " found in the tree.");
                    } else {
                        System.out.println("Value " + searchData + " not found in the tree.");
                    }
                    break;

                case 4: // Inorder Traversal
                    System.out.print("Inorder Traversal: ");
                    tree.inorder(tree.root);
                    System.out.println();
                    break;

                case 5: // Preorder Traversal
                    System.out.print("Preorder Traversal: ");
                    tree.preorder(tree.root);
                    System.out.println();
                    break;

                case 6: // Postorder Traversal
                    System.out.print("Postorder Traversal: ");
                    tree.postorder(tree.root);
                    System.out.println();
                    break;

                case 0: // Exit
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}


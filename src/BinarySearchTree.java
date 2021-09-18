public class BinarySearchTree {


    class Node
    {
        int key;
        Node left, right;

        public Node(int item)
        {
            key = item;
            left = right = null;
        }
    }

    Node root;
    BinarySearchTree()
    {
        root = null;
    }

    // This method mainly calls insertRec()
    void insert(int key)
    {
        root = insertRec(root, key);
    }
    Node insertRec(Node root, int key)
    {

        /* If the tree is empty,
           return a new node */
        if (root == null)
        {
            root = new Node(key);
            return root;
        }

//        /* Otherwise, recur down the tree */
//        if (key < root.key) {
//
//            root.left = insertRec(root.left, key);
//        } else if (key > root.key)
//            root.right = insertRec(root.right, key);

        /* return the (unchanged) node pointer */
        return root;
    }




    public static void main(String[] args) {
        System.out.println("Hello world*****");
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        System.out.println("Inserted to Binary Search Tree *****");
    }
}

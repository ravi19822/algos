import java.util.Objects;

public class BinarySearchTreeV1 {

    class Node{

        private Node left, right;
        private String key;
        private int val;
        private int count;
        public Node(String key, int val)
        {
            this.key=key;
            this.val=val;
            this.left=null;
            this.right=null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "left=" + left +
                    ", right=" + right +
                    ", key='" + key + '\'' +
                    ", val=" + val +
                    ", count=" + count +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return val == node.val &&
                    count == node.count &&
                    Objects.equals(left, node.left) &&
                    Objects.equals(right, node.right) &&
                    Objects.equals(key, node.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(left, right, key, val, count);
        }
    }

    public Node getRoot() {
        return root;
    }

    Node root;
    public static void main(String[] args) {
        System.out.println("Implementation of BST ********");
        BinarySearchTreeV1 bst=new BinarySearchTreeV1();
        bst.put("M",20);
        bst.put("C",10);
        bst.put("P",40);
        bst.put("S",50);
        bst.put("O",60);
        bst.put("M",30);
        System.out.println("Print root "+bst.getRoot());
        System.out.println("Print get "+bst.get("C"));
        System.out.println("Print get "+bst.get("F"));
        bst.delete("P");
        System.out.println("Print Deleted Node");
    }

    private void delete(String key) {
        Node nodeTobeDeleted=get(key);
        if(nodeTobeDeleted==null)
        {
            System.out.println(" Key Not found in BST");
            return;
        }
        //Node has no children
        if(nodeTobeDeleted.left==null && nodeTobeDeleted.right ==null)
        {
            Node parentNode=getParent(key);
            if(parentNode!=null && parentNode.left.equals(nodeTobeDeleted))
                parentNode.left=null;
            if(parentNode!=null && parentNode.right.equals(nodeTobeDeleted))
                parentNode.right=null;

        }
        //Node has one left children
        if(nodeTobeDeleted.left!=null && nodeTobeDeleted.right ==null)
        {
            Node parentNode=getParent(key);
            if(parentNode!=null && parentNode.left.equals(nodeTobeDeleted))
            {
                parentNode.left=nodeTobeDeleted.left;
                nodeTobeDeleted.left=null;
            }

            if(parentNode!=null && parentNode.right.equals(nodeTobeDeleted))
            {
                parentNode.right=nodeTobeDeleted.left;
                nodeTobeDeleted.left=null;
            }
        }

        //Node has one right children
        if(nodeTobeDeleted.left==null && nodeTobeDeleted.right !=null)
        {
            Node parentNode=getParent(key);
            if(parentNode!=null && parentNode.left.equals(nodeTobeDeleted))
            {
                parentNode.left=nodeTobeDeleted.right;
                nodeTobeDeleted.right=null;
            }

            if(parentNode!=null && parentNode.right.equals(nodeTobeDeleted))
            {
                parentNode.right=nodeTobeDeleted.right;
                nodeTobeDeleted.right=null;
            }
        }

        //Node has both children
        if(nodeTobeDeleted.left!=null && nodeTobeDeleted.right !=null)
        {
            Node parentNode=getParent(key);
            Node replaceNode=getMinimum(nodeTobeDeleted.right);
            if(parentNode!=null && parentNode.left.equals(nodeTobeDeleted))
            {
                parentNode.left=replaceNode;
                nodeTobeDeleted.right=null;
                nodeTobeDeleted.left=null;
            }

            if(parentNode!=null && parentNode.right.equals(nodeTobeDeleted))
            {
                parentNode.right=replaceNode;
                nodeTobeDeleted.right=null;
                nodeTobeDeleted.left=null;
            }
        }



    }

    private Node getMinimum(Node right) {
        Node curr=right;
        Node parent=curr;
        while(curr!=null)
        {
            parent=curr;
            curr=curr.left;
        }
        return parent;
    }

    private Node getParent(String key) {
        Node curr=root;
        Node parent=null;
        while(curr!=null)
        {
            parent=curr;
            int cmp=key.compareTo(curr.key);
            if(cmp <0)
                curr=curr.left;
            if(cmp>0)
                curr=curr.right;
            if(cmp==0){
                return parent;
            }
        }
        System.out.println("Key Not Present in BST *************");
        return null;
    }

    private Node get(String key) {
        Node curr=root;
        while(curr!=null)
        {
            int cmp=key.compareTo(curr.key);
            if(cmp <0)
                curr=curr.left;
            if(cmp>0)
                curr=curr.right;
            if(cmp==0){
                return curr;
            }
        }
        System.out.println("Key Not Present in BST *************");
        return null;
    }

    private Node put(String key, int val) {
        if(root==null)
            root=new Node(key, val);

        Node x= root;
        Node parent=null;
        while(x!=null)
        {
            parent=x;
            int cmp=key.compareTo(x.key);
            if(cmp <0)
                x=x.left;
            if(cmp>0)
                x=x.right;
            if(cmp==0){
                x.val=val;
                return root;
            }

        }
        int cmp=key.compareTo(parent.key);
        if(cmp <0)
        {
            parent.left=new Node(key,val);
        }
        if(cmp>0)
            parent.right=new Node(key,val);

        return root;

    }
}

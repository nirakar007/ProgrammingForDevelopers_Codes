 public class Tree{

    public static class Node{
        
        Node left;
        Node right;
        int data;

        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
        
    }


    // Tree traveling algorithms


// in-order algorithm : left root right   ______________________________________
    void inorder(Node root){

        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

// pre-order algorithm : root left right   ______________________________________
    void preorder(Node root){
        if(root == null) return;
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }


// pre-order algorithm : left right root  ______________________________________    
    void postorder(Node root){
        if(root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data);
    }

    public static void main(String[] args){
        Node root = new Node(10); // storing the data "10" in the root node
        root.left = new Node(20);
        root.right = new Node(50);
        root.left.left = new Node(30);

    }

 }
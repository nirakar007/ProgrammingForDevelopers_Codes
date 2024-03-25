public class AVLTree {  // self balancing binary tree
    
    public static class Node{
        Node left; 
        Node right;
        int height;
        int data;
        
        Node (int data){
            this.data = data;
            this.left = this.right = null;
            this.height = 1; // since adding nodes are connected via edges, this keeps count of the edges made 
        }
    }

    Node createBST(Node root, int data){

        // connecting the nodes properly  
        if(root == null){
            return new Node(data); // make a new node which will be the main root node
        }
        if(data < root.data){
            root.left = createBST(root.left, data);
        }
        else if(data > root.data){
            root.right = createBST(root.right, data);
        }
        else{
            return root;
        }
        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        int balanceFactor = getBalanceFactor(root);
        if(balanceFactor > 1 && data < root.left.data){
            // case LL
            return rightRotate(root);
        }
        else if(balanceFactor > 1 && data > root.left.data){
            // case LR
            root.left = leftRotate(root.left);    // apply rotate to the left
            return rightRotate(root); // 
        }
        else if(balanceFactor > 1 && data > root.right.data){
            // case RR
            return leftRotate(root);
        }
        else if(balanceFactor < 1 && data < root.right.data){
            //case RL
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        
        return root;
        

    }

    Node rightRotate(Node y){ // right == y
        Node x = y.left;
        Node t2 = x.right;
        x.right = y;
        y.left = t2; // if !t2, then null
        // update height
        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right)); // y is a subtree
        x.height =  1 + Math.max(getHeight(x.left), getHeight(x.right)); // x is a subtree

        return x;
    }

    Node leftRotate(Node x){ // left == x
        Node y = x.right;
        Node t2 = y.left;
        y.left = x;
        x.right = t2;
        // update height
        x.height =  1 + Math.max(getHeight(x.left), getHeight(x.right)); // x is a subtree
        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right)); // y is a subtree

        return y;
        
    }

    // note: 
    /*
     * if balance factor +ve => left skewed
     */

    int getBalanceFactor(Node node){

        if (node == null){
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right); // height of left subtree - height of right subtree 

    }

    int getHeight(Node node){
        if( node == null ){
            return 0;
        }
        return node.height; // the value of the height is already defined in the constructor
    }
}

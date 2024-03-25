import org.w3c.dom.Node;

public class DoublyLinkedList {
    
    public static class Node{
        
        int data;
        Node prev;
        Node next;
        // int size; 

        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    Node head  = null;
    Node tail = null;

    void addNode(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
        }
        else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }
    

        public void printList(){
        Node current = head; // initialize from the head

        while (current != null){  // 
            System.out.println(current.data+" "); // print the data of current node
            current = current.next; // move to next node
        }

        System.out.println(); // print new line in the end
        
    }
}

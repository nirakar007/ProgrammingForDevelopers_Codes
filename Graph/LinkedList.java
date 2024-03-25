// package Linked List;

public class LinkedList {
    
    public static class Node{ // a structure
        int data;
        Node next; // yei class bata baneko object ko address store garcha 
        
        
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    Node head = null; 
    void addNode(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
        }
        else{
            Node current = head; // head = current = 100,
            
            while(current.next != null){
                current = current.next; // naya current ko adress equals purano current ko address

            }
            current.next = newNode;
        }
    }

    void addHeadFirst(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }




    public void printList(){
        Node current = head; // initialize from the head

        while (current != null){  // 
            System.out.println(current.data+" "); // print the data of current node
            current = current.next; // move to next node
        }

        System.out.println(); // print new line in the end
        
    }

    // 1 insert data at any position
    public void insertDataAtAnyPos(int data, int pos){
        Node newNode = new Node(data);
        Node current = head;
        for(int i=1;i<pos-1;i++){
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;

    }


    // 2 insert data after
    void insDataAfter(int data, Node node){
        Node newNode = new Node(data);
        newNode.next = node.next;
        node.next = newNode;
    }

    // 3 insert before
    void insBefore(int data, Node node){
        Node newNode = new Node(data);
        Node current = head;
        while(current.next != node){
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    // 4 remove data at any position
    void removeDataAtAnyPos(int pos){
        Node current = head;
        for(int i=1; i<pos-1; i++){
            current = current.next;
        }
        Node temp = current.next;
        current.next = temp.next;
        temp.next = null;
    }


    // 5 remove node after
    void removeNodeAfter(Node node){
        if(node != null && node.next != null){
            Node temp = node.next;
            node.next = temp.next;
            temp.next = null;
        }

    }


    // 6 remove Node Before
    void removeNodeBefore(Node node){
        if(node != null && head != null && head != node){
            Node current = head;
            while (current.next != null && current.next != node){
                current = current.next;
            }

            if(current.next != null){
                Node temp = current.next;
                current.next = temp.next;
                temp.next = null;
            }
        }
    }

    // 7 remove node 
    void removeNode(Node node){
        Node current = head;
        while(current.next != node){
            current = current.next;
        }
        current.next = node.next;
    }

    // 8 get data at any position
    int getDataAtAnyPosition(int pos){
        Node current = head;
        for(int i = 1; i < pos; i++){
            current = current.next;
        }
        return current.data;
    }




    public static void main(String[] args) {
        LinkedList l = new LinkedList();

        for(int i=1; i<5; i++){
            l.addNode(i);
        }

        l.printList();

    }
}

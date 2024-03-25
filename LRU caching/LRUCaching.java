import java.util.HashMap;

public class LRUCaching{
    public class Node{
    
    int key;
    int value;
    Node next;
    Node prev;

    Node(int key, int value){
        this.key = key;
        this.value = value;
        this.prev = this.next = null;
    }
    }

    int capacity;
    HashMap<Integer, Node> map; // declaring hash map <key, value>
    
    LRUCaching(int capacity){
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public void put(int key, int value){
        if(map.containsKey(key)){
            remove(map.get(key));
            // remove that node and re-insert           
        } 
        else if(map.size() == capacity){
            remove(tail);
        }
        else{
            Node newNode = new Node(key,value);
            insert(newNode);
        }
    }

    
    int get(int key){
        Node node = map.get(key);
        if(node == null){
            return -1;
        }
        remove(node);
        insert(node);
        return node.value;
    }


    void remove(Node node){
        map.remove(node.key); // remove garda kheri hash map bata pani remove hunu parcha
        if (node == head) {
            head.next.prev = null;
            Node temp = head.next;
            head.next=null;
            head = temp;
        }
        else if (node == tail) {
            tail.prev.next = null;
            Node temp = tail.prev;
            tail.prev = null;
            tail = temp; // back to connection
        }
        else{
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = node.prev = null;
        }
    }
    
    
    Node head;
    Node tail;
    void insert(Node newNode){
        map.put(newNode.key, newNode);
        if(head==null){
            head = tail = newNode;
        }
        else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }



}
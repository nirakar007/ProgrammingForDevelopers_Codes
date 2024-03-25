package Queue;
public class Queue {

    int q[];

    int front = -1;
    int rear = -1;
    int size;

    Queue(int size){
        this.size = size;
        q = new int[size];
    }


    // to push elements in
    void enqueue(int data){
        if(isFull()){
            System.out.println("Queue overflow.");
        }
        else{
            if(isEmpty()){
                front = rear = 0;
                q[rear] = data;
            }
            else{
                q[++rear]=data;
            }
        }

    }

    
    
    // to pop elements
    int dequeue(){
        if(isEmpty()){
            System.out.println("queue undeflow");
            return -9999;
        }
        if(front==rear){
            int temp = front;
            front = rear = 1;
            return q[temp];
        }
        else{
            // int temp = front;
            // front++; // increase index when elements are removed
            return q[front++];
        }
    }



    boolean isFull(){
        return rear == size - 1;
    }
    

    boolean isEmpty(){
        return front == -1 && rear == -1;
    }



    public static void main(String[] args) {
        Queue qu = new Queue(5);
        qu.enqueue(10);
        qu.enqueue(15);

        qu.dequeue();
    }
    
}




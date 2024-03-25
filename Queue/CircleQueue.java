package Queue;

public class CircleQueue {

    private int[] q;
    private int front;
    private int rear;
    private int size;

    CircleQueue(int capacity){
        q = new int[capacity];
        front = -1;
        rear = -1;
        size = capacity;
    }

    void enqueue(int data){
        if((rear+1) % size == front){
            System.out.println("full");
        }
        else{
            if(front == -1 && rear == -1){
                front = rear = 0;
                q[rear] = data;
            }
            rear = (rear+1)%size;
            q[rear] = data;
        }
    }

    int dequeue(){
        if(front == -1){
            System.out.println("Empty");
            return -9999;
        }
        if(front == rear){
            int temp = front;
            front = rear = -1;
            return q[temp];
        }

        int temp = front;
        front = (front + 1)%size;
        return q[temp];
    }
}

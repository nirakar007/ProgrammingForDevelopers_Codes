package Queue;

public class QueueStack<T>{

    private Object[] stackEnq;
    private Object[] stackDeq;
    private int sizeEnq;
    private int sizeDeq;
    
    public QueueStack(){
        stackEnq = new Object[10];
        stackDeq = new Object[10];
        sizeEnq = 0;
        sizeDeq = 0;
    }

    public void enqueue(T item){
        ensureCapacity();
        stackEnq[sizeEnq++] = item;
    }

    public T dequeue(){
        
        if(isEmpty()){
            System.out.println("Queue is empty!");
        }

        if (sizeDeq == 0) {
            transferElements();
        }

        return (T) stackDeq[--sizeDeq];
    }
    

    public boolean isEmpty(){
        return sizeEnq == 0 && sizeDeq == 0;
    }

    private void transferElements(){
        while(sizeEnq > 0){
            ensureCapacity();
            stackDeq[sizeDeq++] = stackEnq[--sizeEnq];
        }
    }

    private void ensureCapacity(){
        
        if(sizeEnq == stackEnq.length){
            Object[] newStack = new Object[stackEnq.length * 2];
            System.arraycopy(stackEnq, 0, newStack, 0, sizeEnq);
            stackEnq = newStack;
        }

        if(sizeDeq == stackDeq.length){
            Object[] newStack = new Object[stackDeq.length * 2];
            System.arraycopy(stackDeq, 0, newStack, 0, sizeDeq);
            stackDeq = newStack;
        }
        
    }


    public static void main(String[] args) {
        QueueStack<Integer> q = new QueueStack<Integer>();

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        System.out.println("Dequeue: "+q.dequeue());
        System.out.println("Dequeue: "+q.dequeue());

        q.enqueue(4);
        System.out.println("Dequeue: "+q.dequeue());
        System.out.println("Dequeue: "+q.dequeue());




    }
}
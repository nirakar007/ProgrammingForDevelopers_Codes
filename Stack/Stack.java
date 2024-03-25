public class Stack {
    char stk[];
    int top = -1; // empty pointer; pointer that is not pointing to anything on the stack
    int size;

    Stack(int size) {
        this.size = size;
        stk = new char[size];
    }

    void push(char data) {
        if (isFull()) {
            System.out.println("Stack overflow..");
        } else {
            stk[++top] = data;
        }
    }

    char pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow..");
            return 'n'; // or return 99999;
        }
        int temp = top;
        top--;
        return stk[temp];
    }

    char peek() {
        if (isEmpty()) {
            System.out.println("Stack underflow..");
            return 'n'; // or return 99999;
        }
        int temp = top;
        return stk[temp];


    }

    boolean isFull(){
        return top == stk.length-1;
    }

    boolean isEmpty(){
        return top == -1;
    }
}

// public class Stack{
//     public static void main(String[] args) {

//         StacK st = new StacK(5);

//         st.push(1);
//         st.push(2);
//         st.push(3);
//         st.push(4);
//         st.push(5);

//         System.out.println("Popped element: "+st.pop());

//         System.out.println("Peeked element: "+st.peek());

//     }
// }


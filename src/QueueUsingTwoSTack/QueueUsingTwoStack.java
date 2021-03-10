package QueueUsingTwoSTack;

import java.util.Stack;

public class  QueueUsingTwoStack<T> {
    private  final Stack<T> forwardStack = new Stack<>();
    private final Stack<T> reverseStack = new Stack<> ();



    public void enqueue(T data) {
        if (forwardStack.isEmpty()) {
            while (!reverseStack.isEmpty()) {
                forwardStack.push(reverseStack.pop());
            }
            forwardStack.push(data);
        }
    }

        public T dequeue() {
            if(reverseStack.isEmpty()){
                while(!forwardStack.isEmpty()){
                    reverseStack.push(forwardStack.pop());
                }


            }
            return reverseStack.pop();
        }
    }


package QueueUsingCircularArray;

import java.lang.reflect.Array;
import java.util.Arrays;

public class QueueUsingCircularArray<T> {
    private T[] elements;
    private static final int SPECIAL_EMPTY_VALUE = -1;
    private  static int MAX_VALUE=40;
    private int  head = SPECIAL_EMPTY_VALUE;
    private int tail = SPECIAL_EMPTY_VALUE;

    public QueueUsingCircularArray(Class<T> clazz){
        elements = (T[]) Array.newInstance(clazz,MAX_VALUE);

    }

    public boolean isEmpty(){

        return head == SPECIAL_EMPTY_VALUE;
    }

    public  boolean isFull(){

    int nextIndex=(tail+1)%elements.length ;

    return nextIndex==head;
    }
    
    public void enqueue(T data){
        if (isEmpty()){
            head =tail;
        }
        else if (isFull()){
            System.out.println("Queue is Full");
        }

            int tailNextIndex= tail+1 % elements.length;
            elements[tailNextIndex]=data;

    }
        public T dequeue(){
            T data = elements[head];;
            if (isEmpty()){
                System.out.println("Queue is empty");
            }
             if (head==tail){
               head =SPECIAL_EMPTY_VALUE;
            }
             else {
                 head =head+1 % elements.length;
             }
            return data;
            
    }
    }


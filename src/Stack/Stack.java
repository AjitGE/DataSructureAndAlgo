package Stack;

public class Stack<E> {
    private  Element<E> top;
    private int size=0;
    private static int MAX_SIZE = 40;

    public void push(int data) throws StackOverFlow {
  if (isFull()){
      throw new StackOverFlow("Stack is full");
  }
            top= new Element (data,top);
  size++;

    }

    private boolean isFull() {
        return getSize()==MAX_SIZE;
    }

    public E pop() throws StackUnderFlow {
        if (isEmpty()){
            throw new StackUnderFlow("Stack is empty");
        }
        size--;
        E tmp = top.getData();
        top = top.getNext();
        return tmp;

    }

    public Element peek() throws StackUnderFlow {
        if (isEmpty()){
            throw new StackUnderFlow("Stack is Empty");
        }
       return top.getNext();


    }

    public boolean isEmpty() {
        return getSize()==0;
    }

    public int getSize(){
        return size;
    }


}

package LinkedList;

public class Node <T extends Comparable<T>>{
    private final T data;
    private Node<T> next;

    public Node(T data){
     this.data = data;
     setNext(null);
    }
    public  T getData(){
        return data;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
     public Node<T> getNext(){
        return next;
     }
     @Override
    public String toString(){
        return String.valueOf(data);

     }
}

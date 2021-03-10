package LinkedList;

public class LinkedList <T extends Comparable<T>> implements Cloneable{

   private Node<T> head= null;
   private static int size;



    public void addNode(T data){

       if (head == null){
           head = new Node<>(data);
           size++;
       }
       else{
           Node<T> current = head;

           while (current.getNext() != null) {
               current = current.getNext();
           }
              current.setNext(new Node<>(data));
           size++;
           }


       }

    public void addNode(int index,T data){

        if (index>size-1 || index<0){
            System.out.println("Index out of bound "+index);
        }
        else{

            Node<T> current=head ;
            if(index==0){
            head=new Node<T>(data);
            head.setNext(current);

        }
          else{
           for (int i=1;i<index;i++){
               current = current.getNext();
            }
            Node<T>   elementAtIndex=current.getNext();
            current.setNext(new Node<>(data));
            Node<T>  nextOfAddedNode=current.getNext();
            nextOfAddedNode.setNext(elementAtIndex);

          }
          size++;
        }

    }


   public T getData(int index) {
       Node<T> current = head;
       if (head == null) {
           throw new NullPointerException();
       } else if (index > size-1) {
           throw new ArrayIndexOutOfBoundsException();
       } else {
           for (int i = 0; i <= index; i++) {

               current = current.getNext();

           }
           return current.getData();
       }
   }
       public int getSize() {
           return size;
       }
       public void insert(int index, T data){
       Node<T> current = head;
          for (int i=0; i<index-1; i++){

              current= current.getNext();

          }
          Node<T> tmp = current.getNext();
          current.setNext(new Node<>(data));
         Node<T> newNodeNext=current.getNext();
         newNodeNext.setNext(tmp);
         size++;

   }
   @Override
   public String toString() {
           StringBuilder sb = new StringBuilder();
           sb.append("[");
          for (int i=0; i<size;i++ ){
              sb.append(head.getData());
               head = head.getNext();
              if(i==size-1){
                  sb.append("]");
              }
              else
                  sb.append(", ");

           }
         return sb.toString();


   }
   }

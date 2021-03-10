package Stack;

public class Element<E> {
    E data;
    Element next;

    public Element(E data, Element next){
        this.data =data;
        this.next = next;

    }

    public void setData(E data){
        this.data =data;
    }

    public E getData(){
        return data;
    }

    public void setNext(Element next){
        this.next= next;

    }
    public Element getNext(){
        return next;
    }



}

import LinkedList.LinkedList;

public class checkLinkedList {
    private static LinkedList<Integer> newList =  new LinkedList<Integer>();

    public static  void main(String[] args){
        newList.addNode(12);
        newList.addNode(13);
        newList.addNode(14);
        newList.addNode(15);
        newList.addNode(16);
        newList.addNode(2,78);

        System.out.println(newList);



    }
}

package Tree;

import java.util.LinkedList;

public class Node<T extends Comparable> {
    T data;
    Node<T> leftChild;
    Node<T> rightChild;

    public Node(T data) {
        this.data = data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }

    public void breadthFistTraversal(Node<T> root) {

        if (root == null) {
            return;
        }
        LinkedList<Node<T>> queue = new LinkedList();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node<T> node = queue.poll();
            System.out.print(node + "--->");

            if (node.leftChild != null) {
                queue.add(node.leftChild);
            }
            if (node.rightChild != null) {
                queue.add(node.rightChild);
            }
        }


    }

    public void deptFirstSearchPreOrder(Node<T> root) {
        if (root == null) {
            return;
        }


        System.out.print(root + "--->");
        deptFirstSearchPreOrder(root.getLeftChild());
        deptFirstSearchPreOrder(root.getRightChild());
    }

    public void deptFirstSearchInOrder(Node root) {
        if (root == null) {
            return;
        }


        deptFirstSearchPreOrder(root.getLeftChild());
        System.out.print(root + "--->");
        deptFirstSearchPreOrder(root.getRightChild());
    }

    public void deptFirstSearchPostOrder(Node root) {
        if (root == null) {
            return;
        }


        deptFirstSearchPreOrder(root.getLeftChild());
        deptFirstSearchPreOrder(root.getRightChild());
        System.out.print(root + "--->");


    }

    public Node<Integer> binaryTreeInsertion(Node<Integer> root, int data) {
        Node<Integer> node = new Node(data);
        if (root == null) {
            return node;

        }

        if (data <= root.getData()) {
            root.setLeftChild(binaryTreeInsertion(root.getLeftChild(), data));
        } else {
            root.setRightChild(binaryTreeInsertion(root.getRightChild(), data));
        }
        return root;
    }


    public Node<Integer> SearchData(Node<Integer> root, int data) {

        if (root == null) {
            return null;

        }
        if (data == root.getData()) {
            return root;
        }

        if (data <= root.getData()) {
            return SearchData(root.getLeftChild(), data);
        } else {
            return SearchData(root.getRightChild(), data);
        }

    }

    public int min(Node<Integer> root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        if (root.getLeftChild() == null) {

            return root.getData();
        }
        return min(root.getLeftChild());
    }

    public int max(Node<Integer> root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        if (root.getRightChild() == null) {

            return root.getData();
        }
        return max(root.getRightChild());
    }

    public int depth(Node<Integer> root) {
        if (root == null) {
            return 0;
        }
        if (root.getLeftChild() == null & root.getRightChild() == null) {
            return 0;
        }

        int lHieght = 1 + depth(root.getLeftChild());
        int rHieght = 1 + depth(root.getRightChild());

        return Math.max(lHieght,rHieght);
    }

    public void mirror(Node<Integer> root){
        if (root== null){
            return;
        }

        mirror(root.getLeftChild());
        mirror(root.getRightChild());

        Node<Integer> tempNode = root.getLeftChild();
        root.setLeftChild(getRightChild());
        root.setRightChild(tempNode);


    }

    public int numberOfPossibleTrees(int numberOfNodes){
        if (numberOfNodes<=1){
            return 1;
        }
        int sum= 0;
    for (int i= 1; i<=numberOfNodes;i++){
        int leftNodes= numberOfPossibleTrees(i-1);
        int rightNodes = numberOfPossibleTrees(numberOfNodes-i);
        sum= sum +(rightNodes*leftNodes);
    }
    return sum;
    }

    public void rageOfDataBetweenNodes(Node<Integer> root, int low, int high){
        if(root==null){
            return;
        }
        if (low<=root.getData()){
            rageOfDataBetweenNodes(root.getLeftChild(),low,high);
        }
        if (low<=root.getData() && root.getData()<=high){
            System.out.println(root.getData());
        }
        if (high> root.getData()){
            rageOfDataBetweenNodes(root.rightChild,low,high);
        }
    }

    public boolean isBinaryTree(Node<Integer> root,int min, int max){
        if (root==null){
            return true;
        }

        if (min>root.getData() || max<= root.getData()){
            return false;
        }
        return isBinaryTree(root.leftChild,min,root.getData()) &&
                isBinaryTree(root.rightChild,root.getData(),max);
    }


}





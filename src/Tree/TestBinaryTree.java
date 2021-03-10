package Tree;

public class TestBinaryTree {

    public static void main(String[] args){

        Node binaryTree = new Node("A");
        binaryTree.setLeftChild(new Node("B"));

        binaryTree.setRightChild(new Node("C"));
        binaryTree.getRightChild().setLeftChild(new Node("D"));
        binaryTree.getRightChild().setRightChild(new Node ("E"));
        binaryTree.getRightChild().getLeftChild().setLeftChild(new Node ("F"));
        binaryTree.getRightChild().getLeftChild().setRightChild(new Node("H"));
        binaryTree.getRightChild().getRightChild().setRightChild(new Node("G"));

        binaryTree.breadthFistTraversal(binaryTree);
        System.out.println();
        binaryTree.deptFirstSearchPreOrder(binaryTree);
        System.out.println();
        binaryTree.deptFirstSearchInOrder(binaryTree);
        System.out.println();
        binaryTree.deptFirstSearchPostOrder(binaryTree);
        Node intBinaryTree = new Node(10);
      intBinaryTree.binaryTreeInsertion(intBinaryTree,20);
        System.out.println();
      intBinaryTree.deptFirstSearchPostOrder(intBinaryTree);
        System.out.println();
        System.out.println(intBinaryTree.numberOfPossibleTrees(3));

    }
}

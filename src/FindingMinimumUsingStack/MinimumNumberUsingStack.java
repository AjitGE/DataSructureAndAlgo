package FindingMinimumUsingStack;


import java.util.Stack;

public class MinimumNumberUsingStack{

private static final Stack<Integer> mainStack = new Stack<>();
private static final Stack<Integer> minimumStack = new Stack<>();

public void push (int number){
    int minimum=number;
    if (!minimumStack.isEmpty()){
        if(minimum>minimumStack.peek()){
           minimum = minimumStack.peek();
        }
        mainStack.push(number);
        minimumStack.push(minimum);
    }
}

public int pop() {
        minimumStack.pop();
    return mainStack.pop();
}

public int getMinimum(){
   return  minimumStack.peek();

    }






}

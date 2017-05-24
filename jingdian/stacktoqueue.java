import java.util.Stack;
//2个栈实现队列
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
    	while(!stack1.isEmpty()){
            stack2.push(stack1.pop());//将stack1的放入stack2
        }
        int first = stack2.pop();//得到后再放入stack1
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return first;
    }
}
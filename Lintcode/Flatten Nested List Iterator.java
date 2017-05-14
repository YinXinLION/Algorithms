/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 *给你一个嵌套的列表，实现一个迭代器将其摊平。
 *一个列表的每个元素可能是整数或者一个列表。
 *给出列表 [[1,1],2,[1,1]]，经过迭代器之后返回 [1,1,2,1,1]。
 *给出列表 [1,[4,[6]]]，经过迭代器之后返回 [1,4,6]。
 */
import java.util.Iterator;

public class NestedIterator implements Iterator<Integer> {
    private Stack<NestedInteger> stack;
    
    private void pushListToStack(List<NestedInteger> nestedList){
        Stack<NestedInteger> temp = new Stack<>(); 
        for(NestedInteger nested : nestedList){
            temp.push(nested);
        }
        while(!temp.isEmpty()){
            stack.push(temp.pop());
        }
    }
    
    public NestedIterator(List<NestedInteger> nestedList) {
        // Initialize your data structure here.
        stack = new Stack<>();
        pushListToStack(nestedList);
    }

    // @return {int} the next element in the iteration
    @Override
    public Integer next() {
        // Write your code here
         if (!hasNext()) {
            return null;
        }
        return stack.pop().getInteger();
    }

    // @return {boolean} true if the iteration has more element or false
    @Override
    public boolean hasNext() {
        // Write your code here
        while(!stack.isEmpty() && !stack.peek().isInteger()){
            pushListToStack(stack.pop().getList());
        }
        return !stack.isEmpty();
    }

    @Override
    public void remove() {}
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v.add(i.next());
 */
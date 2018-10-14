package stack;

import java.util.Stack;

/**
 * 描述:只使用堆栈来实现队列
 *
 * https://leetcode.com/problems/implement-queue-using-stacks/description/
 *
 * 思路 :
 *      1.利用负负得正的一种思想,声明一个input堆栈,一个output堆栈
 *      2.当push时进入input堆栈,pop,peek时先判断output堆栈有无元素,有的话直接pop,无的话将input堆栈的内容依次push进去(负负得正)
 * 2018-10-14
 */
public class StackToQueue {
    private Stack<Integer> input = new Stack<Integer>();
    private Stack<Integer> output = new Stack<Integer>();


    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        if (!output.empty()){
            return output.pop();
        }
        while (!input.empty()){
            output.push(input.pop());
        }

        if (output.empty()){
            throw  new RuntimeException("不能pop空队列");
        }
        return output.pop();
    }

    public Integer peek() {
        if (!output.empty()){
            return output.peek();
        }
        while (!input.empty()){
            output.push(input.pop());
        }

        if (output.empty()){
            return null;
        }
        return output.peek();
    }

    public boolean empty() {
        return input.empty() && output.empty();
    }

    public static void main(String[] args) {
        StackToQueue queue = new StackToQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        while (!queue.empty()){
            System.out.println(queue.pop());
        }
    }
}

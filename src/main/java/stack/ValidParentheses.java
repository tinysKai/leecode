package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 描述: 判断给定的元素是否是匹配的括号
 *
 * https://leetcode.com/problems/valid-parentheses/description/
 *
 * 思路 :
 *         1.使用堆栈
 *         2.使用map声明括号关系,key存放右括号,值存放左括号
 *         3.最终遍历完字符串需判断堆栈是否为空
 *
 * 2018-10-14
 */
public class ValidParentheses {
    private static  Stack<Character> stack = new Stack<Character>();
    private static  Map<Character,Character> map = new HashMap<Character, Character>();

    /**
     * 初始化括号映射关系
     */
    private static  void initMap() {
        map.put('}','{');
        map.put(']','[');
        map.put(')','(');
    }

    public static  boolean isValid(String s){
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            //右括号出栈判断是否匹配
            if (map.containsKey(aChar)){
                char val = stack.pop();
                if (val != map.get(aChar)){
                    return false;
                }
            }else{
                //左括号入栈
                stack.push(aChar);
            }
        }

        //遍历完
        if (stack.size() == 0){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        initMap();
        String s = "((([{}])))";
        System.out.println(isValid(s));
    }
}

package recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述: 生成有效括号组合
 *
 * https://leetcode.com/problems/generate-parentheses/
 *
 * For example, given n = 3, a solution set is:
     [
     "((()))",
     "(()())",
     "(())()",
     "()(())",
     "()()()"
     ]

 * 思路
 *
 *  使用递归的方式
 *
 *  对于一个给定数字N,则将其变换为填充一个长度为2N的字符串,每个字符有两种相应的可能性,非左括号即右括号
 *
 *  然后对以上算法进行剪枝
 *      1.局部不合法筛除,比如右括号比左括号多的情况
 *      2.针对此题的特殊规则进行过滤 : 比如此题左括号数为N,右括号数为N,不能多不能少
 *
 *  剪枝之后的复杂度为 : O(2^n)
 *
 *
 * 2018-11-14
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        //声明一个保存结果的列表
        List<String> list = new ArrayList<>();
        gen(0,0,n,"",list);
        return list;
    }


    /**
     *
     * @param left  左括号使用了几次
     * @param right 右括号使用了几次
     * @param n     每个括号最多使用几次
     * @param result    每次有返回值的结果,这个递归会有多个解
     * @param list  用来保存结果的列表
     */
    private void gen(int left, int right, int n ,String result,List<String> list){
        //当左右括号各填充完毕时,添加此分支的结果
        if (left == n && right == n){
            list.add(result);
            return;
        }

        //左括号补充完还是会接着往下走的补充右括号,所以会出现补充了"()()"这种情况
        //正常的递归使用了return 返回..而这里没有返回...所以当N等于2时,才有可能出现"(())"这种调用完后接着执行"()()"的逻辑
        if (left < n){
             gen(left + 1,right,n,result+ "(",list);
        }

        //还有一个条件要注意是左括号个数需大于右括号
        if (right < n && left > right){
             gen(left,right+1,n,result + ")" ,list);
        }
    }
}

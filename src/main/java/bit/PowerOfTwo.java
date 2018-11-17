package bit;

/**
 * 描述: 判断给定的数是否是2的n次幂
 *
 * https://leetcode.com/problems/power-of-two/
 *
 * 思路 :
 *  利用2的幂次方只有开头位的一位bit位为1,则使用n & (n-1)来判断其是否是只有一个1..
 *  首先,大于0的数肯定会有大于或等于1个的1在二进制里面,而2的幂次方则刚好只有一个1,移除最右的一位1则等于0
 *
 * 2018-11-17
 */
public class PowerOfTwo {
    public static boolean isPowerOfTwo(int n) {
        int bit = n & (n-1);
        return n > 0 && (bit == 0);
    }

    public static void main(String[] args) {
        System.out.print(isPowerOfTwo(5));
    }

}

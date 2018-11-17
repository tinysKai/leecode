package bit;

/**
 * 描述: 计算一个给定的整数有多少个二进制1
 *
 * https://leetcode.com/problems/number-of-1-bits/
 *
 * 思路 :
 *      1.使用整除%2后统计,并且>>1位
 *
 *      2.利用位运算 X=X&(X-1)来清除其最后一位为1的数,直到数字等于0统计完毕
 *
 * 2018-11-17
 */
public class NumberOfOneBit {
    /**
     * 使用整除,右移的方式来计算
     * @param n
     * @return
     */
    public static int hammingWeight(int n) {
        int result = 0;
        while (n != 0){
            int num = n % 2;
            if (num == 1) result++;
            n = n >> 1; //右移一位
        }
        return result;
    }

    /**
     * 使用 `n = n & (n-1)`来清除最右一位的1的方式
     * @param n
     * @return
     */
    public static  int hammingWeight2(int n) {
        int result = 0;
        while (n != 0){
            result++;
            n = n & (n-1);
        }

        return result;
    }


    public static void main(String[] args) {
        int num = 11;
        System.out.println(hammingWeight(num));
        System.out.println(hammingWeight2(num));
    }
}

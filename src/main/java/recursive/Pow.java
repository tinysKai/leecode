package recursive;

/**
 * 描述: Pow(x,n)
 *
 * https://leetcode.com/problems/powx-n
 *
 * 思路 :
 *      利用分而治之的方法
 *      当n为偶数时,result = x^(n/2) * x^(n/2)
 *      当n为奇数时,result = x^(n/2) * x^(n/2) * x
 *
 *      需注意n为负数时,结果为倒数
 *
 * 2018-10-28
 */
public class Pow {
    public double myPow(double x, int n) {
        if( n == 0)
            return 1;

        if (n < 0){
            x = 1/x;
            n = -n;
        }

        //注意x^(n/2) * x^(n/2) 等于 (x*x)^(n/2)
        return n % 2 == 0 ? myPow(x*x,n/2) : myPow(x*x,n/2) * x;
    }
}

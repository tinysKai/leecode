package binarySearch;

/**
 * 描述: 求一个数的开平方根
 *
 * 思路 :
 *  利用二分法进行查找
 *
 *  另一种思路是利用牛顿迭代法
 * 2018-11-16
 */
public class Sqrt {

    public static final double precision = 0.0001;

    public static  double sqrt(int n){
        if (n < 0){
            throw new RuntimeException("平方数不能小于0");
        }
        if ( n == 0 || n == 1) return 1;
        
        double l = 1, r = n,res = 0;
        while (l <= r){
            double mid = (l + r)/2;
            double plus = mid * mid;
            if (Math.abs(n - plus) < precision ){
                return mid;
            }else if (plus > n){
                r = mid;
            }else {
                l = mid;
                res = mid;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.print(sqrt(3));
    }
}

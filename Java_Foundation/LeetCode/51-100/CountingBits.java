package stage.two.klaus;

/**
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 *
 * Example 1:
 *
 * Input: 2
 * Output: [0,1,1]
 * Example 2:
 *
 * Input: 5
 * Output: [0,1,1,2,1,2]
 */
public class CountingBits {

    /**
     * 这道题给我们一个整数n，然我们统计从0到n每个数的二进制写法的1的个数，存入一个一维数组中返回，题目中明确表示不希望我们一个数字一个数字，
     * 一位一位的傻算，而是希望我们找出规律，而且题目中也提示了我们注意 [2-3], [4-7], [8-15] 这些区间的规律，那么我们写出0到 15 的数的二进制和1的个数如下：
     *
     *
     * 0    0000    0
     * -------------
     * 1    0001    1
     * -------------
     * 2    0010    1
     * 3    0011    2
     * -------------
     * 4    0100    1
     * 5    0101    2
     * 6    0110    2
     * 7    0111    3
     * -------------
     * 8    1000    1
     * 9    1001    2
     * 10   1010    2
     * 11   1011    3
     * 12   1100    2
     * 13   1101    3
     * 14   1110    3
     * 15   1111    4
     *
     * 我最先看出的规律是这样的，除去前两个数字0个1，从2开始，2和3，是 [2^1, 2^2) 区间的，值为1和2。而4到7属于 [2^2, 2^3) 区间的，值为 1,2,2,3，
     * 前半部分1和2和上一区间相同，2和3是上面的基础上每个数字加1。再看8到 15，属于 [2^3, 2^4) 区间的，同样满足上述规律，
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;
        res[1] = 1;
        int k = 2, i = 2;
        while(i <= num){
            for(i = (int)Math.pow(2, k - 1); i < Math.pow(2, k);i++){
                if( i > num)
                    break;
                int t = (int) (Math.pow(2, k) - Math.pow(2,k - 1)) / 2;
                if(i < Math.pow(2, k - 1) + t)
                    res[i] = res[i - t];
                else res[i] = res[i - t] + 1;
            }
            ++k;
        }
        return res;

    }

    //方法2
    /**
     * 下面这种方法相比第一种方法就要简洁很多了，这个规律找的更好，规律是，从1开始，遇到偶数时，其1的个数和该偶数除以2得到的数字的1的个数相同，
     * 遇到奇数时，其1的个数等于该奇数除以2得到的数字的1的个数再加1
     */

    public int[] countBits02(int num){
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++){
            if(i % 2 == 0){
                res[i] = res[i / 2];
            }
            else{
                res[i] = res[i / 2] + 1;
            }
        }
        return res;
    }
}

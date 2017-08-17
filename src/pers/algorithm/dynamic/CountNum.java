package pers.algorithm.dynamic;

import java.util.Scanner;

/**
 * 要求输入数列长度n,数列中元素的最大值k，即数列中每个元素的范围为(1~k)  【n<=10,k<=10000】
 * 数列中相邻两数表示为a,b   要求a<=b 或者 a mod b != 0,否则此数列不算
 * 输出符合规则的数列的个数
 *
 *
 * state[i][j]表示整个状态空间，其中i(1<=i<=n)表示数列的长度，j(1<=j<=k)
 * 表示数列长度为i且以数字j结尾。
 * 递推关系有：state[i][j] += state[i-1][m] (1<=m<=k, 并且(m,j)是个合法的数列)，
 * 将长度为i-1的合法数列求和(记为sum)，然后对于数列长度为i的每一个j，
 * 求出数列长度为i-1时非法的序列个数（记为invalid）,即有state[i][j] = sum - invalid
 */
public class CountNum {
    static final int mod = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] state = new int[n+1][k+1];

        state[0][1] = 1;

        for(int i=1; i<=n; i++) {
            int sum = 0;
            for(int j=1; j<=k; j++) {
                sum = (sum + state[i-1][j]) % mod;
                }
            for(int j=1; j<=k; j++) {
                int invalid = 0;
                int p = 2;
                while(p*j <= k) {
                    invalid = (invalid + state[i-1][p*j]) % mod;
                    p++;
                    }
                state[i][j] = (sum - invalid + mod) % mod;
                }
            }

        int sum = 0;
        for(int i=1; i<=k; i++) {
            sum = (sum + state[n][i]) % mod;
            }
        System.out.println(sum);

        scanner.close();
        }
}
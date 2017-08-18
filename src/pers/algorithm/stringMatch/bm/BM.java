package pers.algorithm.stringMatch.bm;

import java.util.HashMap;

/**
 * 字符串匹配算法Boyer-Moore
 * 坏字符  好后缀
 * 后缀蛮力匹配 模式串为P  匹配串为T
 * http://blog.csdn.net/appleprince88/article/details/11881323
 */
public class BM {
    /**
     * 表示坏字符‘k'在模式串P中最右出现的位置距离末尾的长度
     * bmBc.get('k')
     */
    private static HashMap<String,Integer> bmBc;

    /**
     * 表示好后缀原则的最大长度 suffix[i] = s
     * 满足P[i-s,i] == T[m-s,m] 最大长度为s
     *
     */
    private static int[] suffix;


}

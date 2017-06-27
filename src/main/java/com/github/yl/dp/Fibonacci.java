package com.github.yl.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanglei on 2017/6/27.
 * 斐波那契数列
 * 1  1  2  3  5  8  13  21  34  55 ...
 */
public class Fibonacci {

    //使用递归求解
    public static long getFibona1(int n) {
        if (n <= 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;

        return getFibona1(n - 2) + getFibona1(n - 1);
    }

    //使用缓存（备忘录算法）
    public static long getFibona2(int n, Map<Integer, Long> map) {
        if (n <= 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            long result = getFibona2(n - 2, map) + getFibona2(n - 1, map);
            map.put(n, result);
            return result;
        }
    }

    //使用动态规划求解
    public static long getFibona3(int n) {
        if (n <= 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        long a = 1;
        long b = 1;
        long temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return temp;

    }

    public static void main(String[] args) {
        System.out.println(getFibona1(9));

        Map<Integer, Long> resultMap = new HashMap<Integer, Long>();
        System.out.println(getFibona2(10, resultMap));
        System.out.println(getFibona3(9));

    }
}

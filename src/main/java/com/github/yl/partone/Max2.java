package com.github.yl.partone;


import java.util.Random;

/**
 * Created by lei.yang on 16/5/2.
 * 从一个数据区间[lo,hi)里面查找最大的两个数
 */
public class Max2 {

    //三个for循环
    public String max2(int[] array,int lo,int hi){
        int i=lo+1;
        int x1,x2;
        for( x1 = lo;i < hi;i++){
            if(array[x1] < array[i])
                x1 = i;
        }
        for( x2=lo,i=lo+1;i<x1;i++){
            if(array[x2]<array[i])
                 x2=i;
        }
        for( i=x1+1;i<hi;i++){
            if(array[x2] < array[i])
                x2=i;
        }
        return "max2###"+"x1: "+array[x1]+" x2: "+array[x2];

    }

    //一个for循环
    public String max2Good(int[] array,int lo,int hi){

        int x1=lo,x2=lo+1;
        if(array[x1] < array[x2]){
            int temp = x1;
            x1=x2;
            x2=temp;
        }
        for(int i=lo+2;i<hi;i++){
            if (array[x2] < array[i]){
                x2 = i;
                if(array[x1] < array[x2] ){
                    int temp = x1;
                    x1=x2;
                    x2=temp;
                }
            }
        }
        return "max2Good###"+"x1: "+array[x1]+" x2: "+array[x2];

    }

    /**
     * 递归和分治的方法进行设计该算法
     * 未完成，后期再学习整理
     * @param array
     * @param lo
     * @param hi
     * @return
     */
    public String max2Better(int[] array,int lo,int hi){
        int x1,x2;
        if(lo +2 == hi){
            if(array[lo] > array[lo+1]){
                x1 = lo;
                x2=lo+1;
                return "max2Better###"+"x1: "+array[lo]+" x2: "+array[lo+1];
            }else{
                x1 = lo+1;
                x2=lo;
                return "max2Better###"+"x1: "+array[lo]+" x2: "+array[lo+1];
            }
        }
        if(lo +3 == hi){
            x1 = lo;
            x2=lo+1;
            if(array[x1] < array[x2]){
                int temp = x1;
                x1 = x2;
                x2 = x1;
            }
            if(array[hi] > array[x2]){
                x2 = hi;
            }
            if(array[x1] < array[x2]){
                int temp = x1;
                x1 = x2;
                x2 = x1;
            }
        }
        return "";
    }


    public static void main(String[] args) {
        Max2 max2 = new Max2();
        Random random = new Random();
        int[] array = new int[2];
        for(int i=0;i<array.length;i++){
            array[i] = random.nextInt(1000);
            System.out.print(" "+array[i]);
        }
        System.out.println();

//        for(int i=0;i<100;i++){
//            array[i] = i;
//            System.out.print(" "+array[i]);
//        }
//        System.out.println();

        Long beforeTime2 = System.currentTimeMillis();
        for(int i=0;i<10000;i++){
            max2.max2Good(array, 0, array.length);
        }
        System.out.println(max2.max2Good(array, 0, array.length));
        System.out.println(System.currentTimeMillis()-beforeTime2);

        Long beforeTime = System.currentTimeMillis();
        for(int i=0;i<10000;i++){
            max2.max2(array, 0, array.length);
        }
        System.out.println(max2.max2(array, 0, array.length));
        System.out.println(System.currentTimeMillis()-beforeTime);






    }




}

package com.github.yl.sort;/** * Created by yanglei on 2017/4/23. * 冒泡、选择、插入排序 */public class SimpleSort {    /**     * 冒泡排序     *     * @param arry     */    public static void bubbleSort(int[] arry) {        if (arry.length <= 1) {            return;        }        for (int i = arry.length - 1; i > 1; i--) {            for (int j = 0; j < i; j++) {                if (arry[j] > arry[j + 1]) {                    swap(arry, j, j + 1);                }            }        }    }    /**     * 选择排序     * @param array     */    public static void selectSort(int[] array) {        if (array.length <= 1) {            return;        }        for (int i = array.length - 1; i > 1; i--) {            int max = i;            for (int j = 0; j<i;j++) {                if(array[j] > array[max]){                    max = j;                }            }            //交换这一趟找出的最大值            swap(array,max,i);        }    }    /**     * 插入排序     * @param array     */    public static void insertSort(int[] array){        if (array == null || array.length < 2) {            return;        }        for(int i=1;i<array.length;i++){            int currentValue = array[i];            int position = i;            for(int j = i-1;j>=0;j--){                //找到标记数据在已排序的局部的位置，并移动数据                if(array[j] > currentValue){                    array[j+1] = array[j];                    position--;                }            }            //将标记数据插入正确位置            array[position] = currentValue;        }    }    private static void swap(int[] a, int index1, int index2) {        int temp = a[index1];        a[index1] = a[index2];        a[index2] = temp;    }    private static void display(int[] array) {        System.out.print("{");        for (int i = 0; i < array.length; i++) {            System.out.print(array[i]);            if (i < array.length - 1) {                System.out.print(", ");            }        }        System.out.println("}");    }    public static void main(String[] args) {        int[] a = {1, 89, 38,23, 99, 3, 4, 10, 9, 53,3};        SimpleSort.bubbleSort(a);//        SimpleSort.selectSort(a);//        SimpleSort.insertSort(a);        SimpleSort.display(a);    }}
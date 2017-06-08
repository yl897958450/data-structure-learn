package com.github.yl.sort;

/**
 * Created by yanglei on 2017/4/23.
 * 归并排序
 */
public class MergeSort {

    private static void display(int[] array) {
        System.out.print("{");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }

    public static void mergeSort(int[] array){
        int[] tmpArray = new int[array.length];
        recMergeSort(array,tmpArray,0,array.length -1);
    }

    private static void recMergeSort(int[] array,int[] tmpArray,int start,int end){
        if(start == end){
            return;
        }else{
            int seperate = (start + end )/2;
            //左侧排序
            recMergeSort(array,tmpArray,start,seperate);
            //右侧排序
            recMergeSort(array,tmpArray,seperate+1,end);
            //合并
            merge(array,tmpArray,start,seperate+1,end);
        }
    }


    private static void merge(int[] array,int[] tmpArray,int leftPos,int rightPos,int rightEnd){
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;
        //依次比较要归并的左右两侧数组，将小的值放入临时数组
        while(leftPos <= leftEnd && rightPos <= rightEnd)
            if(array[leftPos] <= array[rightPos] )
                tmpArray[tmpPos++]=array[leftPos++];
            else
                tmpArray[tmpPos++]=array[rightPos++];
        //右侧数组已无数据，将左侧数组剩余数据copy到临时数据
        while (leftPos <= leftEnd)
            tmpArray[tmpPos++] = array[leftPos++];
        //左侧数组已无数据，将右侧数组剩余数据copy到临时数据
        while (rightPos <= rightEnd)
            tmpArray[tmpPos++] = array[rightPos++];
        //copy tmpArray back
        for(int j=0;j< numElements;j++,rightEnd--){
            array[rightEnd] = tmpArray[rightEnd];
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 89, 38,23, 99, 3, 4, 10, 9, 53,3};
        MergeSort.mergeSort(a);
        MergeSort.display(a);

    }
}

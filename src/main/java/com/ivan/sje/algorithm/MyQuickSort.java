package com.ivan.sje.algorithm;

import org.junit.Assert;
import org.junit.Test;

public class MyQuickSort {

    @Test
    public void test(){
        int[] arr=new int[]{4, 7, 6, 5, 3, 2, 8, 1};
//        quickSort(arr);
//        Assert.assertArrayEquals(new int[]{1,2,3,4,5,6,7,8},arr);
        arr=new int[]{0,0,1,2,4,2,2,3,1,4};
        quickSort(arr);
        Assert.assertArrayEquals(new int[]{0,0,1,1,2,2,2,3,4,4},arr );
    }

    public void quickSort(int[] arr){
        if(arr==null||arr.length==0){
            return;
        }
        quickSort(arr,0,arr.length-1);

    }

    public void quickSort(int[] arr,int start,int end){
        if (start >= end) {
            return;
        }
        int pivot=partition(arr,start,end);
        quickSort(arr,start,pivot-1);
        quickSort(arr,pivot+1,end);
    }

    public int partition(int[] arr,int start,int end){
//        int pivotIndex=start+(int)Math.random()*(end-start+1);
        int pivot=arr[start];
        int left=start;
        int right=end;
        while (left!=right){
            while (right>left && arr[right]>pivot){
                right--;
            }
            while (left<right && arr[left]<=pivot ){
                left++;
            }

            if(left<right){
                int temp=arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
            }

        }
        int p = arr[left];
        arr[left] = arr[start];
        arr[start] = p;
        return left;
    }
}

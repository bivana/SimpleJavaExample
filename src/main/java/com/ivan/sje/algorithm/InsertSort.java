package com.ivan.sje.algorithm;

import org.junit.Assert;
import org.junit.Test;

/**
 * 插入排序
 * */
public class InsertSort {

    @Test
    public void test(){
        int[] nums=new int[]{8,2,3,4,4,5,6,7,1};
        insertSort(nums);
        Assert.assertArrayEquals(new int[]{1,2,3,4,4,5,6,7,8},nums);
    }


    public void insertSort(int[] nums) {
        if(nums==null||nums.length<=1){
            return;
        }
        for(int i=1;i<nums.length;i++){
            for (int j=i;j>=1;j--){
                if(nums[j]<nums[j-1]){
                    swap(nums,j,j-1);
                }else{
                    break;
                }
            }
        }
    }



    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}

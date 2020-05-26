package com.ivan.sje.algorithm;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucktSort {
    @Test
    public void test(){
        Assert.assertArrayEquals(new int[]{1,2,3,4,4,5,6,7,8},sort(new int[]{8,2,3,4,4,5,6,7,1}));
    }

    public int[] sort(int[] nums){
        if(nums==null||nums.length==0){
            return nums;
        }
        int bucketLimit=5;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int num:nums){
            min=Math.min(min,num);
            max=Math.max(max,num);
        }
        int interval=max-min+1;
        int bucketSize=interval%bucketLimit==0?interval/bucketLimit:interval/bucketLimit+1;
        List<Integer>[] buckets=new ArrayList[bucketSize];
        for(int num:nums){
            int index=(num-min)/bucketLimit;
            if(buckets[index]==null){
                buckets[index]=new ArrayList<Integer>();
            }
            buckets[index].add(num);

        }
        for(List<Integer> bucket:buckets){
            Collections.sort(bucket);
        }
        int i=0;
        for(List<Integer> bucket:buckets){
            for(Integer num:bucket){
                nums[i++]=num;
            }
        }
        return nums;
    }
}

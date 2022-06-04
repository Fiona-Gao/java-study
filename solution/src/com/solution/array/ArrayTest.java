package com.solution.array;

public class ArrayTest {
    /*
    删除有序数组中重复数字
    https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
     */
    public int removeDumplicates(int[] a){
        int n = 0;
        for (int i = 0; i < a.length; i++){
            if (i == 0 || a[i] == a[i-1]) {
                a[n] = a[i];
                n++;
            }
        }
        return n;
    }
    /*
    数组中0数字后移
    https://leetcode.cn/problems/move-zeroes/
     */
    public int[] moveZeroes(int[] nums) {
        int n = 0;
        for(int i=0; i < nums.length; i++){
            if (nums[i] != 0) {
                nums[n] = nums[i];
                if (n != i){
                    nums[i] = 0;
                }
                n++;
            }
        }
        return nums;
    }
    /*
    合并两个有序数组
    https://leetcode.cn/problems/merge-sorted-array/submissions/
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        for (int k = m + n - 1; k >= 0; k--){
            if (j < 0 || (i >= 0 && nums1[i] >= nums2[j])){
                nums1[k] = nums1[i];
                i --;
            }else {
                nums1[k] = nums2[j];
                j --;
            }
        }
    }
    /*
    加一 https://leetcode.cn/problems/plus-one/submissions/
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0 ;i --){
            if (digits[i] != 9){
                digits[i] = digits[i] + 1;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[digits.length+1];
        result[0] = 1;
        return result;
    }


}

package indi.pentiumcm.leetcode;

import java.util.*;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q14
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/3/31 9:11
 * @describe: 912. 排序数组
 */
public class Q14 {

    /**
     * 快速排序算法实现
     *
     * @param arr 待排序序列
     * @return
     */
    private static int[] quickSort(int[] arr, int low, int high) {

        if (low < high) {
            int pivotIndex = getPivotIndex(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
        return arr;
    }

    /**
     * 快速排序算法 -- 基准位置
     *
     * @param arr
     * @param low
     * @param high
     * @return
     */
    private static int getPivotIndex(int[] arr, int low, int high) {
//      获取基准数据
        int pivot = arr[low];

        while (low < high) {
//          尾指针向前遍历，当后面元素大于等于基准，high--
            if (low < high && arr[high] >= pivot) {
                high--;
            }
//          将后边小于等于基准元素的数填入到前面边相应位置
            arr[low] = arr[high];
//          头指针向后遍历，当前面元素小于等于基准，low++
            if (low < high && arr[low] <= pivot) {
                low++;
            }
//          将前边大于基准元素的数填入后边相应位置
            arr[high] = arr[low];
        }
//      当头指针和尾指针重合时，这个位置便是这一趟排序基准的正确位置
        arr[low] = pivot;
//      返回基准的正确位置
        return low;
    }

    public int[] sortArrayV2(int[] nums) {

        return quickSort(nums, 0, nums.length - 1);
    }


    public int[] sortArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];

//          采用二分查找，查找插入排序第i个元素在前面有序序列中的位置 pivot
            int low = 0, mid = 0, high = i - 1;
            int pivot = 0;
            while (low <= high) {
                mid = (low + high) / 2;
                if (current < nums[mid]) {
                    high = mid - 1;
                }
                if (current >= nums[mid]) {
                    low = mid + 1;
                }
            }
//          找到插入位置之后，将第 i 个元素插入到有序序列中
            pivot = low;
            for (int j = i; j > pivot; j--) {
                nums[j] = nums[j - 1];
            }
            nums[pivot] = current;
        }
        return nums;
    }


    public static int[] sortArrayV4(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            int preIndex = i - 1;

            while (preIndex >= 0 && nums[preIndex] > current) {
//              后移元素
                nums[preIndex + 1] = nums[preIndex];
                preIndex--;
            }
//          找到插入位置之后，将第 i 个元素插入到有序序列中
            nums[preIndex + 1] = current;
        }
        return nums;
    }


    /**
     * 计数排序算法实现
     *
     * @param arr
     * @return
     */
    public static int[] countingSort(int[] arr) {
        if (arr.length == 0) {
            return arr;
        }

//      min,max：确定用于计数的数组的大小，计数数组大小为：(max - min + 1)
        int min = arr[0], max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int[] bucket = new int[max - min + 1];

//      统计序列中各个元素出现的次数count
        for (int i = 0; i < arr.length; i++) {
            int bias = arr[i] - min;
//          第 i 个元素频次加1
            bucket[bias]++;
        }

//      把计数数组统计好的数据汇总到原数组
        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                arr[index] = min + i;
                index++;
            }
        }
        return arr;
    }


    public int[] sortArrayV3(int[] nums) {

        return countingSort(nums);
    }


    public static void main(String[] args) {
        int[] a = {5, 3, 7, 6, 2, 1, 4, 5, 0};
        a = new Q14().sortArrayV3(a);



        List<Integer> linkList = new LinkedList<>();

    }
}

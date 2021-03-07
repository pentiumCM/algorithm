package indi.pentiumcm.sort;

import java.util.*;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.sort
 * @className: BubbleSort
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/3/13 15:13
 * @describe: 排序算法工具类
 */
public class SortUtils {

    /**
     * 直接插入排序算法实现 O(n2)
     * <p>
     * 在含有 i − 1个元素的有序子序列中插入一个元素，使之成为含有 i 个元素的有序子序列
     *
     * @param arr 待排序序列
     * @return
     */
    public static int[] insertSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int preIndex = i - 1;

            while (preIndex >= 0 && arr[preIndex] > current) {
//              后移元素
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
//          找到插入位置之后，将第 i 个元素插入到有序序列中
            arr[preIndex + 1] = current;
        }
        return arr;
    }

    /**
     * 希尔排序算法实现
     *
     * @param arr 待排序序列
     * @return
     */
    public static int[] shellSort(int[] arr) {
        int len = arr.length;
//      设置默认增量为：n/2
        int gap = len / 2;

        while (gap > 0) {
            for (int i = gap; i < len - 1; i++) {
                int current = arr[i];
                int preIndex = i - gap;

                while (preIndex >= 0 && arr[preIndex] > current) {
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                arr[preIndex + gap] = current;
            }
            gap /= 2;
        }
        return arr;
    }


    /**
     * 选择排序算法实现 O(n2)
     * <p>
     * 从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾已排序序列的末尾
     *
     * @param arr 待排序序列
     * @return
     */
    public static int[] selectSort(int[] arr) {
//      min记录集合元素最小值的下标
        int minIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
//              未排序的序列中有值比已排序中的最小值还小，更新最小值的位置
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
//          一趟排序结束，选择最小的值放到已排序的第 i 的位置上
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        return arr;
    }


    /**
     * 冒泡排序算法实现
     *
     * @param arr 待排序序列
     * @return
     */
    public static int[] bubbleSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * 冒泡排序函数实现，通过判断一趟冒泡排序中，位置是否发生变化来终止
     *
     * @param arr 待排序数组
     * @return
     */
    public static int[] bubbleSortV2(int[] arr) {

//      判断一趟冒泡排序过程中，是否发生交换，如果没有发生交换，则代表序列已经有序。
//      flag = 1：发生交换，flag = 0：无交换
        int flag = 1;

        for (int i = 0; i < arr.length && flag == 1; i--) {
            flag = 0;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = 1;
                }
            }
        }
        return arr;
    }

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


    /**
     * 基数排序算法实现
     *
     * @param arr 待排序序列
     * @return
     */
    public static int[] radioSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }

        int n = arr.length;
        int max = arr[0];
        // 找出最大值
        for (int i = 1; i < n; i++) {
            max = Math.max(max, arr[i]);
        }
        // 计算最大值是几位数
        int num = 1;
        while (max / 10 > 0) {
            num++;
            max = max / 10;
        }
        // 创建10个桶
        ArrayList<LinkedList<Integer>> bucketList = new ArrayList<>(10);
        // 初始化桶
        for (int i = 0; i < 10; i++) {
            bucketList.add(new LinkedList<Integer>());
        }
        // 进行每一趟的排序，从个位数开始排
        for (int i = 1; i <= num; i++) {
            for (int j = 0; j < n; j++) {
                // 获取每个数最后第 i 位是数组
                int radio = (arr[j] / (int) Math.pow(10, i - 1)) % 10;
                //放进对应的桶里
                bucketList.get(radio).add(arr[j]);
            }
            //合并放回原数组
            int k = 0;
            for (int j = 0; j < 10; j++) {
                for (Integer t : bucketList.get(j)) {
                    arr[k++] = t;
                }
                //取出来合并了之后把桶清光数据
                bucketList.get(j).clear();
            }
        }
        return arr;
    }


    public static void main(String[] args) {


        int[] arr = {3, 4, 2, 3, 17, 5, 26, 4, 59, 8};


//        radioSort(arr);
//        QuickSort(arr, 0, arr.length);

//      jdk源码自带的排序方法
        Integer[] arr1 = {3, 4, 2, 3, 17, 5, 26, 4, 59, 8};
        Arrays.sort(arr1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        List<Integer> list = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            int temp = (int) (1 + Math.random() * 30);
            list.add(temp);
        }
        Collections.sort(list, Collections.reverseOrder());


        Integer[] arr2 = {17, 21, 35, 23, 22, 34, 67, 64, 65, 41, 43, 4, 55, 42, 48, 28, 47, 1, 25, 70, 6, 63, 24, 62, 5, 60, 10, 11,
                36, 82, 12, 15, 16, 13, 14, 52, 57, 50, 61, 33, 44, 45, 18, 19, 20, 40, 8, 71, 72, 73, 74, 80, 9, 69, 7, 77,
                75, 76, 68, 81, 54, 26, 56, 27, 53, 32, 49, 58, 59, 30, 37, 51, 2, 79, 3, 29, 31, 38, 78, 46, 39, 66};
        Arrays.sort(arr2);
    }
}

package indi.pentiumcm.leetcode;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q6
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/3/20 9:32
 * @describe: 面试题40. 最小的k个数
 */
public class Q6 {


    private int getKMin(int[] a, int k) {
        if (a == null || a.length < k) {
            return Integer.MIN_VALUE;
        }
        return quikSort(a, 0, a.length - 1, k);
    }

    private int quikSort(int[] a, int low, int high, int k) {
//		第0个元素作为枢纽
        int i = low;
        int j = high;
        int tmp = a[i];
        if (low > high) {
            return Integer.MIN_VALUE;
        }
//		快速排序
        while (i < j) {
            while (i < j && a[j] >= tmp) {
                j--;
            }
            if (i < j) {
                a[i++] = a[j];
            }
            while (i < j && a[i] < tmp) {
                i++;
            }
            if (i < j) {
                a[j--] = a[i];
            }
        }
        a[i] = tmp;
//		判断i+1与k的大小
        if (i + 1 == k) {
            return tmp;
        } else if (i + 1 > k) {
            return quikSort(a, low, i - 1, k);
        } else {
            return quikSort(a, i + 1, high, k);
        }
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        getKMin(arr, k);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }
}

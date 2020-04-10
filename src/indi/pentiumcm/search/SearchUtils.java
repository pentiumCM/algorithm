package indi.pentiumcm.search;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.search
 * @className: SearchUtils
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2020/3/15 8:46
 * @describe: 查找算法的工具类
 */
public class SearchUtils {


    /**
     * 顺序查找的算法实现
     *
     * @param arr   查找的序列
     * @param value 查找某个值
     * @return 如果查到，返回这个值得位置下标
     */
    public static int sequenceSearch(int arr[], int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }


    /**
     * @param arr   待查找序列
     * @param value 查找元素
     * @return
     */
    public static int sequenceSearchV2(int[] arr, int value) {
//      从后往前遍历数组
        int i = arr.length - 1;
//      将a[0]设置成哨兵，避免每次比较元素后都需要判断下标是否越界这一问题
        arr[0] = value;

//      若数组中无key，则一定会得到a[0]=key
        while (arr[i] != value) {
            i--;
        }
        //查找失败返回0
        return i;
    }


    /**
     * 二分查找算法 - 非递归实现
     *
     * @param arr   查找的序列
     * @param value 查找某个值
     * @return 如果查到，返回这个值得位置下标
     */
    public static int binarySearch(int[] arr, int value) {
//      定义好首尾指针
        int low = 0, hign = arr.length - 1;
        while (low <= hign) {
            int mid = (low + hign) / 2;
            if (value == arr[mid]) {
                return mid;
            }
            if (value < arr[mid]) {
                hign = mid - 1;
            }
            if (value > arr[mid]) {
                low = mid + 1;
            }
        }
        return -1;
    }


    /**
     * 二分查找算法 - 递归实现
     *
     * @param arr   查找的序列
     * @param value 查找某个值
     * @param low
     * @param hign
     * @return
     */
    public static int binarySearchV2(int[] arr, int value, int low, int hign) {

//      递归的终止条件1：未查询到某个值
        if (low > hign) {
            return -1;
        }

        int mid = (low + hign) / 2;

        if (value < arr[mid]) {
            return binarySearchV2(arr, value, low, mid - 1);
        } else if (value > arr[mid]) {
            return binarySearchV2(arr, value, mid + 1, hign);
        } else {
//          递归的终止条件2：查询到
            return mid;
        }
    }


    /**
     * 插值查找算法实现 - 将二分查找中的比例参数1/2改进为自适应的
     *
     * @param arr   待查找序列
     * @param value 查找元素
     * @param low
     * @param high
     * @return
     */
    public static int insertSearch(int[] arr, int value, int low, int high) {
        if (low > high) {
            return -1;

        }
        int mid = low + (value - arr[low]) / (arr[high] - arr[low]) * (high - low);

        if (value < arr[mid]) {
            return insertSearch(arr, value, low, mid - 1);
        } else if (value > arr[mid]) {
            return insertSearch(arr, value, mid + 1, high);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] a = {50, 6, 3, 7, 5, 4, 2};

        int[] bin = {1, 3, 4, 5, 8, 12, 15};
//        int index = sequenceSearchV2(a, 50);
        int index = insertSearch(bin, 7, 0, bin.length - 1);
    }
}

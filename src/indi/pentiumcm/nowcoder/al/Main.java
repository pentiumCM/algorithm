package indi.pentiumcm.nowcoder.al;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.nowcoder
 * @className: Main
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/3/7 23:03
 * @describe:
 */
public class Main {
    public int count = 0;

    /**
     * 将1，2，3放入N*3，上下左右不相同,N由控制台输入
     *
     * @param N N==1，12  N==2，54
     * @return
     */
    public int solutions(int N) {
        LinkedList<LinkedList> res = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        int[] nums = new int[]{1, 2, 3};
        tract(res, path, N, nums);
        return count;
    }

    /**
     * @param res  存储每一种N*3的结果
     * @param path 每一行
     * @param N    N*3
     * @param nums {1，2，3}
     */
    public void tract(LinkedList<LinkedList> res, LinkedList<Integer> path, int N, int[] nums) {
        if (res.size() == N) {
            // 已经有一种了
            count++;
            return;
        }
        if (path.size() == 3) {
            res.add(new LinkedList(path));
            return;
        }
        //如果是第一列
        if (path.size() == 0) {
            for (int j = 0; j < 3; j++) {
                path.add(nums[j]);
                tract(res, path, N, nums);
                path.removeLast();
            }
        } else {
            //如果没有完成一行就继续找
            for (int j = 0; j < nums.length; j++) {
                if (path.get(path.size() - 1) != nums[j]) {
                    path.add(nums[j]);
                    tract(res, path, N, nums);
                    path.removeLast();
                }
            }
        }

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main main = new Main();
        //代表T组测试用例
        int T = sc.nextInt();
        while (T > 0) {
            Scanner scc = new Scanner(System.in);
            int N = scc.nextInt();
            T--;
            System.out.println(main.solutions(N));
        }
    }

}

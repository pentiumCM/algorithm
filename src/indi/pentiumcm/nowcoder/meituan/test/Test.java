package indi.pentiumcm.nowcoder.meituan.test;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.nowcoder.meituan.indi.pentiumcm.subject.linkedlist.test
 * @className: Test
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/3/20 16:59
 * @describe:
 */
public class Test {


    public static int func(int[] A, int[] B, int m) {

        if (A.length != B.length) {
            return 0;

        }
        TreeSet<Integer> setA = new TreeSet<>();
        TreeSet<Integer> setB = new TreeSet<>();

        for (int i : A) {
            setA.add(i);
        }
        for (int i : B) {
            setB.add(i);
        }

        for (int i = 1; i <= m; i++) {
            TreeSet<Integer> setTmp = new TreeSet<>();
            for (int a : setA) {
                setTmp.add((a + i) % m);
            }
            if (isSame(setB, setTmp)) {
                return i;
            }
        }
        return 0;
    }

    public static boolean isSame(TreeSet<Integer> A, TreeSet<Integer> B) {

        if (A.size() != B.size()) {
            return false;
        }

        for (int i : A) {
            if (B.contains(i)) {
                B.remove(i);
            }
        }
        if (B.size() == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[] A = new int[n];
        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            B[i] = in.nextInt();
        }

        int query = func(A, B, m);

        System.out.println(query);
    }

}

package indi.pentiumcm.nowcoder.meituan.test;

import java.util.Scanner;
import java.util.Stack;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.nowcoder.meituan.indi.pentiumcm.subject.linkedlist.test
 * @className: Main1
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/3/20 15:56
 * @describe:
 */
public class Main1 {

    public static int query(String s, String a) {
        int ans = 0;

        int len = a.length();
        Stack<Character> aStack = new Stack<>();
        for (int i = len - 1; i >= 0; i--) {
            aStack.push(a.charAt(i));
        }

        int srcLen = s.length();
        while (aStack.size() > 0) {
            for (int i = 0; i < srcLen; i++) {
                int stackLen = aStack.size();
                if (stackLen == 0) {
                    break;
                }

                char src = s.charAt(i);
                Character top = aStack.peek();
                // 匹配成功
                if (top != src) {
                    ans++;

                } else {
                    aStack.pop();
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.next();
        String a = in.next();


        int count = query(s, a);

        System.out.println(count);
    }
}

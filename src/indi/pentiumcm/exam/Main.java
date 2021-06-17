package indi.pentiumcm.exam;

import java.util.Scanner;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int winner(int[] s, int[] t) {
        int start = 0, stop = 0;
        int len = 0;

        List<Integer> tList = new ArrayList<>(t.length);
        for (int i = 0; i < t.length; i++) {
            tList.add(t[i]);
        }

        List<List> res = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            if (tList.contains((Object) i)) {
                List<Integer> temp = new ArrayList<>(2);
                temp.add(i);
                for (int j = i; j < s.length; j++) {
                    if (!temp.contains((Object) j) && tList.contains((Object) j)) {
                        temp.add(j);
                    }
                    if (temp.size() == t.length) {
                        List<Integer> path = new ArrayList<>(2);
                        temp.stream().forEach(integer -> path.add(integer));
                        res.add(path);
                    }
                }
            }
        }

        System.out.println();

        return 0;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] values = line.split(",");
        int[] s = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            s[i] = Integer.parseInt(values[i]);
        }

        line = scanner.nextLine();
        values = line.split(",");
        int[] t = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            t[i] = Integer.parseInt(values[i]);
        }

        res = winner(s, t);
        System.out.println(String.valueOf(res));

    }
}

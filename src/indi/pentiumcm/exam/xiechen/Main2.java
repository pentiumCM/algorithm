package indi.pentiumcm.exam.xiechen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.exam.xiechen
 * @className: Main2
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/3/18 19:36
 * @describe:
 */
public class Main2 {


    public static String queryFun(List<String> input) {

        int len = input.size();
        if (len == 0) {
            return null;
        }
        List<String> ds = new ArrayList<>();
        String src = null;

        for (String item : input) {
            String[] itemSrc = item.split(":");
            if (itemSrc[0].startsWith("dict")) {
                ds.add(itemSrc[1] + "," + itemSrc[2]);
            } else if (itemSrc[0].startsWith("query")) {
                src = itemSrc[1];
            }
        }

        List<String> res = new ArrayList<>();
        for (String item : ds) {
            String[] itemArr = item.split(",");


        }


        return null;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        // 输入样例
        List<String> input = new ArrayList<>();
        while (in.hasNextLine()) {
            String line = in.nextLine();
            input.add(line);
            if (line.startsWith("query")) {
                break;
            }
        }

        String query = queryFun(input);

        System.out.println(query);
    }

}

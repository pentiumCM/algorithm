package indi.pentiumcm.exam.xiechen;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.exam.xiechen
 * @className: Main1
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/3/18 19:05
 * @describe:
 */
public class Main1 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int calcSimilarity(String name1, String name2) {
        int count = 0;

        String[] src1 = name1.split(" ");
        String[] src2 = name2.split(" ");
        int len1 = src1.length;
        int len2 = src2.length;
        int len = Math.min(len1, len2);

        // 相同位数比较
        for (int i = 0; i < len; i++) {
            String item1 = src1[i];
            String item2 = src2[i];

            int itemLen1 = item1.length();
            int itemLen2 = item2.length();
            int itemLen = Math.min(itemLen1, itemLen2);

            for (int j = 0; j < itemLen; j++) {
                char c1 = item1.charAt(j);
                char c2 = item2.charAt(j);
                if (c1 != c2) {
                    count = count + c1 + c2;
                }
            }
            if (itemLen1 > itemLen2) {
                for (int j = itemLen; j < itemLen1; j++) {
                    char c = item1.charAt(j);
                    count += c;
                }
            } else {
                for (int j = itemLen; j < itemLen2; j++) {
                    char c = item2.charAt(j);
                    count += c;
                }
            }
        }

        // 不同位数比较
        if (len1 > len2) {
            for (int j = len; j < len1; j++) {
                String item = src1[j];
                for (int i = 0; i < item.length(); i++) {
                    char c = item.charAt(i);
                    count += c;
                }
            }
        } else if (len1 < len2) {
            for (int j = len; j < len2; j++) {
                String item = src2[j];
                for (int i = 0; i < item.length(); i++) {
                    char c = item.charAt(i);
                    count += c;
                }
            }
        }

        return count;
    }

    /******************************结束写代码******************************/

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextLine()) {
//            String name1 = in.nextLine();
//            String name2 = in.nextLine();
//
//            int sum = calcSimilarity(name1, name2);
//            System.out.println(sum);
//        }

        String name1 = "a b";
        String name2 = "     ";
        int sum = calcSimilarity(name1, name2);

        System.out.println(sum);

    }
}

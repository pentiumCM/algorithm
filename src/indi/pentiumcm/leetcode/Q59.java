package indi.pentiumcm.leetcode;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.leetcode
 * @className: Q59
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/5/11 10:40
 * @describe: 1108. IP 地址无效化
 */
public class Q59 {

    public static String defangIPaddr(String address) {
        String newAddress = address.replace(".", "[.]");

        return newAddress;
    }


    public static void main(String[] args) {

        String address = "1.1.1.1";
        String s = defangIPaddr(address);

        System.out.println(s);
    }
}

package indi.pentiumcm.exam.xiechen;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.exam.xiechen
 * @className: Test
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/3/18 15:38
 * @describe:
 */
public class Test {

    public static void main(String args[]) {

        Thread t = new Thread() {
            @Override
            public void run() {
                pong();
            }
        };
        t.run();
        System.out.print("ping");
    }

    static void pong() {
        System.out.print("pong");
    }
}

package indi.pentiumcm.exam.xiechen;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm.exam.xiechen
 * @className: B
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/3/18 15:42
 * @describe:
 */
public class B extends A {
    public int a = 1;

    @Override
    public void fun() {
        System.out.println("B");
    }

    public static void main(String[] args) {

        // 编译看左边，运行看右边
        A classA = new B();
        System.out.println(classA.a);
        classA.fun();
    }
}

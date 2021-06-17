package indi.pentiumcm.nowcoder.al;

import java.util.*;

/**
 * @projName: algorithm
 * @packgeName: indi.pentiumcm
 * @className: Dy
 * @author： pentiumCM
 * @email： 842679178@qq.com
 * @date: 2021/3/14 9:41
 * @describe: 用户订阅商品类
 */
public class Dy {


    /**
     * N 个商品，包含订阅数，用户id，等信息
     * 泛型：Map
     * key:商品id
     * value: 第一个元素为订阅数，后面为用户id列表
     */
    private Map<Long, List<Long>> goodInfo;


    public void setGoodInfo(Map<Long, List<Long>> goodInfo) {
        this.goodInfo = goodInfo;
    }

    public Map<Long, List<Long>> getGoodInfo() {
        return goodInfo;
    }


    /**
     * 为指定的用户id订阅指定的商品id
     *
     * @param userId
     * @param goodsId
     */
    public void userGoodAdd(Long userId, Long goodsId) {
        Map<Long, List<Long>> goodInfo = getGoodInfo();

        // 根据 指定的商品id 获取商品信息
        List<Long> goodInfoList = goodInfo.get(goodsId);

        // 判断用户是否订阅过该商品，未订阅的话，可以订阅
        if (!goodInfoList.contains(userId)) {
            if (goodInfoList.size() > 0) {
                // 获取订阅数
                Long num = goodInfoList.get(0);
                Long numAdd = num + 1;
                goodInfoList.set(0, numAdd);

                // 添加用户订阅信息
                goodInfoList.add(userId);
            } else {
                Long num = Long.valueOf(1);
                goodInfoList.add(num);
                goodInfoList.add(userId);
            }
        }
    }


    /**
     * 返回所有商品的订阅总数
     *
     * @return
     */
    public int allGoodsDy() {
        Map<Long, List<Long>> goodInfo = getGoodInfo();
        int allDyNum = 0;

        // 获取 Map 的所有key，及对应所有的商品
        Set<Long> keySet = goodInfo.keySet();
        for (Long item : keySet) {
            List<Long> list = goodInfo.get(item);
            if (list.size() > 0) {
                Long aLong = list.get(0);
                allDyNum += aLong;
            }
        }
        return allDyNum;
    }


    /**
     * 根据商品ID返回这个商品的订阅数
     *
     * @param goodsId
     * @return
     */
    public int goodsDyNum(Long goodsId) {
        Map<Long, List<Long>> goodInfo = getGoodInfo();
        long dyNum = 0;

        // 获取 Map 的所有key，及对应所有的商品
        Set<Long> keySet = goodInfo.keySet();
        for (Long item : keySet) {
            if (item.equals(goodsId)) {
                List<Long> goods = goodInfo.get(item);
                if (goods.size() > 0) {
                    dyNum = goods.get(0);
                }
                // 匹配上之后可提前结束
                break;
            }
        }
        return (int) dyNum;
    }


    public static void main(String[] args) {
        // 测试用例
        Dy dy = new Dy();
        Map<Long, List<Long>> items = new HashMap<>();
        List<Long> users = new ArrayList<>();
        users.add((long) 1);
        items.put((long) 1, users);
        dy.setGoodInfo(items);

        // 为指定的用户id订阅指定的商品id
        dy.userGoodAdd((long) 2, (long) 1);

        // 获取全部商品数量
        int b = dy.allGoodsDy();
        System.out.printf("" + b);

        // 获取指定商品数量
        int c = dy.goodsDyNum((long) 1);
        System.out.printf("" + c);
    }
}

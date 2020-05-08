package support;

import java.util.ArrayList;
import java.util.List;

/**
 * 购物车服务类
 */
public class CartService {

    // 加入到购物车中的商品信息
    private static List<Sku> cartSkuList = new ArrayList<Sku>() {
        {
            add(new Sku(654032, "无人机", 22.2, 2, 44.4, SkuCategoryEnum.DIGITAL));
            add(new Sku(654033, "VR眼镜", 11.1, 2, 22.2, SkuCategoryEnum.DIGITAL));
            add(new Sku(654034, "充气娃娃", 1000.0, 2, 2000.0, SkuCategoryEnum.SPORTS));
            add(new Sku(654035, "Java核心技术", 50.0, 2, 100.0, SkuCategoryEnum.BOOKS));
            add(new Sku(654036, "Python编程", 49.0, 2, 96.0, SkuCategoryEnum.BOOKS));
            add(new Sku(654037, "女装", 66.0, 1, 66.0, SkuCategoryEnum.CLOTHING));
        }
    };

    /**
     * 获取购物车中的商品信息
     *
     * @return
     */
    public static List<Sku> getCartSkuList() {
        return cartSkuList;
    }

    /**
     * 找出购物车中所有属于 电子数码 的商品
     * Version: 1.0(单一维度条件参数化)
     *
     * @param cartSkuList
     * @return
     */
    public static List<Sku> filterElectronicsSku(List<Sku> cartSkuList) {
        List<Sku> result = new ArrayList<>();
        for (Sku sku : cartSkuList
        ) {
            if (SkuCategoryEnum.DIGITAL.equals(sku.getSkuCategory())) {
                result.add(sku);
            }
        }
        return result;
    }

    /**
     * 根据商品类型查找商品
     * Version:2.0(单一维度条件参数化)
     *
     * @param cartSkuList
     * @param skuCategoryEnum
     * @return
     */
    public static List<Sku> filterSkuByCategory(List<Sku> cartSkuList, SkuCategoryEnum skuCategoryEnum) {
        List<Sku> result = new ArrayList<>();
        for (Sku sku : cartSkuList
        ) {
            if (skuCategoryEnum.equals(sku.getSkuCategory())) {
                result.add(sku);
            }
        }
        return result;
    }

    /**
     * 通过商品类型或总价过滤商品
     * Version: 3.0
     *
     * @param cartSkuList
     * @param categoryEnum
     * @param totalPrice
     * @param categoryOrPrice
     * @return
     */
    public static List<Sku> filterSku(
            List<Sku> cartSkuList,
            SkuCategoryEnum categoryEnum,
            Double totalPrice,
            Boolean categoryOrPrice
    ) {
        List<Sku> result = new ArrayList<Sku>();
        for (Sku s : cartSkuList
        ) {
            if (
                    (categoryOrPrice && categoryEnum.equals(s.getSkuCategory()))
                            || (!categoryOrPrice && s.getTotalPrice() > totalPrice)
            ) {
                result.add(s);
            }
        }
        return result;
    }

    /**
     * Version: 4.0
     * 根据不同的商品判断标准
     *
     * @param cartSkuList  商品列表
     * @param skuPredicate 不同的商品属性判断标准
     * @return
     */
    public static List<Sku> filterSku(List<Sku> cartSkuList, SkuPredicate skuPredicate) {
        List<Sku> result = new ArrayList<Sku>();
        for (Sku s : cartSkuList
        ) {
            if (skuPredicate.test(s)) {
                result.add(s);
            }
        }
        return result;
    }


}

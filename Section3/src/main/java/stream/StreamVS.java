package stream;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import support.CartService;
import support.Sku;
import support.SkuCategoryEnum;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * 对比原始集合操作和Stream集合操作
 */
public class StreamVS {
    /**
     * 需求:
     * 1: 看看购物车中的所有商品
     * 2: 图书类的商品都有哪些
     * 3: 不是图书类的商品中挑选出来两件最贵的
     * 4: 最贵的两件商品的名称和总价
     */

    /**
     * 原始集合操作完成需求
     */
    @Test
    public void oldCartHandle() {
        List<Sku> cartSkuList = CartService.getCartSkuList();
        /**
         * 1:看看购物车中的所有商品
         */
        for (Sku s : cartSkuList
        ) {
            System.out.println(JSON.toJSONString(s, true));
        }

        /**
         * 2: 图书类的商品都有哪些
         */

        List<Sku> notBookList = new ArrayList<>();
        for (Sku s : cartSkuList
        ) {
            if (!SkuCategoryEnum.BOOKS.equals(s.getSkuCategory())) {
                notBookList.add(s);
            }
        }
        for (Sku s : notBookList
        ) {
            System.out.println("不是图书类的商品:" + s.getSkuName());
        }


        /**
         * 3:不是图书类的商品中挑选出来两件最贵的
         */
        notBookList.sort(new Comparator<Sku>() {
            @Override
            public int compare(Sku o1, Sku o2) {
                if (o1.getTotalPrice() > o2.getTotalPrice()) {
                    return -1;
                } else if (o1.getTotalPrice() < o2.getTotalPrice()) {
                    return 1;
                }
                return 0;
            }
        });

        List<Sku> top2SkuList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            top2SkuList.add(notBookList.get(i));
        }

        /**
         * 最贵的两件商品的总价和名称
         */
        Double resultMoney = 0.0;
        for (Sku sku : top2SkuList
        ) {
            resultMoney += sku.getTotalPrice();
        }
        // 两件商品的名称
        List<String> top2Name = new ArrayList<>();
        for (Sku sku : top2SkuList
        ) {
            top2Name.add(sku.getSkuName());
        }
        // 输出结果
        System.out.println(JSON.toJSONString(top2Name, true));
        System.out.println(resultMoney);

    }

    /**
     * Stream操作完成需求
     */
    @Test
    public void newCartHandle() {
        AtomicReference<Double> money = new AtomicReference<>(Double.valueOf(0.0));

        List<String> collect = CartService.getCartSkuList()
                // 1:打印商品信息
                .stream()
                .peek(
                        sku -> System.out.println(JSON.toJSONString(sku, true)
                        ))
                // 过滤掉所有图书类商品
                .filter(sku -> !SkuCategoryEnum.BOOKS.equals(sku.getSkuCategory()))
                // 排序
                .sorted(Comparator.comparing(Sku::getTotalNum).reversed())
                // 过滤
                .limit(2)
                // 计算
                .peek(sku -> money.set(sku.getTotalPrice() + money.get()))
                // 收集商品名称
                .map(sku -> sku.getSkuName())
                .collect(Collectors.toList());
        System.out.println("商品总价:" + money);
        System.out.println(JSON.toJSONString(collect, true));
    }
}

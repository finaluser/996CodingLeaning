package stream;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import support.CartService;
import support.Sku;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamCollector {
    /**
     * 集合收集器
     */
    @Test
    public void toList() {
        List<Sku> list = CartService.getCartSkuList();
        List<Sku> collect = list.stream()
                .filter(sku -> sku.getTotalPrice() > 100)
                .collect(Collectors.toList());
        System.out.println(JSON.toJSONString(collect, true));
    }

    /**
     * 分组
     */
    @Test
    public void group() {
        List<Sku> list = CartService.getCartSkuList();
        Map<Enum, List<Sku>> collect = list.stream()
                .collect(Collectors.groupingBy(Sku::getSkuCategory));
        System.out.println(JSON.toJSONString(collect, true));
    }

    /**
     * 分区
     */
    @Test
    public void partition() {
        List<Sku> list = CartService.getCartSkuList();
        Map<Boolean, List<Sku>> collect = list.stream()
                .collect(Collectors.partitioningBy(sku -> sku.getTotalPrice() > 100));
        System.out.println(JSON.toJSONString(collect, true));

    }
}

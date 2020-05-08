package lambda.cart;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

import java.util.List;

public class VersionTest {
    @Test
    public void filterElectronicsSku() {
        List<Sku> cartSkuList = CartService.getCartSkuList();
        List<Sku> skus = CartService.filterElectronicsSku(cartSkuList);
        System.out.println(JSON.toJSONString(skus, true));
    }

    @Test
    public void filterSkuByCategory() {
        List<Sku> cartSkuList = CartService.getCartSkuList();
        List<Sku> skus = CartService.filterSkuByCategory(cartSkuList, SkuCategoryEnum.BOOKS);
        System.out.println(JSON.toJSONString(skus, true));
    }

    @Test
    public void filterSku() {
        List<Sku> cartSkuList = CartService.getCartSkuList();
        List<Sku> skus = CartService.filterSku(cartSkuList, SkuCategoryEnum.DIGITAL, 22.2, false);
        System.out.println(JSON.toJSONString(skus, true));
    }

    /**
     * 将判断逻辑参数化之实体类
     */
    @Test
    public void filterSku2() {
        List<Sku> cartSkuList = CartService.getCartSkuList();
        List<Sku> skus = CartService.filterSku(cartSkuList, new SkuBooksCategoryPredicate());
        System.out.println(JSON.toJSONString(skus, true));

    }

    /**
     * 将判断逻辑参数化之 匿名类
     */
    @Test
    public void filterSku3() {
        List<Sku> cartSkuList = CartService.getCartSkuList();
        List<Sku> skus = CartService.filterSku(cartSkuList, new SkuPredicate() {
            @Override
            public boolean test(Sku sku) {
                return sku.getSkuPrice() >= 1000;
            }
        });
        System.out.println(JSON.toJSONString(skus, true));

    }

    /**
     * 将判断逻辑参数化之 Lambda
     */
    @Test
    public void filterSku4() {
        List<Sku> cartSkuList = CartService.getCartSkuList();
        List<Sku> skus = CartService.filterSku(cartSkuList, (Sku sku) -> sku.getSkuPrice() >= 1000);
        System.out.println(JSON.toJSONString(skus, true));

    }
}

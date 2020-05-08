package stream;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import support.CartService;
import support.Sku;
import support.SkuCategoryEnum;

import java.util.*;

/**
 * 流的各种操作
 */
public class StreamOperator {

    List<Sku> list;

    @BeforeEach
    public void init() {
        list = CartService.getCartSkuList();
    }

    /**
     * 流过滤:过滤掉不符合断言判断的数据
     */
    @Test
    public void filterTest() {
        list.stream()
                .filter(sku ->
                        SkuCategoryEnum.BOOKS.equals(sku.getSkuCategory()
                        )
                )
                .forEach(item ->
                        System.out.println(JSON.toJSONString(item, true))
                );
    }

    /**
     * Map:将一个元素,转换成另一个元素
     */
    @Test
    public void mapTest() {
        list.stream()
                .map(sku -> sku.getSkuName())
                .forEach(item ->
                        System.out.println(JSON.toJSONString(item, true)));
    }

    /**
     * flatMap:将一个对象转换成流
     */
    @Test
    public void flatMapTest() {
        list.stream()
                .flatMap(sku -> Arrays.stream(sku.getSkuName().split("")))
                .forEach(item ->
                        System.out.println(JSON.toJSONString(item, true)));
    }

    /**
     * peek: 对流进行遍历操作,peek是中间操作,不会将流进行销毁,foreach是终端操作
     */
    @Test
    public void peekTest() {
        list.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .forEach(item ->
                        System.out.println(JSON.toJSONString(item, true)));
    }

    /**
     * sorted: 对流中的元素进行排序,可选择自然排序或指定排序规则(有状态操作)
     */
    @Test
    public void sortedTest() {
        list.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .sorted(Comparator.comparing(Sku::getTotalPrice))
                .forEach(item ->
                        System.out.println(JSON.toJSONString(item, true)));
    }

    /**
     * distinct:对流元素进行去重(有状态操作)
     */
    @Test
    public void distinctTest() {
        list.stream()
                .map(Sku::getSkuCategory)
                .distinct()
                .forEach(item ->
                        System.out.println(JSON.toJSONString(item, true)));
    }

    /**
     * skip:跳过前几个元素(有状态操作)
     */
    @Test
    public void skipTest() {
        list.stream()
                .sorted(Comparator.comparing(Sku::getTotalPrice))
                .skip(3)
                .forEach(item ->
                        System.out.println(JSON.toJSONString(item, true)));
    }

    /**
     * limit:截断前几条数据(有状态操作)
     */
    @Test
    public void limitTest() {
        list.stream()
                .sorted(Comparator.comparing(sku -> sku.getTotalPrice()))
                .limit(2)
                .forEach(item ->
                        System.out.println(JSON.toJSONString(item, true)));
    }

    // ----------------------------------流的终端操作----------------------------------

    /**
     * allMatch:终端操作,短路操作,所有元素匹配返回
     */
    @Test
    public void allMatchTest() {
        boolean b = list.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .allMatch(sku -> sku.getTotalPrice() > 1000);
        System.out.println(b);
    }

    /**
     * anyMatch:任何元素匹配
     */
    @Test
    public void anyMatchTest() {
        boolean b = list.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .anyMatch(sku -> sku.getTotalPrice() > 1000);
        System.out.println(b);
    }

    /**
     * anyMatch:任何元素都不匹配
     */
    @Test
    public void noneMatchTest() {
        boolean b = list.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .noneMatch(sku -> sku.getTotalPrice() > 10000);
    }

    /**
     * findFirst:找到第一个
     */
    @Test
    public void findFirstTest() {
        Optional<Sku> first = list.stream()
                .findFirst();
        System.out.println(JSON.toJSONString(first.get(), true));
    }

    /**
     * findAny:找到任何一个,只要找到就返回,和findFirst的区别在于并行操作
     */
    @Test
    public void findAnyTest() {
        Optional<Sku> any = list.stream()
                .findAny();
        System.out.println(JSON.toJSONString(any.get(), true));
    }

    @Test
    public void maxTest() {
        OptionalDouble max = list.stream()
                .mapToDouble(sku -> sku.getTotalPrice())
                .max();
        System.out.println(max.getAsDouble());
    }

    @Test
    public void minTest() {
        OptionalDouble min = list.stream()
                .mapToDouble(sku -> sku.getTotalPrice())
                .min();
        System.out.println(min.getAsDouble());
    }

    /**
     * count:获取所有元素的个数并返回
     */
    @Test
    public void countTest(){
        long count = list.stream()
                .count();
        System.out.println(count);
    }

}

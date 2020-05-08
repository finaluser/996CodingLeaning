package guava;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

/**
 * Lists 和 Sets 工具类的使用
 */
public class SetsTest {
    /**
     * Sets工具类常用方法
     * 并集/交集/差集/分解集合中的所有子集,求两个集合的笛卡尔积
     * Lists工具类的常用方法
     * 反转/拆分
     */

    private static final Set set1 = Sets.newHashSet(1, 2, 3);
    private static final Set set2 = Sets.newHashSet(4, 5, 6);

    //并集
    @Test
    public void union() {
        Set<Integer> setNew = Sets.union(set1, set2);
        System.out.println(setNew);
    }

    //交集
    @Test
    public void intersection() {
        Set<Integer> sets = Sets.intersection(set1, set2);
        System.out.println(sets);
    }

    //差集
    @Test
    public void difference() {
        Set<Integer> sets = Sets.difference(set1, set2);
        System.out.println(sets);
        //相对差集:属于A且不属于B或者属于B且不属于A的元素
        sets = Sets.symmetricDifference(set1, set2);
        System.out.println(sets);
    }

    @Test
    public void powerSet() {
        Set<Set<Integer>> powerSet = Sets.powerSet(set1);
        System.out.println(JSON.toJSONString(powerSet));
    }

    // 计算两个集合的笛卡尔积
    @Test
    public void cartesianProduct() {
        Set<List<Integer>> product = Sets.cartesianProduct(set1, set2);
        System.out.println(product);
    }

    // 拆分
    @Test
    public void partition() {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7);
        List<List<Integer>> partition = Lists.partition(list, 3);
        System.out.println(JSON.toJSONString(partition, true));
    }

    @Test
    public void reverse(){
        List<Integer> list = Lists.newLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        List<Integer> reverse = Lists.reverse(list);
        System.out.println(reverse);
    }
}

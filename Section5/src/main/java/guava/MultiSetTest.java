package guava;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.primitives.Chars;
import org.junit.jupiter.api.Test;

/**
 * 使用MultiSet集合类,统计一篇文章中文字出现次数
 */
public class MultiSetTest {
    private static final String text = "永之氓咸善游。一日，水暴甚，有五、六氓乘小船绝湘水。中济，船破，皆游。其一氓尽力而不能寻常。其侣曰：“汝善游最也，今何后为？”曰：“吾腰千钱，重，是以后。”曰：“何不去之？”不应，摇其首。有顷，益怠。已济者立岸上呼且号曰：“汝愚之甚，蔽之甚，身且死，何以货为？”又摇其首。遂溺死。吾哀之。且若是，得不有大货之溺大氓者乎？于是作《哀溺》";


    @Test
    public void handle() {
        Multiset<Character> multiset = HashMultiset.create();
        // String转换成数组
        char[] chars = text.toCharArray();
        Chars.asList(chars).stream()
                .forEach(item -> {
                    multiset.add(item);
                });

        System.out.println("容量" + multiset.size());
        System.out.println("统计一字,出现的次数" + multiset.count('一'));
    }
}

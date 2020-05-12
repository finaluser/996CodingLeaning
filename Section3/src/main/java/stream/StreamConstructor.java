package stream;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import org.junit.jupiter.api.Test;
import support.Sku;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 流的四种构建形式
 */
public class StreamConstructor {

    /**
     * 由数值直接构建流
     */
    @Test
    public void streamFromValue() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4);
        integerStream.forEach(System.out::println);
    }

    /**
     * 由数组构建流
     */
    @Test
    public void streamFromArray() {
        int[] values = {1, 2, 3, 4};
        IntStream stream = Arrays.stream(values);
        stream.forEach(System.out::println);
    }

    /**
     * 通过文件生成流
     *
     * @throws IOException
     */
    @Test
    public void streamFromFile() throws IOException {
        Stream<String> lines = Files.lines(Paths.get("H:\\996Coding\\Section3\\Readme.md"));
        lines.forEach(System.out::println);
    }

    /**
     * 通过函数生成流
     */
    @Test
    public void streamFromFunction() {
//        Stream<Integer> iterate = Stream.iterate(0, n -> n + 2);
//        iterate.forEach(System.out::println);
        Stream<Double> generate = Stream.generate(Math::random);
        generate.
                limit(10)
                .forEach(System.out::println);
    }
}

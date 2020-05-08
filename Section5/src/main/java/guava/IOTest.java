package guava;

import com.google.common.base.Charsets;
import com.google.common.io.CharSink;
import com.google.common.io.CharSource;
import com.google.common.io.Files;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * 如何使用流(Source)和汇来对文件进行常用操作
 */
public class IOTest {
    @Test
    public void copyFile() {
        /**
         * 创建文件对应的流(Source)和汇(Sink),流和汇会自动进行资源释放
         */
        CharSource charSource = Files.asCharSource(new File("H:\\996Coding\\Section5\\Readme.md"), Charsets.UTF_8);
        CharSink charSink = Files.asCharSink(new File("H:\\996Coding\\Section5\\TestSource\\newReadme.md"), Charsets.UTF_8);
        /**
         * 拷贝
         */
        try {
            charSource.copyTo(charSink);
        } catch (IOException e) {
            e.getCause();
        }


    }
}

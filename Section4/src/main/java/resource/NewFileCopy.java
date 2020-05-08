package resource;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 基于JDK7之后的正确的流资源关闭方式
 * try - with - resource
 */
public class NewFileCopy {
    @Test
    public void copyFile() {
        String sourcePath = "H:\\996Coding\\Section4\\Readme.md";
        String targetPath = "H:\\996Coding\\Section4\\src\\targetTest\\newFile2.md";
        try (
                //声明流
                FileInputStream fileInputStream = new FileInputStream(sourcePath);
                FileOutputStream fileOutputStream = new FileOutputStream(targetPath);
        ) {
            //使用流
            int content;
            while ((content = fileInputStream.read()) != -1) {
                fileOutputStream.write(content);
            }
        } catch (FileNotFoundException f) {
            f.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

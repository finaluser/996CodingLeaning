package resource;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * JDK7之前的文件拷贝
 */
public class FileCopy {
    @Test
    public void copyFile() {
        //1.创建输入输出流
        //2.执行文件Copy
        //3.  **资源释放**
        //读入文件
        String sourcePath = "H:\\996Coding\\Section4\\Readme.md";
        //输出文件
        String targetPath = "H:\\996Coding\\Section4\\src\\targetTest\\newFile.md";
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream(sourcePath);
            fileOutputStream = new FileOutputStream(targetPath);

            // 需要读取的字节信息
            int content;
            // 迭代读取并写入字节
            while ((content = fileInputStream.read()) != -1) {
                fileOutputStream.write(content);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //资源关闭遵循原则:先开后闭
            if (fileOutputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

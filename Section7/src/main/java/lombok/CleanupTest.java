package lombok;

import java.io.*;

/**
 * @Cleanup
 * 资源关闭
 */
public class CleanupTest {
    private void copyFile(String in, String out) throws IOException {
        File file;
        @Cleanup FileInputStream fileInputStream = new FileInputStream(in);
        @Cleanup FileOutputStream fileOutputStream = new FileOutputStream(out);
        int r;
        while ((r = fileInputStream.read()) != -1) {
            fileOutputStream.write(r);
        }
    }
}

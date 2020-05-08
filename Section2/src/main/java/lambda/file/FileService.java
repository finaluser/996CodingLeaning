package lambda.file;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * 文件服务类
 */
public class FileService {
    /**
     * 通过URL获取本地文件内容,调用函数式接口进行处理
     *
     * @param url
     * @param fileCustomer
     */
    public void fileHandle(String url, FileCustomer fileCustomer) {

        try {
            // 创建文件读取流
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(url)));
            //定义行变量
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            // 循环读取文件内容
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line + "/n");
            }
            // 调用函数式接口将文件内容传递给Lambda表达式,实现业务逻辑
            fileCustomer.fileHandler(stringBuilder.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

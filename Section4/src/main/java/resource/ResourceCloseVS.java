package resource;

import org.junit.jupiter.api.Test;
import support.FileCustomer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ResourceCloseVS {
    /**
     * 新版的资源关闭
     *
     * @param url
     * @param fileCustomer
     */
    @Test
    public void newFileHandle(String url, FileCustomer fileCustomer) {
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileInputStream = new FileInputStream(url);
            inputStreamReader = new InputStreamReader(fileInputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            // 循环读取文件内容
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }
            //调用函数式接口方法
            fileCustomer.fileHandler(stringBuilder.toString());
        } catch (IOException e) {
            e.getMessage();
        }
    }

    /**
     * 原始的资源关闭方法
     *
     * @param url
     * @param fileCustomer
     */
    @Test
    public void oldFileHandle(String url, FileCustomer fileCustomer) {
        // 初始化声明
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        // 创建文件读取流
        try {
            fileInputStream = new FileInputStream(url);
            inputStreamReader = new InputStreamReader(fileInputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            // 循环读取文件内容
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }

            //调用函数式接口方法
            fileCustomer.fileHandler(stringBuilder.toString());

        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        } finally {
            // 资源古关闭
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    e.getMessage();
                }
            }

            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    e.getMessage();
                }
            }


        }
    }
}

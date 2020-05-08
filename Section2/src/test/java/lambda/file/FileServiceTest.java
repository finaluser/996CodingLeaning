package lambda.file;

import org.junit.jupiter.api.Test;

public class FileServiceTest {
    @Test
    public void test1() {
        FileService service = new FileService();
        // 通过Lambda 表达式打印文件内容
        service.fileHandle("H:\\996Coding\\Section2\\Readme.md", fileContent ->
                System.out.println(fileContent));
    }
}

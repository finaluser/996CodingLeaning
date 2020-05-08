package support;

/**
 * 文件处理函数式接口
 */
@FunctionalInterface
public interface FileCustomer {
    /**
     * 函数式接口抽象方法
     *
     * @param fileContent 文件内容
     */
    void fileHandler(String fileContent);
}

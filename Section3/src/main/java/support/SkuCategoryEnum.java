package support;

/**
 * 商品分类枚举
 */
public enum SkuCategoryEnum {
    CLOTHING(10, "服装"),
    DIGITAL(20, "数码产品"),
    SPORTS(30, "运动类"),
    BOOKS(40, "书籍类");

    // 商品类型的编号
    private Integer code;
    // 商品类型的名称
    private String name;

    /**
     * 构造方法
     *
     * @param code
     * @param name
     */
    SkuCategoryEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }


}

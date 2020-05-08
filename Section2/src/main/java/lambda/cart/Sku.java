package lambda.cart;

/**
 * 下单商品信息对象
 */
public class Sku {
    // 商品编号
    private Integer skuId;
    // 商品名称
    private String skuName;
    // 商品单价
    private Double skuPrice;
    // 商品个数
    private Integer totalNum;
    // 商品总价
    private Double totalPrice;
    // 商品分类
    private Enum skuCategory;


    /**
     * 有参构造
     * @param skuId
     * @param skuName
     * @param skuPrice
     * @param totalNum
     * @param totalPrice
     * @param skuCategory
     */
    public Sku(Integer skuId, String skuName, Double skuPrice, Integer totalNum, Double totalPrice, Enum skuCategory) {
        this.skuId = skuId;
        this.skuName = skuName;
        this.skuPrice = skuPrice;
        this.totalNum = totalNum;
        this.totalPrice = totalPrice;
        this.skuCategory = skuCategory;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public String getSkuName() {
        return skuName;
    }

    public Double getSkuPrice() {
        return skuPrice;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public Enum getSkuCategory() {
        return skuCategory;
    }
}

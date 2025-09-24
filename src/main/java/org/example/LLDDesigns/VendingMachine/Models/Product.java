package org.example.LLDDesigns.VendingMachine.Models;

public class Product {
    int productId;
    String productTitle;
    int productPrice;
    int productStockCount;

    public Product(int productId, String productTitle, int productPrice, int productStockCount) {
        this.productId = productId;
        this.productTitle = productTitle;
        this.productPrice = productPrice;
        this.productStockCount = productStockCount;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductStockCount() {
        return productStockCount;
    }

    public void upDateProductStockCount(int productStockCount, Operation operationType) {

        if(operationType == Operation.ADD){
            this.productStockCount += productStockCount;
            return ;
        }
        this.productStockCount -= productStockCount;
    }

    public boolean isProductAvailable() {
        return this.productStockCount > 0;
    }

}

package org.example.LLDDesigns.VendingMachine.Models;

public class ProductShelf {
    int productShelfId;
    Product product;

    public ProductShelf(int productShelfId, Product product) {
        this.productShelfId = productShelfId;
        this.product = product;
    }

    public void setProductShelfId(int productShelfId) {
        this.productShelfId = productShelfId;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getProductShelfId() {
        return productShelfId;
    }

    public Product getProduct() {
        return product;
    }

}

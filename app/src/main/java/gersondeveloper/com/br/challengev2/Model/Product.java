package gersondeveloper.com.br.challengev2.Model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by gerso on 01/10/2016.
 */

public class Product implements Serializable {
    String id;
    String type;
    String name;
    double productValue;
    String description;
    int productImage;

    public Product()
    {

    }

    public Product(String type, String name, double productValue, String description, int productImage)
    {
        this.type = type;
        this.name = name;
        this.productValue = productValue;
        this.description = description;
        this.productImage = productImage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getProductValue() {
        return productValue;
    }

    public void setProductValue(double productValue) {
        this.productValue = productValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }
}
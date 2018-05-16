package xpmxp1.tenderstar.app_objects;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.util.*;
import java.util.Date;


@Entity(tableName = "Product")
public class Product {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ProductID")
    private long id;
    @ColumnInfo(name = "Name")
    private String name;
    @ColumnInfo(name = "Description")
    private String description;
    @ColumnInfo(name = "Price")
    private double price;
    @ColumnInfo(name = "Discount")
    private double discount;
    @ColumnInfo(name = "FromDate")
    private Date fromDate;
    @ColumnInfo(name = "ToDate")
    private Date toDate;
    @ColumnInfo(name = "StoreID")
    private long storeId;
    @ColumnInfo(name = "CategoryID")
    private long categoryId;

    public Product(String name, String description, double price, double discount, Date fromDate, Date toDate, long storeId, long categoryId) {
        setName(name);
        setDescription(description);
        setPrice(price);
        setDiscount(discount);
        setFromDate(fromDate);
        setToDate(toDate);
        setStoreId(storeId);
        setCategoryId(categoryId);
    }

    public long getId() {
        return id;
    }
    public String name;
    public Category category;
    public String description;
    public float price;
    public List<Tag> tags;
    public String stores;
    public String postal;

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double standardPrice) {
        this.price = standardPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public long getStoreId() {
        return storeId;
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
    public Product(String name, Category category, String description, float price, List<Tag> tags, String stores) {
        this.name = name;
        this.category = category;
        this.description = description;
    }

    @Ignore
    public String getPriceAsString() {
        return String.format("%.2f", price) + "€";
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    //TODO:
    @Ignore
    public List<Tag> tags;
    @Ignore
    public List<Store> stores;
}


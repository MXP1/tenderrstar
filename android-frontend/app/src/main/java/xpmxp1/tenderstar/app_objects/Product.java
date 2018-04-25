package xpmxp1.tenderstar.app_objects;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.util.*;
import java.util.Date;


@Entity(tableName = "Product")
public class Product {

    public enum Category {
        FOOD, ALCOHOL, CATFOOD
    }

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ProductID")
    private long id;
    @ColumnInfo(name = "Name")
    private String name;
    @ColumnInfo(name = "StandardPrice")
    private double standardPrice;
    @ColumnInfo(name = "Discount")
    private double discount;
    @ColumnInfo(name = "FromDate")
    private Date fromDate;
    @ColumnInfo(name = "ToDate")
    private Date toDate;
    @ColumnInfo(name = "StoreID")
    private long storeId;


    public Product(String name, double standardPrice, double discount, Date fromDate, Date toDate, long storeId) {
        this.name = name;
        this.standardPrice = standardPrice;
        this.discount = discount;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.storeId = storeId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getStandardPrice() {
        return standardPrice;
    }

    public void setStandardPrice(double standardPrice) {
        this.standardPrice = standardPrice;
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

    //TODO:
    @Ignore
    public Category category;
    @Ignore
    public List<Tag> tags;
    @Ignore
    public List<Store> stores;

    @Ignore
    public Product() {};
    @Ignore
    public Product(String name, Category category) {
        this.name = name;
        this.category = category;
        this.tags = new ArrayList<>();
        this.stores = new ArrayList<>();
    }
    @Ignore
    public Product(String name, Category category, List<Tag> tags, List<Store> stores) {
        this.name = name;
        this.category = category;
        this.tags = tags;
        this.stores = stores;
    }
}


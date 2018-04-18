package xpmxp1.tenderstar.app_objects;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.util.*;
import java.util.Date;


@Entity
public class Product {

    public enum Category {
        FOOD, ALCOHOL, CATFOOD
    }


    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ProductId")
    private int id;
    @ColumnInfo(name = "Name")
    private String name;
    @ColumnInfo(name = "StdPrice")
    private double stdPrice;
    @ColumnInfo(name = "Percent")
    private double percent;
    @ColumnInfo(name = "FromDate")
    private Date fromDate;
    @ColumnInfo(name = "ToDate")
    private Date toDate;
    @ColumnInfo(name = "StoreId")
    private int storeId;


    public Product(String name, double stdPrice, double percent, Date fromDate, Date toDate, int storeId) {
        this.name = name;
        this.stdPrice = stdPrice;
        this.percent = percent;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.storeId = storeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getStdPrice() {
        return stdPrice;
    }

    public void setStdPrice(double stdPrice) {
        this.stdPrice = stdPrice;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
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

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
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


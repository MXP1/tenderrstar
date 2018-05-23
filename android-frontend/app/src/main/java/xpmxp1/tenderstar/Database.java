package xpmxp1.tenderstar;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import xpmxp1.tenderstar.app_objects.Customer;
import xpmxp1.tenderstar.app_objects.Favorit;
import xpmxp1.tenderstar.app_objects.OpeningHours;
import xpmxp1.tenderstar.app_objects.Product;
import xpmxp1.tenderstar.app_objects.ProductCategory;
import xpmxp1.tenderstar.app_objects.ProductRating;
import xpmxp1.tenderstar.app_objects.SavedOffer;
import xpmxp1.tenderstar.app_objects.Store;
import xpmxp1.tenderstar.app_objects.StoreRating;
import xpmxp1.tenderstar.app_objects.StoreType;
import xpmxp1.tenderstar.app_objects.Tag;
import xpmxp1.tenderstar.database.TenderstarDB;

/**
 * Created by dominik on 18.04.18.
 */

public class Database {
    // Singleton
    static private Database instance = null;
    private static TenderstarDB db = CustomApplication.getDb();

    static public Database getInstance() {
        if (instance == null)
        {
            instance = new Database();
        }
        return instance;
    }

    // Constructor
    private Database() {

    }

    public static void nukeTables(){
        db.customerDAO().nukeTable();
        db.favoritDAO().nukeTable();
        db.productCategoryDAO().nukeTable();
        db.productDAO().nukeTable();
        db.productRatingDAO().nukeTable();
        db.savedOfferDAO().nukeTable();
        db.storeDAO().nukeTable();
        db.storeRatingDAO().nukeTable();
        db.storeTypeDAO().nukeTable();
        db.tagDAO().nukeTable();
    }

    public static void fillDbWithTestData(){

        Customer c1 = new Customer("Admin", "Admin", "admin@asdf.com");
        Customer c2 = new Customer("Max", "Muster", "max@asdf.com");
        Customer c3 = new Customer("Susi", "Muster", "susi@asdf.com");

        long i = db.customerDAO().insertCustomer(c1);
        c1.setId(i);
        i = db.customerDAO().insertCustomer(c2);
        c2.setId(i);
        i = db.customerDAO().insertCustomer(c3);
        c3.setId(i);

        StoreType st1 = new StoreType("Grocery");
        StoreType st2 = new StoreType("Electronic");
        StoreType st3 = new StoreType("Drugstore");
        StoreType st4 = new StoreType("Furniture");

        i = db.storeTypeDAO().insertStoreType(st1);
        st1.setId(i);
        i = db.storeTypeDAO().insertStoreType(st2);
        st2.setId(i);
        i = db.storeTypeDAO().insertStoreType(st3);
        st3.setId(i);
        i = db.storeTypeDAO().insertStoreType(st4);
        st4.setId(i);

        ProductCategory pc1 = new ProductCategory("Food");
        ProductCategory pc2 = new ProductCategory("Beverages");
        ProductCategory pc3 = new ProductCategory("TV");
        ProductCategory pc4 = new ProductCategory("Computer");
        ProductCategory pc5 = new ProductCategory("Movie");
        ProductCategory pc6 = new ProductCategory("Games");
        ProductCategory pc7 = new ProductCategory("Perfume");
        ProductCategory pc8 = new ProductCategory("Medical Care");
        ProductCategory pc9 = new ProductCategory("Makeup");
        ProductCategory pc10 = new ProductCategory("Chair");
        ProductCategory pc11 = new ProductCategory("Table");
        ProductCategory pc12 = new ProductCategory("Wardrobe");
        ProductCategory pc13 = new ProductCategory("Bed");

        i = db.productCategoryDAO().insertCategory(pc1);
        pc1.setId(i);
        i = db.productCategoryDAO().insertCategory(pc2);
        pc2.setId(i);
        i = db.productCategoryDAO().insertCategory(pc3);
        pc3.setId(i);
        i = db.productCategoryDAO().insertCategory(pc4);
        pc4.setId(i);
        i = db.productCategoryDAO().insertCategory(pc5);
        pc5.setId(i);
        i = db.productCategoryDAO().insertCategory(pc6);
        pc6.setId(i);
        i = db.productCategoryDAO().insertCategory(pc7);
        pc7.setId(i);
        i = db.productCategoryDAO().insertCategory(pc8);
        pc8.setId(i);
        i = db.productCategoryDAO().insertCategory(pc9);
        pc9.setId(i);
        i = db.productCategoryDAO().insertCategory(pc10);
        pc10.setId(i);
        i = db.productCategoryDAO().insertCategory(pc11);
        pc11.setId(i);
        i = db.productCategoryDAO().insertCategory(pc12);
        pc12.setId(i);
        i = db.productCategoryDAO().insertCategory(pc13);
        pc13.setId(i);

        Tag t1 = new Tag("Food");
        Tag t2 = new Tag("Tech");

        i = db.tagDAO().insertTag(t1);
        t1.setId(i);
        i = db.tagDAO().insertTag(t2);
        t2.setId(i);

        Store s1 = new Store("Billa", "Billa", "Billa", "www.billa.at", st1.getId(),
                new OpeningHours(new OpeningHours.Time(8,0), new OpeningHours.Time(20,0), false), "Main Street 7", "1010");
        Store s2 = new Store("Hofer", "Hofer", "Hofer", "www.hofer.at", st1.getId(),
                new OpeningHours(new OpeningHours.Time(7,0), new OpeningHours.Time(19,30), true), "Main Street 2", "1010");
        Store s3 = new Store("Spar", "Spar", "Spar", "www.spar.at", st1.getId(),
                new OpeningHours(new OpeningHours.Time(8,0), new OpeningHours.Time(18,30), false), "Spar Street 1", "9010");
        Store s4 = new Store("Eurospar", "Eurospar", "Eurospar", "www.spar.at", st1.getId(),
                new OpeningHours(new OpeningHours.Time(7,0), new OpeningHours.Time(19,30), false), "Spar Street 2", "8010");
        Store s5 = new Store("Interspar", "Interspar", "Interspar", "www.spar.at", st1.getId(),
                new OpeningHours(new OpeningHours.Time(7,0), new OpeningHours.Time(22,0), true), "Spar Street 3", "8010");
        Store s6 = new Store("Merkur", "Merkur", "Merkur", "www.merkurmarkt.at", st1.getId(),
                new OpeningHours(new OpeningHours.Time(8,0), new OpeningHours.Time(19,0), false), "Greenfield Street 1", "8010");
        Store s7 = new Store("Penny", "Penny", "Penny", "https://www.penny.at/", st1.getId(),
                new OpeningHours(new OpeningHours.Time(8,0), new OpeningHours.Time(19,0), false), "Greenfield Street 1", "8010");

        Store s8 = new Store("MediaMarkt", "MediaMarkt", "MediaMarkt", "www.mediamarkt.at", st2.getId(),
                new OpeningHours(new OpeningHours.Time(9,30), new OpeningHours.Time(19,30), false), "Acorn Avenue 1", "4010");
        Store s9 = new Store("Saturn", "Saturn", "Saturn", "www.saturn.at", st2.getId(),
                new OpeningHours(new OpeningHours.Time(8,30), new OpeningHours.Time(18,30), false), "West Lane 192", "4010");
        Store s10 = new Store("Conrad", "Conrad", "Conrad", "www.conrad.at", st2.getId(),
                new OpeningHours(new OpeningHours.Time(7,30), new OpeningHours.Time(19,0), false), "Mount Lane 203", "8010");
        Store s11 = new Store("Hartlauer", "Hartlauer", "Hartlauer", "www.hartlauer.at", st2.getId(),
                new OpeningHours(new OpeningHours.Time(8,30), new OpeningHours.Time(18,30), false), "Bath Boulevard 27", "1010");
        Store s12 = new Store("Best Buy", "Best Buy", "Best Buy", "www.bestbuy.com", st2.getId(),
                new OpeningHours(new OpeningHours.Time(8,30), new OpeningHours.Time(18,30), false), "Hart Passage 82", "1010");
        Store s13 = new Store("Euronics", "Euronics", "Euronics", "www.euronics.de", st2.getId(),
                new OpeningHours(new OpeningHours.Time(8,30), new OpeningHours.Time(18,30), false), "Flint Avenue 23", "8010");

        Store s14 = new Store("Bipa", "Bipa", "Bipa", "www.bipa.at", st3.getId(),
                new OpeningHours(new OpeningHours.Time(8,30), new OpeningHours.Time(18,30), false), "Circus Street 54", "8010");
        Store s15 = new Store("DM", "DM", "DM", "www.meindm.at", st3.getId(),
                new OpeningHours(new OpeningHours.Time(8,0), new OpeningHours.Time(18,30), false), "Windmill Route 14", "1010");
        Store s16 = new Store("Müller", "Müller", "Müller", "www.mueller-drogerie.at", st3.getId(),
                new OpeningHours(new OpeningHours.Time(8,0), new OpeningHours.Time(20,0), false), "Hazelnut Row 7", "4010");
        Store s17 = new Store("Walgreens", "Walgreen", "Walgreen", "www.walgreens.com", st3.getId(),
                new OpeningHours(new OpeningHours.Time(7,30), new OpeningHours.Time(22,30), false), "Castle Avenue 5", "4010");
        Store s18 = new Store("CVSHealth", "CVSHealth", "CVSHealth", "www.cvshealth.com", st3.getId(),
                new OpeningHours(new OpeningHours.Time(8,30), new OpeningHours.Time(18,30), false), "Ivy Row 8", "1010");
        Store s19 = new Store("Express Scripts", "Express Scripts", "Express Scripts", "www.express-scripts.com", st3.getId(),
                new OpeningHours(new OpeningHours.Time(9,30), new OpeningHours.Time(21,0), true), "Serenity Row 1", "1010");

        Store s20 = new Store("Möbelix", "Möbelix", "Möbelix", "www.moebelix.at", st4.getId(),
                new OpeningHours(new OpeningHours.Time(8,0), new OpeningHours.Time(19,30), false), "Bright Avenue 2", "8010");
        Store s21 = new Store("Kika", "Kika", "Kika", "www.kika.at", st4.getId(),
                new OpeningHours(new OpeningHours.Time(7,30), new OpeningHours.Time(20,0), false), "Duke Passage 47", "8010");
        Store s22 = new Store("IKEA", "IKEA", "IKEA", "www.ikea.com", st4.getId(),
                new OpeningHours(new OpeningHours.Time(9,0), new OpeningHours.Time(20,0), true), "University Lane 16", "8010");
        Store s23 = new Store("XXXLutz", "XXXLutz", "XXXLutz", "www.xxxlutz.at", st4.getId(),
                new OpeningHours(new OpeningHours.Time(8,30), new OpeningHours.Time(18,30), false), "Snowflake Street 73", "1010");
        Store s24 = new Store("Leiner", "Leiner", "Leiner", "www.leiner.at", st4.getId(),
                new OpeningHours(new OpeningHours.Time(8,0), new OpeningHours.Time(19,30), true), "Butcher Boulevard 134", "4010");

        i = db.storeDAO().insertStore(s15);
        s15.setId(i);
        i = db.storeDAO().insertStore(s16);
        s16.setId(i);
        i = db.storeDAO().insertStore(s1);
        s1.setId(i);
        i = db.storeDAO().insertStore(s6);
        s6.setId(i);
        i = db.storeDAO().insertStore(s7);
        s7.setId(i);
        i = db.storeDAO().insertStore(s2);
        s2.setId(i);
        i = db.storeDAO().insertStore(s3);
        s3.setId(i);
        i = db.storeDAO().insertStore(s10);
        s10.setId(i);
        i = db.storeDAO().insertStore(s11);
        s11.setId(i);
        i = db.storeDAO().insertStore(s4);
        s4.setId(i);
        i = db.storeDAO().insertStore(s20);
        s20.setId(i);
        i = db.storeDAO().insertStore(s21);
        s21.setId(i);
        i = db.storeDAO().insertStore(s5);
        s5.setId(i);
        i = db.storeDAO().insertStore(s8);
        s8.setId(i);
        i = db.storeDAO().insertStore(s9);
        s9.setId(i);
        i = db.storeDAO().insertStore(s12);
        s12.setId(i);
        i = db.storeDAO().insertStore(s13);
        s13.setId(i);
        i = db.storeDAO().insertStore(s14);
        s14.setId(i);
        i = db.storeDAO().insertStore(s18);
        s18.setId(i);
        i = db.storeDAO().insertStore(s19);
        s19.setId(i);
        i = db.storeDAO().insertStore(s22);
        s22.setId(i);
        i = db.storeDAO().insertStore(s17);
        s17.setId(i);
        i = db.storeDAO().insertStore(s23);
        s23.setId(i);
        i = db.storeDAO().insertStore(s24);
        s24.setId(i);

        Calendar offerEnds = Calendar.getInstance();
        offerEnds.add(Calendar.MONTH, 1);

        Product p1 = new Product("Peanut Butter", "Peanut Butter is loaded with delicious peanut flavor and has a smooth creamy texture.", 2.4, 5.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s1.getId(), pc1.getId());
        Product p2 = new Product("Sugar", "This stuff is gluten-free!", 2.1, 10.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s2.getId(), pc1.getId());
        Product p3 = new Product("Spam Classic Canned Meat", "Have a nice and hearty meal ready to enjoy in just minutes with this 12-oz can of Spam Canned Meat.", 8.0, 10.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s3.getId(), pc1.getId());
        Product p4 = new Product("Barilla Pasta Penne", "Barilla pasta is synonymous with high quality and al dente perfection every time.", 1.95, 10.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s4.getId(), pc1.getId());
        Product p5 = new Product("Kidney Beans", "These juicy beans are high in dietary fiber, with a creamy texture that lends itself easily to a variety of different recipes.", 1.64, 20.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s5.getId(), pc1.getId());

        i = db.productDAO().insertProduct(p1);
        p1.setId(i);
        i = db.productDAO().insertProduct(p2);
        p2.setId(i);
        i = db.productDAO().insertProduct(p3);
        p3.setId(i);
        i = db.productDAO().insertProduct(p4);
        p4.setId(i);
        i = db.productDAO().insertProduct(p5);
        p5.setId(i);

        Product p6 = new Product("Nescafe Clasico", "Launch your morning with a refreshing cup of java with this Nescafe Clasico Instant Coffee.", 7.77, 4.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s6.getId(), pc2.getId());
        Product p7 = new Product("Coca-Cola", "The best softdrink in the world.", 1.99, 25.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s7.getId(), pc2.getId());
        Product p8 = new Product("Apple Juice", "This beverage has a delicious mix of carefully chosen ingredients, allowing you to savor every sip of the drink.", 3.77, 15.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s1.getId(), pc2.getId());
        Product p9 = new Product("Mountain Dew", "Mountain Dew Soda, the original instigator, refreshes with its one of a kind great taste.", 3.19, 5.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s2.getId(), pc2.getId());
        Product p10 = new Product("Gatorade Sports Drink", "With a legacy over 40 years in the making, its the most scientifically researched and game-tested way to replace electrolytes lost in sweat.", 3.09, 10.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s3.getId(), pc2.getId());

        i = db.productDAO().insertProduct(p6);
        p6.setId(i);
        i = db.productDAO().insertProduct(p7);
        p7.setId(i);
        i = db.productDAO().insertProduct(p8);
        p8.setId(i);
        i = db.productDAO().insertProduct(p9);
        p9.setId(i);
        i = db.productDAO().insertProduct(p10);
        p10.setId(i);


        Product p11 = new Product("SAMSUNG 55\" Smart LED TV ", "Enter a new world of entertainment with the Samsung 55\" LED Smart HDTV ", 549.49, 10.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s8.getId(), pc3.getId());
        Product p12 = new Product("Sceptre 32\" LED TV", "Escape into a world of splendid color and clarity with the Sceptre 32\" LED TV", 179.99, 50.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s9.getId(), pc3.getId());
        Product p13 = new Product("VIZIO 65\" 4K XLED", "Powered by XLED, VIZIOs powerful full-array local dimming backlight technology, the E-Series offers enhanced contrast, deep black levels, and stunning clarity. ", 899.99, 30.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s10.getId(), pc3.getId());
        Product p14 = new Product("Seiki 40\" FHD", "Enjoy sports broadcasts, movies and more on the Seiki 40\" LED TV.", 269.09, 12.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s11.getId(), pc3.getId());
        Product p15 = new Product("LG 55\" 4K LED TV ", "This model optimizes content scene-by-scene for an even more striking, more breathtaking High Dynamic Range experience.", 999.99, 5.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s12.getId(), pc3.getId());

        i = db.productDAO().insertProduct(p11);
        p11.setId(i);
        i = db.productDAO().insertProduct(p12);
        p12.setId(i);
        i = db.productDAO().insertProduct(p13);
        p13.setId(i);
        i = db.productDAO().insertProduct(p14);
        p14.setId(i);
        i = db.productDAO().insertProduct(p15);
        p15.setId(i);

        Product p16 = new Product("HP Stream 14\" Laptop", "Get the essential productivity you want, without slowing down. This nimble laptop lets you easily shift from homework workhorse to marathoning your favorite shows. ", 299.99, 8.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s13.getId(), pc4.getId());
        Product p17 = new Product("Dell Inspiron 15 3000", "Dell Inspiron 15, 3552, 15.6-inch HD Truelife LED-Backlit Display, Intel Celeron Processor N3060 (2M Cache, up to 2.48 GHz), 4GB 1600MHz DDR3L", 269.19, 7.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s9.getId(), pc4.getId());
        Product p18 = new Product("HP Slim 270 Desktop Tower", "Newly redesigned HP desktop tower that is reliable, and slimmer, with performance backed by over 100 tests.", 319.99, 2.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s10.getId(), pc4.getId());
        Product p19 = new Product("HP Pavilion 570 Desktop Tower", "Transform your workspace with the HP Pavilion desktop tower eye-catching design.", 649.00, 10.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s11.getId(), pc4.getId());
        Product p20 = new Product("Lenovo Gaming Laptop 15.6\"", "Enter the arena with this slim, lightweight and powerful portable gaming PC.", 870.70, 30.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s12.getId(), pc4.getId());

        i = db.productDAO().insertProduct(p16);
        p16.setId(i);
        i = db.productDAO().insertProduct(p17);
        p17.setId(i);
        i = db.productDAO().insertProduct(p18);
        p18.setId(i);
        i = db.productDAO().insertProduct(p19);
        p19.setId(i);
        i = db.productDAO().insertProduct(p20);
        p20.setId(i);

        Product p21 = new Product("Black Panther", "After the death of his father, the king of Wakanda, young TChalla returns home to the isolated high-tech African nation to succeed to the throne and take his rightful place as king.", 16.09, 5.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s8.getId(), pc5.getId());
        Product p22 = new Product("Red Sparrow", "In this international spy thriller, Academy Award Winner Jennifer Lawrence* is Dominika, a former ballerina forced to enter Sparrow School, a secret government program", 14.99, 10.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s13.getId(), pc5.getId());
        Product p23 = new Product("Justice League", "Fueled by his restored faith in humanity and inspired by Supermans selfless act, Bruce Wayne enlists the help of his newfound ally, Diana Prince, to face an even greater enemy.", 12.39, 8.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s10.getId(), pc5.getId());
        Product p24 = new Product("Coco", "In DisneyPixars vibrant tale of family, fun and adventure, an aspiring young musician named Miguel embarks on an extraordinary journey to the magical land of his ancestors.", 22.00, 15.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s11.getId(), pc5.getId());
        Product p25 = new Product("The Lion King", "The Lion King is a magnificent coming-of-age masterpiece.", 10.99, 24.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s12.getId(), pc5.getId());

        i = db.productDAO().insertProduct(p21);
        p21.setId(i);
        i = db.productDAO().insertProduct(p22);
        p22.setId(i);
        i = db.productDAO().insertProduct(p23);
        p23.setId(i);
        i = db.productDAO().insertProduct(p24);
        p24.setId(i);
        i = db.productDAO().insertProduct(p25);
        p25.setId(i);

        Product p26 = new Product("Call of Duty: Black Ops 4", "Call of Duty: Black Ops 4 Multiplayer raises the bar, delivering the most thrilling experience yet with a focus on tactical, grounded gameplay and player choice.", 59.99, 2.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s8.getId(), pc6.getId());
        Product p27 = new Product("Super Mario Odyssey", "Join Mario on a massive, globe-trotting 3D adventure and use his incredible new abilities to collect Moons so you can power up your airship, the Odyssey, and rescue Princess Peach from Bowser's wedding plans! ", 46.99, 10.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s9.getId(), pc6.getId());
        Product p28 = new Product("Battlefront 2", "Embark on an endless Star Wars; action experience from the bestselling Star Wars HD videogame franchise of all time.", 53.99, 7.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s13.getId(), pc6.getId());
        Product p29 = new Product("Assassin's Creed: Origins", "Ancient Egypt home of colossal pyramids, gilded tombs, tyrannical god-kings, and the origin story of the Assassins.", 39.89, 10.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s11.getId(), pc6.getId());
        Product p30 = new Product("Final Fantasy XV", "As the Crown Prince Noctis and his three best friends set out on a journey to wed his fiancee Luna, a terrible tragedy befalls his country. ", 19.99, 50.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s12.getId(), pc6.getId());

        i = db.productDAO().insertProduct(p26);
        p26.setId(i);
        i = db.productDAO().insertProduct(p27);
        p27.setId(i);
        i = db.productDAO().insertProduct(p28);
        p28.setId(i);
        i = db.productDAO().insertProduct(p29);
        p29.setId(i);
        i = db.productDAO().insertProduct(p30);
        p30.setId(i);

        //Perfume
        Product p44 = new Product("Burberry", "Burberry Brit Sheer Eau De Toilette Spray, Perfume for Women, 3.3 Oz", 30.48, 5.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s14.getId(), pc7.getId());
        Product p45 = new Product("Chloe", "Chloe Eau de Parfum Spray, Perfume For Women 2.5 Oz", 56.98, 15.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s15.getId(), pc7.getId());
        Product p46 = new Product("Marc Jacobs", "Marc Jacobs Daisy Eau De Toilette Spray, Perfume for Women, 1.7 Oz", 40.39, 25.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s16.getId(), pc7.getId());
        Product p47 = new Product("Hermes", "Hermes Un Jardin Sur Le Nil Eau De Toilette Spray, 3.4 Oz", 65.95, 13.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s17.getId(), pc7.getId());
        Product p48 = new Product("Gucci", "Gucci Bamboo Perfume For Women Spray 2.5 Oz", 57.17, 23.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s18.getId(), pc7.getId());
        Product p49 = new Product("Dolce & Gabbana", "Dolce & Gabbana The One Perfume For Women Spray 2.5 Oz", 59.39, 3.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s19.getId(), pc7.getId());

        i = db.productDAO().insertProduct(p44);
        p44.setId(i);
        i = db.productDAO().insertProduct(p45);
        p45.setId(i);
        i = db.productDAO().insertProduct(p46);
        p46.setId(i);
        i = db.productDAO().insertProduct(p47);
        p47.setId(i);
        i = db.productDAO().insertProduct(p48);
        p48.setId(i);
        i = db.productDAO().insertProduct(p49);
        p49.setId(i);

        //Medical Care
        Product p50 = new Product("Equate Allergy Relief Diphenhydramine Antihistamine", "Capsules, 25 mg, 100 Ct", 4.0, 5.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s14.getId(), pc8.getId());
        Product p51 = new Product("Benadryl Ultratabs Antihistamine Allergy Medicine", "Tablets, 24 ct", 4.44, 20.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s14.getId(), pc8.getId());
        Product p52 = new Product("SmartyPants Women’s Complete Dietary Supplement", "120 CT Gummies", 16.88, 25.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s15.getId(), pc8.getId());
        Product p53 = new Product("Vitafusion Adult Women's Multivitamin Gummies", "Berry, 150 Ct", 9.88, 10.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s15.getId(), pc8.getId());
        Product p54 = new Product("Centrum Silver Women 50+ Multivitamin Tablets", "200 Ct", 17.44, 10.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s16.getId(), pc8.getId());

        i = db.productDAO().insertProduct(p50);
        p50.setId(i);
        i = db.productDAO().insertProduct(p51);
        p51.setId(i);
        i = db.productDAO().insertProduct(p52);
        p52.setId(i);
        i = db.productDAO().insertProduct(p53);
        p53.setId(i);
        i = db.productDAO().insertProduct(p54);
        p54.setId(i);

        //Makeup
        Product p55 = new Product("Milani Conceal + Perfect 2-in-1 Foundation + Concealer", "Natural", 9.99, 5.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s14.getId(), pc9.getId());
        Product p56 = new Product("L'Oréal Paris Voluminous Primer Mascara", "Instantly thicker, longer lashes", 5.84, 10.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s15.getId(), pc9.getId());
        Product p57 = new Product("L'Oréal Paris Infallible Pro-Matte Foundation", "Classic Ivory", 10.97, 20.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s16.getId(), pc9.getId());
        Product p58 = new Product("e.l.f. Makeup Mist & Set Setting Spray, Clear", "Long-lasting formula with a smooth finish", 4.0, 2.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s17.getId(), pc9.getId());
        Product p59 = new Product("NYX Professional Makeup Matte Bronzer, Deep Tan", "Gives you the bronze effect without the shimmer", 8.97, 5.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s18.getId(), pc9.getId());
        Product p60 = new Product("Maybelline New York Great Lash Washable Mascara, Very Black", "Classic volume brush", 4.44, 13.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s19.getId(), pc9.getId());

        i = db.productDAO().insertProduct(p55);
        p55.setId(i);
        i = db.productDAO().insertProduct(p56);
        p56.setId(i);
        i = db.productDAO().insertProduct(p57);
        p57.setId(i);
        i = db.productDAO().insertProduct(p58);
        p58.setId(i);
        i = db.productDAO().insertProduct(p59);
        p59.setId(i);
        i = db.productDAO().insertProduct(p60);
        p60.setId(i);

        //Chair
        Product p61 = new Product("Mainstays 24\" Ladder Back Swivel Barstool with Microfiber Cushion, Tan", "Features sturdy metal construction with a dark hammered bronze finish that complements a wide range of color schemes and decorative styles", 27.4, 12.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s20.getId(), pc10.getId());
        Product p62 = new Product("Angel Line Cambridge 24\" Padded Saddle Stool, White w/ Gray Cushion", "This Cambridge 24\" Padded Stool in White with Gray Upholstered Seat and Nail Head Trim is perfect for any counter space or high top table.", 49.99, 2.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s21.getId(), pc10.getId());
        Product p63 = new Product("Better Homes and Gardens Bankston Counter Height Stool, Set of 2, Mocha", "Pair with Bankston Counter Height Dining Table to create complete dining set", 89.99, 20.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s22.getId(), pc10.getId());
        Product p64 = new Product("Costway Set Of 2 Bar Stools PU Leather Adjustable Barstool Swivel Pub Chairs Brown", "This is our Bar stools, which will offer you a comfortable seating experience. Its simple but elegant design makes it perfect for home, restaurant, company use etc.", 79.99, 10.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s23.getId(), pc10.getId());
        Product p65 = new Product("Better Homes & Gardens 29\" Harper Stool, Multiple Colors", "Vintage oak finish", 44.97, 25.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s24.getId(), pc10.getId());

        i = db.productDAO().insertProduct(p61);
        p61.setId(i);
        i = db.productDAO().insertProduct(p62);
        p62.setId(i);
        i = db.productDAO().insertProduct(p63);
        p63.setId(i);
        i = db.productDAO().insertProduct(p64);
        p64.setId(i);
        i = db.productDAO().insertProduct(p65);
        p65.setId(i);

        //Table
        Product p66 = new Product("Better Homes and Gardens Mercer Dining Table, Vintage Oak finish", "Accommodates seating for 6", 159.0, 3.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s20.getId(), pc11.getId());
        Product p67 = new Product("Better Homes and Gardens Bryant Dining Table, Comfortably Seats 6, Rustic Brown Finish", "This sturdy wood dining room table is the perfect blend of modern and classic design that will complement most any decor, from contemporary to traditional and all things in between", 199.99, 10.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s21.getId(), pc11.getId());
        Product p68 = new Product("Ansa Dining Table, Multiple Colors", "Rectangular table", 91.51, 2.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s22.getId(), pc11.getId());
        Product p69 = new Product("Farmhouse Table, White/Natural", "Handsome hardwood dining table made of durable hardwood construction", 170.0, 4.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s23.getId(), pc11.getId());
        Product p70 = new Product("Better Homes and Gardens Maddox Crossing Dining Table, Brown", "The simple, sleek design of this table fits well with most any decor, from modern or contemporary to traditional or minimalist", 149.0, 9.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s24.getId(), pc11.getId());

        i = db.productDAO().insertProduct(p66);
        p66.setId(i);
        i = db.productDAO().insertProduct(p67);
        p67.setId(i);
        i = db.productDAO().insertProduct(p68);
        p68.setId(i);
        i = db.productDAO().insertProduct(p69);
        p69.setId(i);
        i = db.productDAO().insertProduct(p70);
        p70.setId(i);

        //Wardrobe
        Product p71 = new Product("Manhattan Comfort Eldridge Wardrobe", "Inspired by Danish design, the Manhattan Comfort Eldridge Wardrobe is the perfect complement to your modern bedroom décor", 799.0, 12.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s20.getId(), pc12.getId());
        Product p72 = new Product("Mainstays Closet Storage, Silver/Black", "Convenient, efficient method for organization", 60.0, 8.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s21.getId(), pc12.getId());
        Product p73 = new Product("Rubbermaid Portable Garment Closet, 60 In.", "Breathable fabric cover to help prevent mildewing and accumulated moisturer", 24.65, 10.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s22.getId(), pc12.getId());
        Product p74 = new Product("Whitmor Deluxe Utility Closet with Gray Cover", "This easy, no tools required closet, looks great and adds function to almost any space", 55.14, 4.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s23.getId(), pc12.getId());
        Product p75 = new Product("Closetmaid Vertical Closet Organizer, 12\", White", "Includes tower and 3 expandable hanging rods", 48.55, 9.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s24.getId(), pc12.getId());

        i = db.productDAO().insertProduct(p71);
        p71.setId(i);
        i = db.productDAO().insertProduct(p72);
        p72.setId(i);
        i = db.productDAO().insertProduct(p73);
        p73.setId(i);
        i = db.productDAO().insertProduct(p74);
        p74.setId(i);
        i = db.productDAO().insertProduct(p75);
        p75.setId(i);

        //Bed
        Product p76 = new Product("DHP Rose Linen Tufted Upholstered Platform Bed", "Contemporary style", 127.5, 10.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s20.getId(), pc13.getId());
        Product p77 = new Product("Maven Upholstered Platform Bed", "Simple design ideal for modern decor", 92.0, 3.5,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s21.getId(), pc13.getId());
        Product p78 = new Product("Mainstays Upholstered Bed, Grey Linen,", "Wood slats keep the mattress supported", 128.0, 5.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s22.getId(), pc13.getId());
        Product p79 = new Product("Mainstays Westlake Twin Bed", "Includes headboard and footboard", 99.0, 7.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s23.getId(), pc13.getId());
        Product p80 = new Product("LuXeo Bedford King Upholstered Platform Bed in Beige", "Includes a headboard, footboard, bed slats and upholstered rails", 468.40, 12.0,
                new Date(System.currentTimeMillis()), offerEnds.getTime(), s24.getId(), pc13.getId());

        i = db.productDAO().insertProduct(p76);
        p76.setId(i);
        i = db.productDAO().insertProduct(p77);
        p77.setId(i);
        i = db.productDAO().insertProduct(p78);
        p78.setId(i);
        i = db.productDAO().insertProduct(p79);
        p79.setId(i);
        i = db.productDAO().insertProduct(p80);
        p80.setId(i);

        ProductRating pr1 = new ProductRating(p1.getId(), c1.getId(), 5, "Great!");
        ProductRating pr2 = new ProductRating(p2.getId(), c1.getId(), 3, "Meeh...");
        ProductRating pr3 = new ProductRating(p3.getId(), c2.getId(), 4, "Nice.");
        ProductRating pr4 = new ProductRating(p4.getId(), c1.getId(), 2, "Worst PC EVER!");
        ProductRating pr5 = new ProductRating(p4.getId(), c2.getId(), 5, "Best PC EVER!!!!");
        db.productRatingDAO().insertProductRating(pr1);
        db.productRatingDAO().insertProductRating(pr2);
        db.productRatingDAO().insertProductRating(pr3);
        db.productRatingDAO().insertProductRating(pr4);
        db.productRatingDAO().insertProductRating(pr5);


        StoreRating sr1 = new StoreRating(s1.getId(),c1.getId(), 5, "");
        StoreRating sr2 = new StoreRating(s2.getId(),c1.getId(), 3, "okay...");
        StoreRating sr3 = new StoreRating(s2.getId(),c2.getId(), 5, "Super helpful staff");

        db.storeRatingDAO().insertStoreRating(sr1);
        db.storeRatingDAO().insertStoreRating(sr2);
        db.storeRatingDAO().insertStoreRating(sr3);
    }



    public List<Product> getProducts() {
        return CustomApplication.getDb().productDAO().getAllProducts();
    }

    public List<Store> getStores() {
        return CustomApplication.getDb().storeDAO().getAllStores();
    }

    public List<Tag> getTags() {
        //TODO: Query
        return null;
    }

    // Favorites
    public void AddFavorite(Store store) {
        Favorit f = new Favorit(CustomApplication.getLoggedInCustomer().getId(), store.getId());
        CustomApplication.getDb().favoritDAO().insertFavorit(f);
    }

    public List<Store> GetFavorites() {
        return CustomApplication.getDb().favoritDAO().getAllFavoritesStores(CustomApplication.getLoggedInCustomer().getId());
    }

    public void RemoveFavorite(Store store) {
        Favorit f = new Favorit(CustomApplication.getLoggedInCustomer().getId(), store.getId());
        CustomApplication.getDb().favoritDAO().deleteFavorit(f);
    }

    // Shopping Cart
    public void addShoppingCart(Product product) {
        SavedOffer savedOffer = new SavedOffer(CustomApplication.getLoggedInCustomer().getId(), product.getId());
        CustomApplication.getDb().savedOfferDAO().insertSavedOffer(savedOffer);
    }

    public List<Product> getShoppingCartProducts() {
        return CustomApplication.getDb().savedOfferDAO().getSavedOffersForCustomer(CustomApplication.getLoggedInCustomer().getId());
    }

    public void removeShoppingCart(Product product) {
        SavedOffer savedOffer = new SavedOffer(CustomApplication.getLoggedInCustomer().getId(), product.getId());
        CustomApplication.getDb().savedOfferDAO().deleteSavedOffer(savedOffer);
    }

    public String getCategoryForProduct(long categoryId) {
        return CustomApplication.getDb().productCategoryDAO().getCategoryForProduct(categoryId);
    }

    public Customer loginCustomer(String username, String password) {
        Customer c = CustomApplication.getDb().customerDAO().loginCustomer(username, password);
        if(c != null)
            CustomApplication.setLoggedInCustomer(c);
        return c;
    }

    public boolean registerCustomer(String username, String password) {
        Customer customer = CustomApplication.getDb().customerDAO().findCustomer(username);

        if(customer == null)
        {
            Customer newCustomer = new Customer(username, password, username);
            CustomApplication.getDb().customerDAO().insertCustomer(newCustomer);
            return true;
        }

        return false;
    }
}

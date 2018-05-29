package xpmxp1.tenderstar;

import android.support.test.rule.ActivityTestRule;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import xpmxp1.tenderstar.Utils.TestActivity;
import xpmxp1.tenderstar.app_objects.Store;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class MapInstrumentedTests {

    private Store store = Database.getInstance().getStores().get(0);;
    private HomeFragment m_Fragment;

    @Rule
    public ActivityTestRule<MainActivity> TestRule =
            new ActivityTestRule<>(MainActivity.class, true, true);

    @BeforeClass
    public static void init(){
        CustomApplication.nukeTables();
        CustomApplication.fillDbWithTestData();
        Database.getInstance().loginCustomer("Admin", "Admin");
    }

    @Before
    public void initTest(){
    }

    @Test
    public void check_map_visible() {
        TestRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Navigation.getInstance().navigateToMap();
            }
        });
        try {
            Thread.sleep(5000);
        } catch(Exception e) { }
        onView(withId(R.id.mapView)).check(matches(isDisplayed()));
    }
    @Test
    public void check_navigation_visible() {
        TestRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Navigation.getInstance().navigateToMap(store);
            }
        });
        try {
            Thread.sleep(5000);
        } catch(Exception e) { }
        onView(withId(R.id.mapView)).check(matches(isDisplayed()));
    }
}

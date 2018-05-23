package xpmxp1.tenderstar;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import org.junit.runner.RunWith;

import xpmxp1.tenderstar.Utils.TestActivity;
import xpmxp1.tenderstar.app_objects.Store;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class StoreDetailsInstrumentedTests {

    private Store store = Database.getInstance().getStores().get(0);;
    private StoreDetailsFragment m_Fragment;

    @Rule
    public ActivityTestRule<TestActivity> TestRule =
            new ActivityTestRule<>(TestActivity.class, true, true);

    @BeforeClass
    public static void init(){
        Database.nukeTables();
        Database.fillDbWithTestData();
        Database.getInstance().loginCustomer("Admin", "Admin");
    }

    @Before
    public void initTest(){
        m_Fragment = new StoreDetailsFragment();
        m_Fragment.setStore(store);
        TestRule.getActivity().setFragment(m_Fragment);
    }

    @Test
    public void check_store_details_visible() {
        onView(withId(R.id.textView_search)).check(matches(isDisplayed()));
        onView(withId(R.id.textView_address)).check(matches(isDisplayed()));
        onView(withId(R.id.textView_hours)).check(matches(isDisplayed()));
        onView(withId(R.id.textView_link)).check(matches(isDisplayed()));
    }

}

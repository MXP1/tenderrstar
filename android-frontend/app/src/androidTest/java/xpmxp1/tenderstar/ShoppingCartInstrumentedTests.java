package xpmxp1.tenderstar;

import android.provider.ContactsContract;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Date;

import xpmxp1.tenderstar.Utils.TestActivity;
import xpmxp1.tenderstar.app_objects.Product;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.IsNot.not;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static xpmxp1.tenderstar.Database.*;

@RunWith(AndroidJUnit4.class)
public class ShoppingCartInstrumentedTests {

    private ShoppingCartFragment m_Fragment;
    private Product TestProduct;

    @Rule
    public ActivityTestRule<TestActivity> TestRule =
            new ActivityTestRule<>(TestActivity.class, true, true);

    @Before
    public void init(){
        TestProduct = Database.getInstance().getProducts().get(0);
        //TestProduct = new Product("Ham", "desc", 2.0, 10.0, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 10000), 1, 1);
        //Database = Database.getDummyInstance();
        Database.getInstance().addShoppingCart(TestProduct);

        m_Fragment = new ShoppingCartFragment();
        TestRule.getActivity().setFragment(m_Fragment);
    }

    @After
    public void tear_down(){
        getInstance().removeShoppingCart(TestProduct);
    }

    @Test
    public void checkListVisible() {
        onView(withId(R.id.shopping_cart_product_list)).check(matches(isDisplayed()));
    }

    @Test
    public void checkEntryVisible() {
        onView(withId(R.id.textView_name)).check(matches(isDisplayed()));
//        onView(withId(R.id.textView_category)).check(matches(isDisplayed()));
        onView(withId(R.id.textView_description)).check(matches(isDisplayed()));
        onView(withId(R.id.textView_price)).check(matches(isDisplayed()));

        onView(withId(R.id.button_add_shopping_cart)).check(matches(not(isDisplayed())));
        onView(withId(R.id.button_remove_shopping_cart)).check(matches(isDisplayed()));
    }

    @Test
    public void removeEntry() {
        onView(withId(R.id.button_remove_shopping_cart)).check(matches(isDisplayed()));
        onView(withId(R.id.button_remove_shopping_cart)).check(matches(isClickable()));

        //remove product entry
        onView(withId(R.id.button_remove_shopping_cart)).perform(click());

        onView(withId(R.id.textView_name)).check(doesNotExist());
        onView(withId(R.id.textView_category)).check(doesNotExist());
        onView(withId(R.id.textView_description)).check(doesNotExist());
        onView(withId(R.id.textView_price)).check(doesNotExist());
    }




}

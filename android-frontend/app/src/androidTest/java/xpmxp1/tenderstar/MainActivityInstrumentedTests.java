package xpmxp1.tenderstar;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentedTests {

    @Rule
    public ActivityTestRule<MainActivity> TestRule =
            new ActivityTestRule<>(MainActivity.class, true, true);

    @BeforeClass
    public static void init(){
        CustomApplication.nukeTables();
        CustomApplication.fillDbWithTestData();
        Database.getInstance().loginCustomer("Admin", "Admin");
    }


    @Test
    public void home_visible() {
        checkHomeVisible();
    }

    @Test
    public void navigate_home() {
        onView(withId(R.id.nav_home)).perform(click());
        checkHomeVisible();
    }

    @Test
    public void navigate_home_back() {
        onView(withId(R.id.nav_home)).perform(click());
        checkHomeVisible();
    }

    @Test
    public void navigate_favorites() {
        onView(withId(R.id.nav_favorites)).perform(click());
        checkFavoritesVisible();
    }

    @Test
    public void navigate_favorites_back() {
        onView(withId(R.id.nav_favorites)).perform(click());
        TestRule.getActivity().onBackPressed();
        checkHomeVisible();
    }

    @Test
    public void navigate_shopping_cart() {
        onView(withId(R.id.nav_shopping_cart)).perform(click());
        checkShoppingCartVisible();
    }

    @Test
    public void navigate_shopping_cart_back() {
        onView(withId(R.id.nav_shopping_cart)).perform(click());
        TestRule.getActivity().onBackPressed();
        checkHomeVisible();
    }


    @Test
    public void navigate_stores() {
        onView(withId(R.id.nav_stores)).perform(click());
        checkStoresVisible();
    }

    @Test
    public void navigate_stores_back() {
        onView(withId(R.id.nav_stores)).perform(click());
        TestRule.getActivity().onBackPressed();
        checkHomeVisible();
    }

    private void checkHomeVisible()
    {
        onView(withId(R.id.filter_view)).check(matches(isDisplayed()));
        onView(withId(R.id.editText_search)).check(matches(isDisplayed()));
        onView(withId(R.id.button_search)).check(matches(isDisplayed()));
        onView(withId(R.id.button_reset)).check(matches(isDisplayed()));
        onView(withId(R.id.products_list)).check(matches(isDisplayed()));
    }

    private void checkFavoritesVisible()
    {
        onView(withId(R.id.favorite_list)).check(matches(isDisplayed()));
    }

    private void checkShoppingCartVisible()
    {
        onView(withId(R.id.shopping_cart_product_list)).check(matches(isDisplayed()));
    }

    private void checkStoresVisible()
    {
        onView(withId(R.id.store_list)).check(matches(isDisplayed()));
    }

}

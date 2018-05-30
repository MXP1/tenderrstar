package xpmxp1.tenderstar;

import android.content.res.Resources;
import android.support.test.espresso.contrib.DrawerActions;
import android.support.test.espresso.contrib.NavigationViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.DrawerMatchers.isClosed;
import static android.support.test.espresso.contrib.DrawerMatchers.isOpen;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withChild;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;

import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;

@RunWith(AndroidJUnit4.class)
public class FilterInstrumentedTests {


    @Rule
    public ActivityTestRule<MainActivity> TestRule =
            new ActivityTestRule<>(MainActivity.class, true, true);

    @BeforeClass
    public static void init(){
        Database.nukeTables();
        Database.fillDbWithTestData();
        Database.getInstance().loginCustomer("Admin", "Admin");
    }

    @Test
    public void reset_button_clickable() {
        onView(withId(R.id.button_reset)).check(matches(isClickable()));
    }
    @Test
    public void search_button_clickable() {
        onView(withId(R.id.button_search)).check(matches(isClickable()));
    }

    @Test
    public void enter_search_product(){
        onView(withId(R.id.editText_search)).perform(typeText("Apple Juice"));
        onView(withId(R.id.button_search)).perform(click());

        onView(withId(R.id.products_list)).check(matches(isDisplayed()));
        onView(withRecyclerView(R.id.products_list).atPosition(0))
                .check(matches(hasDescendant(withText("Apple Juice")))).perform(click());
    }

    @Test
    public void enter_search_product_2(){
        onView(withId(R.id.editText_search)).perform(typeText("Gatorade"));
        onView(withId(R.id.button_search)).perform(click());

        onView(withId(R.id.products_list)).check(matches(isDisplayed()));
        onView(withRecyclerView(R.id.products_list).atPosition(0))
                .check(matches(hasDescendant(withText("Gatorade Sports Drink")))).perform(click());
    }

    @Test
    public void enter_search_store(){
        onView(withId(R.id.editText_search)).perform(typeText("hofer"));
        onView(withId(R.id.button_search)).perform(click());

        onView(withId(R.id.stores_list)).check(matches(isDisplayed()));
        onView(withRecyclerView(R.id.stores_list).atPosition(0))
                .check(matches(hasDescendant(withText("Hofer")))).perform(click());
    }

    @Test
    public void enter_search_store_2(){
        onView(withId(R.id.editText_search)).perform(typeText("penny"));
        onView(withId(R.id.button_search)).perform(click());

        onView(withId(R.id.stores_list)).check(matches(isDisplayed()));
        onView(withRecyclerView(R.id.stores_list).atPosition(0))
                .check(matches(hasDescendant(withText("Penny")))).perform(click());
    }
    @Test
    public void reset_button_works() {
        onView(withId(R.id.button_reset)).check(matches(isClickable()));
        onView(withId(R.id.products_list)).check(matches(isDisplayed()));
        onView(withId(R.id.stores_list)).check(matches(not(isDisplayed())));

    }


    public static StoreInstrumentedTests.RecyclerViewMatcher withRecyclerView(final int recyclerViewId) {
        return new StoreInstrumentedTests.RecyclerViewMatcher(recyclerViewId);
    }








}

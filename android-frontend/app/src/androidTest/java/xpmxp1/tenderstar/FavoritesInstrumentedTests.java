package xpmxp1.tenderstar;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import xpmxp1.tenderstar.Utils.TestActivity;
import xpmxp1.tenderstar.app_objects.OpeningHours;
import xpmxp1.tenderstar.app_objects.Store;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.IsNot.not;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;

@RunWith(AndroidJUnit4.class)
public class FavoritesInstrumentedTests {

    private FavoritesFragment m_Fragment;
    private Store TestStore;
//    private Database Database;

    @Rule
    public ActivityTestRule<TestActivity> TestRule =
            new ActivityTestRule<>(TestActivity.class, true, true);

    @Before
    public void init() {
        TestStore = Database.getInstance().getStores().get(0);
        Database.getInstance().loginCustomer("Admin", "Admin");
        Database.getInstance().AddFavorite(TestStore);

        m_Fragment = new FavoritesFragment();
        TestRule.getActivity().setFragment(m_Fragment);
    }

    @After
    public void tear_down(){
        Database.getInstance().RemoveFavorite(TestStore);
    }

    @Test
    public void checkListVisible() {
        onView(withId(R.id.favorite_list)).check(matches(isDisplayed()));
    }

    @Test
    public void checkEntryVisible() {
        onView(withId(R.id.textView_search)).check(matches(isDisplayed()));
        onView(withId(R.id.textView_address)).check(matches(isDisplayed()));
        onView(withId(R.id.favoriteBtn)).check(matches(not(isDisplayed())));
        onView(withId(R.id.removeFavoriteBtn)).check(matches(isDisplayed()));
    }

    @Test
    public void removeEntry() {
        onView(withId(R.id.removeFavoriteBtn)).check(matches(isDisplayed()));
        onView(withId(R.id.removeFavoriteBtn)).check(matches(isClickable()));

        //remove favorites entry
        onView(withId(R.id.removeFavoriteBtn)).perform(click());

        onView(withId(R.id.textView_search)).check(doesNotExist());
        onView(withId(R.id.textView_address)).check(doesNotExist());
        onView(withId(R.id.favoriteBtn)).check(doesNotExist());
        onView(withId(R.id.removeFavoriteBtn)).check(doesNotExist());
    }
}

package xpmxp1.tenderstar;

import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
public class RegisterInstrumentedTests {

    @Rule
    public ActivityTestRule<RegisterActivity> TestRule =
            new ActivityTestRule<>(RegisterActivity.class);

    @BeforeClass
    public static void init(){
        CustomApplication.nukeTables();
        CustomApplication.fillDbWithTestData();
    }

    @Test
    public void register_visible() {
        onView(withId(R.id.txtEmail)).check(matches(isDisplayed()));
        onView(withId(R.id.txtPassword)).check(matches(isDisplayed()));
        onView(withId(R.id.txtPasswordRepeat)).check(matches(isDisplayed()));
        onView(withId(R.id.btnRegister)).check(matches(isDisplayed()));
        onView(withId(R.id.btnBack)).check(matches(isDisplayed()));
    }

    @Test
    public void register_button_clickable() {
        onView(withId(R.id.btnRegister)).check(matches((isClickable())));
    }

    @Test
    public void register_button_enabled() {
        onView(withId(R.id.btnRegister)).check(matches((isEnabled())));
    }

    @Test
    public void back_button_clickable() {
        onView(withId(R.id.btnBack)).check(matches(isClickable()));
    }

    @Test
    public void back_button_enabled() {
        onView(withId(R.id.btnBack)).check(matches(isEnabled()));
    }

    @Test
    public void insert_email() {
        onView(withId(R.id.txtEmail)).perform(typeText("email"));
        onView(withId(R.id.txtEmail)).check(matches(withText("email")));
    }

    @Test
    public void insert_password() {
        onView(withId(R.id.txtPassword)).perform(typeText("password"));
        onView(withId(R.id.txtPassword)).check(matches(withText("password")));
    }

    @Test
    public void insert_repeat_password() {
        onView(withId(R.id.txtPasswordRepeat)).perform(typeText("password"));
        onView(withId(R.id.txtPasswordRepeat)).check(matches(withText("password")));
    }

    @Test
    public void register_successful() {
        onView(withId(R.id.txtEmail)).perform(typeText("username"));
        onView(withId(R.id.txtPassword)).perform(typeText("password"));
        onView(withId(R.id.txtPasswordRepeat)).perform(typeText("password"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.txtPasswordRepeat)).check(matches(withText("password")));

        onView(withId(R.id.btnRegister)).perform(click());

        //login is visible
        onView(withId(R.id.txtEmail)).check(matches(isDisplayed()));
        onView(withId(R.id.txtPassword)).check(matches(isDisplayed()));
        onView(withId(R.id.btnLogin)).check(matches(isDisplayed()));
        onView(withId(R.id.btnBack)).check(matches(isDisplayed()));

        //perform login
        onView(withId(R.id.txtEmail)).perform(typeText("username"));
        onView(withId(R.id.txtPassword)).perform(typeText("password"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.btnLogin)).perform(click());

        //home screen visible
        onView(withId(R.id.filter_view)).check(matches(isDisplayed()));
        onView(withId(R.id.editText_search)).check(matches(isDisplayed()));
        onView(withId(R.id.button_search)).check(matches(isDisplayed()));
        onView(withId(R.id.button_reset)).check(matches(isDisplayed()));
        onView(withId(R.id.products_list)).check(matches(isDisplayed()));
    }

    @Test
    public void register_failed() {
        onView(withId(R.id.txtEmail)).perform(typeText("Admin"));
        onView(withId(R.id.txtPassword)).perform(typeText("Admin"));
        onView(withId(R.id.txtPasswordRepeat)).perform(typeText("Admin"), ViewActions.closeSoftKeyboard());

        onView(withId(R.id.btnRegister)).perform(click());

        onView(withId((R.id.viewPasswordError))).check(matches(isDisplayed()));
        onView(withId((R.id.viewPasswordError))).check(matches(withText("Username already exists")));
    }
}

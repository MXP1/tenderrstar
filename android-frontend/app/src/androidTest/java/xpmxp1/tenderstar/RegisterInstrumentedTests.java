package xpmxp1.tenderstar;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
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
    public ActivityTestRule<RegisterActivity> registerActivityActivityTestRule =
            new ActivityTestRule<>(RegisterActivity.class);

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
}

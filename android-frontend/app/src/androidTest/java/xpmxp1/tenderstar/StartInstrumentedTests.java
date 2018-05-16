package xpmxp1.tenderstar;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


@RunWith(AndroidJUnit4.class)
public class StartInstrumentedTests {

    @Rule
    public ActivityTestRule<Start> activityTestRule =
            new ActivityTestRule<>(Start.class);

    @Test
    public void buttons_visible() {
        onView(withId(R.id.bSignUp)).check(matches(isDisplayed()));
        onView(withId(R.id.bLogin)).check(matches(isDisplayed()));
    }

    @Test
    public void signup_btn_clickable() {
        onView(withId(R.id.bSignUp)).check(matches(isClickable()));
    }

    @Test
    public void signup_btn_enabled() {
        onView(withId(R.id.bSignUp)).check(matches(isEnabled()));
    }

    @Test
    public void login_btn_clickable() {
        onView(withId(R.id.bLogin)).check(matches(isClickable()));
    }

    @Test
    public void login_btn_enabled() {
        onView(withId(R.id.bLogin)).check(matches(isEnabled()));
    }

    @Test
    public void perform_login() {
        onView(withId(R.id.bLogin)).perform(click());

        onView(withId(R.id.txtEmail)).check(matches(isDisplayed()));
        onView(withId(R.id.txtPassword)).check(matches(isDisplayed()));
        onView(withId(R.id.btnLogin)).check(matches(isDisplayed()));
        onView(withId(R.id.btnBack)).check(matches(isDisplayed()));
    }

    @Test
    public void perform_register() {
        onView(withId(R.id.bSignUp)).perform(click());

        onView(withId(R.id.txtEmail)).check(matches(isDisplayed()));
        onView(withId(R.id.txtPassword)).check(matches(isDisplayed()));
        onView(withId(R.id.txtPasswordRepeat)).check(matches(isDisplayed()));
        onView(withId(R.id.btnRegister)).check(matches(isDisplayed()));
        onView(withId(R.id.btnBack)).check(matches(isDisplayed()));
    }
}

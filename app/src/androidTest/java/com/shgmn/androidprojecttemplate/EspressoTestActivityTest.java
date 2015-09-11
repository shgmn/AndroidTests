package com.shgmn.androidprojecttemplate;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by shigemoto.takuya on 2015/09/11.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class EspressoTestActivityTest {

    @Rule
    public ActivityTestRule<EspressoTestActivity> mActivityRule = new ActivityTestRule<>(EspressoTestActivity.class);

    @Test
    public void listGoesOverTheFold() {
        onView(withText("Hello world!")).check(matches(isDisplayed()));
    }
}
package com.shgmn.androidprojecttemplate;

import android.os.Build;
import android.widget.TextView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import java.util.Calendar;

import dalvik.annotation.TestTargetClass;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.robolectric.Shadows.shadowOf;

/**
 * Created by shigemoto.takuya on 2015/09/11.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.M)
public class RobolectricTestActivityTest {

    @Test
    public void testTextView() {
        RobolectricTestActivity activity = Robolectric.buildActivity(RobolectricTestActivity.class).create().start().resume().get();
        TextView textView = (TextView) activity.findViewById(R.id.textView_hello_world);
        assertThat(shadowOf(textView).innerText(), is("Hello world!"));
    }

    @Test
    public void testGetCurrentMonthBad() {
        RobolectricTestActivity activity = Robolectric.buildActivity(RobolectricTestActivity.class).create().start().resume().get();
        int currentMonth = activity.getCurrentMonthBad();
        assertThat(currentMonth, is(5));
    }

    @Test
    public void testGetCurrentMonthGood() {
        RobolectricTestActivity activity = Robolectric.buildActivity(RobolectricTestActivity.class).create().start().resume().get();

        // 依存性の注入.
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, 5);
        activity.mCalendar = calendar;

        int currentMonth = activity.getCurrentMonthGood();
        assertThat(currentMonth, is(5));
    }

}
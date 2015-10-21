package com.shgmn.androidprojecttemplate;

import android.os.Build;
import android.widget.TextView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.assertj.core.api.Assertions.assertThat;
import static org.robolectric.Shadows.shadowOf;

/**
 * Created by shigemoto.takuya on 2015/09/11.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
public class RobolectricTestActivityTest {

    @Test
    public void testTextView() {
        RobolectricTestActivity activity = Robolectric.setupActivity(RobolectricTestActivity.class);
        TextView textView = (TextView) activity.findViewById(R.id.textView_hello_world);
        assertThat(shadowOf(textView).innerText()).isEqualTo("Hello world!");
    }

}
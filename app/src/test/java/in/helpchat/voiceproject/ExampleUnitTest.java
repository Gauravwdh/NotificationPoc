package in.helpchat.voiceproject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class ExampleUnitTest {

    @Test
    public void addition_isCorrect() throws Exception {
        MainActivity mainActivity = Robolectric.setupActivity(MainActivity.class);
        System.out.println(mainActivity.getApplication());
        assert mainActivity != null;
    }
}
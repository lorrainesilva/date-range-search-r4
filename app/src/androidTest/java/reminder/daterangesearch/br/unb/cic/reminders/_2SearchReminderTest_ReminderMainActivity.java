package reminder.daterangesearch.br.unb.cic.reminders;

import android.app.Activity;
import android.support.test.rule.ActivityTestRule;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

import com.robotium.solo.Solo;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;

import br.unb.cic.reminders2.R;

public class _2SearchReminderTest_ReminderMainActivity extends
        ActivityInstrumentationTestCase2<ReminderMainActivity> {
    @Rule
    public ActivityTestRule<ReminderMainActivity> mActivityTestRule =
            new ActivityTestRule<ReminderMainActivity>(ReminderMainActivity.class);

    private Solo solo;
    private Activity activity;

    public _2SearchReminderTest_ReminderMainActivity() {
        super(ReminderMainActivity.class);
    }

    @Override
    @Before
    public void setUp() throws Exception {
        this.activity = this.getActivity();
        this.solo = new Solo(getInstrumentation(), this.activity);
//        solo = new Solo(InstrumentationRegistry.getInstrumentation(),
//                mActivityTestRule.getActivity());
    }

    @Override
    @After
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

    public void testClickOnSearchReminderButton_shouldStartSearchReminderUi() throws Exception {
        solo.unlockScreen();
        solo.clickOnView(solo.getView(R.id.menu_searchReminder));
        assertTrue(solo.searchText("Search for a reminder"));
    }

    public void testSearchValidReminder1_shouldShowsTheReminder() throws Exception {
        solo.unlockScreen();
        solo.clickOnView(solo.getView(R.id.menu_searchReminder));
        assertTrue(solo.searchText("Search for a reminder"));
        EditText edtSearch = (EditText) solo.getEditText(0);
        solo.typeText(edtSearch, "Read a book");
        solo.clickOnButton("Search");

        assertTrue(solo.searchText("Read a book"));
        assertFalse(solo.searchText("College work"));
        assertFalse(solo.searchText("Meeting"));
    }

    public void testSearchValidReminder2_shouldShowsTheReminder() throws Exception {
        solo.unlockScreen();
        solo.clickOnView(solo.getView(R.id.menu_searchReminder));
        assertTrue(solo.searchText("Search for a reminder"));
        EditText edtSearch = (EditText) solo.getEditText(0);
        solo.typeText(edtSearch, "College work");
        solo.clickOnButton("Search");

        assertTrue(solo.searchText("College work"));
        assertFalse(solo.searchText("Read a book"));
        assertFalse(solo.searchText("Meeting"));
    }

    public void testSearchValidReminder3_shouldShowsTheReminder() throws Exception {
        solo.unlockScreen();
        solo.clickOnView(solo.getView(R.id.menu_searchReminder));
        assertTrue(solo.searchText("Search for a reminder"));
        EditText edtSearch = (EditText) solo.getEditText(0);
        solo.typeText(edtSearch, "Meeting");
        solo.clickOnButton("Search");

        assertTrue(solo.searchText("Meeting"));
        assertFalse(solo.searchText("College work"));
        assertFalse(solo.searchText("Read a book"));
    }

    public void testSearchInvalidReminder_shouldNotShowsTheReminder() throws Exception {
        solo.unlockScreen();
        solo.clickOnView(solo.getView(R.id.menu_searchReminder));
        assertTrue(solo.searchText("Search for a reminder"));
        EditText edtSearch = (EditText) solo.getEditText(0);
        solo.typeText(edtSearch, "Raspberry");
        solo.clickOnButton("Search");

        assertFalse(solo.searchText("Meeting"));
        assertFalse(solo.searchText("College work"));
        assertFalse(solo.searchText("Read a book"));
    }
}

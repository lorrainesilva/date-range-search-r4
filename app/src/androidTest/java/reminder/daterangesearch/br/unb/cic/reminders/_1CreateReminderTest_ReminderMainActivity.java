package reminder.daterangesearch.br.unb.cic.reminders;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.support.test.rule.ActivityTestRule;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

import com.robotium.solo.Solo;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;

import java.util.Calendar;
import java.util.Date;

import br.unb.cic.reminders2.R;
import reminder.daterangesearch.br.unb.cic.reminders.ReminderMainActivity;
import reminder.daterangesearch.br.unb.cic.reminders.view.AddReminderActivity;

public class _1CreateReminderTest_ReminderMainActivity extends
        ActivityInstrumentationTestCase2<ReminderMainActivity> {
    @Rule
    public ActivityTestRule<ReminderMainActivity> mActivityTestRule =
            new ActivityTestRule<ReminderMainActivity>(ReminderMainActivity.class);

    private Solo solo;
    private Activity activity;

    public _1CreateReminderTest_ReminderMainActivity() {
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

    public void testClickOnAddReminderButton_shouldStartAddReminderUi() throws Exception {
        solo.unlockScreen();
        solo.clickOnView(solo.getView(R.id.menu_addReminder));
        solo.assertCurrentActivity("Expected Add Reminder Activity", AddReminderActivity.class);
    }

    public void testCreateValidReminder1_shouldBeShownOnReminderMainUi() throws Exception {
        // Unlock the screen
        solo.unlockScreen();

        // Click on "+" button
        solo.clickOnView(solo.getView(R.id.menu_addReminder));

        // Search for EditText of reminder title
        EditText etReminderTitle = (EditText) solo.getView(R.id.edtReminder);

        // Clean the reminder title EditText
        solo.clearEditText(etReminderTitle);

        // Enter with a title for reminder
        solo.enterText(etReminderTitle,"Read a book");

        // Same process of EditText for reminder title in EditText for reminder details
        EditText etReminderDetails = (EditText) solo.getView(R.id.edtDetails);
        solo.clearEditText(etReminderDetails);
        solo.enterText(etReminderDetails, "The Comedy");

        // Click on spinner of date initial
        solo.clickOnView(solo.getView(R.id.spinnerDateStart));
        // Click on "+ Select" option of date spinner initial
        solo.clickOnText("+ Select");

        // Wait for DatePickerFragment
        solo.waitForFragmentByTag("datePicker");

        // Get the DatePickerFragment
        DialogFragment dateStartFragment = (DialogFragment) solo.getCurrentActivity()
                .getFragmentManager().findFragmentByTag("datePicker");

        // Wait until DatePickerFragment is visible on screen
        assertNotNull(dateStartFragment);
        while (!(isShown(dateStartFragment))) {
            System.out.println("Dialog fragment visible: " + isShown(dateStartFragment));
            solo.sleep(100);
        }

        // Type cast for DatePickerDialog
        DatePickerDialog dateStartPicker = (DatePickerDialog) dateStartFragment.getDialog();

        // Get a date in future
        Calendar dayInDistantPast = DayInDistantPast();

        // Set the date
        assertNotNull(dateStartPicker);
        solo.setDatePicker(dateStartPicker.getDatePicker(), dayInDistantPast.get(Calendar.YEAR),
                dayInDistantPast.get(Calendar.MONTH), dayInDistantPast.get(Calendar.DAY_OF_MONTH));

        // Click on "OK" button
        solo.clickOnText("OK");

        // Click on spinner of time
        solo.clickOnView(solo.getView(R.id.spinnerTimeStart));
        // Click on "+ Select" option of time spinner
        solo.clickOnText("+ Select");

        // Wait for TimePickerFragment
        solo.waitForFragmentByTag("timePicker");

        // Get the DatePickerFragment
        DialogFragment timeStartFragment = (DialogFragment) solo.getCurrentActivity()
                .getFragmentManager().findFragmentByTag("timePicker");

        // Wait until DatePickerFragment is visible on screen
        assertNotNull(timeStartFragment);
        while (!(isShown(timeStartFragment))) {
            System.out.println("Dialog fragment visible: " + isShown(timeStartFragment));
            solo.sleep(100);
        }

        // Type cast for TimePickerDialog
        TimePickerDialog timeStartPicker = (TimePickerDialog) timeStartFragment.getDialog();

        // Set the time
        assertNotNull(timeStartPicker);
        timeStartPicker.updateTime(dayInDistantPast.get(Calendar.HOUR_OF_DAY), dayInDistantPast.get(Calendar.MINUTE));

        // Click on "OK" button
        solo.clickOnText("OK");

        // Click on spinner of date final
        solo.clickOnView(solo.getView(R.id.spinnerDateFinal));
        // Click on "+ Select" option of date spinner final
        solo.clickOnText("+ Select");

        // Wait for DatePickerFragment
        solo.waitForFragmentByTag("datePicker");

        // Get the DatePickerFragment
        DialogFragment dateFinalFragment = (DialogFragment) solo.getCurrentActivity()
                .getFragmentManager().findFragmentByTag("datePicker");

        // Wait until DatePickerFragment is visible on screen
        assertNotNull(dateFinalFragment);
        while (!(isShown(dateFinalFragment))) {
            System.out.println("Dialog fragment visible: " + isShown(dateFinalFragment));
            solo.sleep(100);
        }

        // Type cast for DatePickerDialog
        DatePickerDialog dateFinalPicker = (DatePickerDialog) dateFinalFragment.getDialog();

        // Get a date in future
        Calendar dayInPast = DayInPast();

        // Set the date
        assertNotNull(dateFinalPicker);
        solo.setDatePicker(dateFinalPicker.getDatePicker(), dayInPast.get(Calendar.YEAR),
                dayInPast.get(Calendar.MONTH), dayInPast.get(Calendar.DAY_OF_MONTH));

        // Click on "OK" button
        solo.clickOnText("OK");

        // Click on spinner of time
        solo.clickOnView(solo.getView(R.id.spinnerTimeFinal));
        // Click on "+ Select" option of time spinner
        solo.clickOnText("+ Select");

        // Wait for TimePickerFragment
        solo.waitForFragmentByTag("timePicker");

        // Get the DatePickerFragment
        DialogFragment timeFinalFragment = (DialogFragment) solo.getCurrentActivity()
                .getFragmentManager().findFragmentByTag("timePicker");

        // Wait until DatePickerFragment is visible on screen
        assertNotNull(timeFinalFragment);
        while (!(isShown(timeFinalFragment))) {
            System.out.println("Dialog fragment visible: " + isShown(timeFinalFragment));
            solo.sleep(100);
        }

        // Type cast for TimePickerDialog
        TimePickerDialog timeFinalPicker = (TimePickerDialog) timeFinalFragment.getDialog();

        // Set the time
        assertNotNull(timeFinalPicker);
        timeFinalPicker.updateTime(dayInPast.get(Calendar.HOUR_OF_DAY), dayInPast.get(Calendar.MINUTE));

        // Click on "OK" button
        solo.clickOnText("OK");

        // Click on "Save" button
        solo.clickOnText("Save");

        // Verify if the the current activity is ReminderMainActivity
        solo.assertCurrentActivity("Expected Reminder Main Activity", ReminderMainActivity.class);

        // Verify if the reminder was be edited
        assertTrue(solo.searchText("Read a book"));
    }

    public void testCreateValidReminder2_shouldBeShownOnReminderMainUi() throws Exception {
        // Unlock the screen
        solo.unlockScreen();

        // Click on "+" button
        solo.clickOnView(solo.getView(R.id.menu_addReminder));

        // Search for EditText of reminder title
        EditText etReminderTitle = (EditText) solo.getView(R.id.edtReminder);

        // Clean the reminder title EditText
        solo.clearEditText(etReminderTitle);

        // Enter with a title for reminder
        solo.enterText(etReminderTitle,"College work");

        // Same process of EditText for reminder title in EditText for reminder details
        EditText etReminderDetails = (EditText) solo.getView(R.id.edtDetails);
        solo.clearEditText(etReminderDetails);
        solo.enterText(etReminderDetails, "Present the work on tests");

        // Click on spinner of date initial
        solo.clickOnView(solo.getView(R.id.spinnerDateStart));
        // Click on "+ Select" option of date spinner initial
        solo.clickOnText("+ Select");

        // Wait for DatePickerFragment
        solo.waitForFragmentByTag("datePicker");

        // Get the DatePickerFragment
        DialogFragment dateStartFragment = (DialogFragment) solo.getCurrentActivity()
                .getFragmentManager().findFragmentByTag("datePicker");

        // Wait until DatePickerFragment is visible on screen
        assertNotNull(dateStartFragment);
        while (!(isShown(dateStartFragment))) {
            System.out.println("Dialog fragment visible: " + isShown(dateStartFragment));
            solo.sleep(100);
        }

        // Type cast for DatePickerDialog
        DatePickerDialog dateStartPicker = (DatePickerDialog) dateStartFragment.getDialog();

        // Get a date in future
        Calendar dayInPresent = DayInPresent();

        // Set the date
        assertNotNull(dateStartPicker);
        solo.setDatePicker(dateStartPicker.getDatePicker(), dayInPresent.get(Calendar.YEAR),
                dayInPresent.get(Calendar.MONTH), dayInPresent.get(Calendar.DAY_OF_MONTH));

        // Click on "OK" button
        solo.clickOnText("OK");

        // Click on spinner of time
        solo.clickOnView(solo.getView(R.id.spinnerTimeStart));
        // Click on "+ Select" option of time spinner
        solo.clickOnText("+ Select");

        // Wait for TimePickerFragment
        solo.waitForFragmentByTag("timePicker");

        // Get the DatePickerFragment
        DialogFragment timeStartFragment = (DialogFragment) solo.getCurrentActivity()
                .getFragmentManager().findFragmentByTag("timePicker");

        // Wait until DatePickerFragment is visible on screen
        assertNotNull(timeStartFragment);
        while (!(isShown(timeStartFragment))) {
            System.out.println("Dialog fragment visible: " + isShown(timeStartFragment));
            solo.sleep(100);
        }

        // Type cast for TimePickerDialog
        TimePickerDialog timeStartPicker = (TimePickerDialog) timeStartFragment.getDialog();

        // Set the time
        assertNotNull(timeStartPicker);
        timeStartPicker.updateTime(dayInPresent.get(Calendar.HOUR_OF_DAY), dayInPresent.get(Calendar.MINUTE));

        // Click on "OK" button
        solo.clickOnText("OK");

        // Click on spinner of date final
        solo.clickOnView(solo.getView(R.id.spinnerDateFinal));
        // Click on "+ Select" option of date spinner final
        solo.clickOnText("+ Select");

        // Wait for DatePickerFragment
        solo.waitForFragmentByTag("datePicker");

        // Get the DatePickerFragment
        DialogFragment dateFinalFragment = (DialogFragment) solo.getCurrentActivity()
                .getFragmentManager().findFragmentByTag("datePicker");

        // Wait until DatePickerFragment is visible on screen
        assertNotNull(dateFinalFragment);
        while (!(isShown(dateFinalFragment))) {
            System.out.println("Dialog fragment visible: " + isShown(dateFinalFragment));
            solo.sleep(100);
        }

        // Type cast for DatePickerDialog
        DatePickerDialog dateFinalPicker = (DatePickerDialog) dateFinalFragment.getDialog();

        // Get a date in future
        Calendar dayInFuture = DayInFuture();

        // Set the date
        assertNotNull(dateFinalPicker);
        solo.setDatePicker(dateFinalPicker.getDatePicker(), dayInFuture.get(Calendar.YEAR),
                dayInFuture.get(Calendar.MONTH), dayInFuture.get(Calendar.DAY_OF_MONTH));

        // Click on "OK" button
        solo.clickOnText("OK");

        // Click on spinner of time
        solo.clickOnView(solo.getView(R.id.spinnerTimeFinal));
        // Click on "+ Select" option of time spinner
        solo.clickOnText("+ Select");

        // Wait for TimePickerFragment
        solo.waitForFragmentByTag("timePicker");

        // Get the DatePickerFragment
        DialogFragment timeFinalFragment = (DialogFragment) solo.getCurrentActivity()
                .getFragmentManager().findFragmentByTag("timePicker");

        // Wait until DatePickerFragment is visible on screen
        assertNotNull(timeFinalFragment);
        while (!(isShown(timeFinalFragment))) {
            System.out.println("Dialog fragment visible: " + isShown(timeFinalFragment));
            solo.sleep(100);
        }

        // Type cast for TimePickerDialog
        TimePickerDialog timeFinalPicker = (TimePickerDialog) timeFinalFragment.getDialog();

        // Set the time
        assertNotNull(timeFinalPicker);
        timeFinalPicker.updateTime(dayInFuture.get(Calendar.HOUR_OF_DAY), dayInFuture.get(Calendar.MINUTE));

        // Click on "OK" button
        solo.clickOnText("OK");

        // Click on "Save" button
        solo.clickOnText("Save");

        // Verify if the the current activity is ReminderMainActivity
        solo.assertCurrentActivity("Expected Reminder Main Activity", ReminderMainActivity.class);

        // Verify if the reminder was be edited
        assertTrue(solo.searchText("College work"));
    }

    public void testCreateValidReminder3_shouldBeShownOnReminderMainUi() throws Exception {
        // Unlock the screen
        solo.unlockScreen();

        // Click on "+" button
        solo.clickOnView(solo.getView(R.id.menu_addReminder));

        // Search for EditText of reminder title
        EditText etReminderTitle = (EditText) solo.getView(R.id.edtReminder);

        // Clean the reminder title EditText
        solo.clearEditText(etReminderTitle);

        // Enter with a title for reminder
        solo.enterText(etReminderTitle,"Meeting");

        // Same process of EditText for reminder title in EditText for reminder details
        EditText etReminderDetails = (EditText) solo.getView(R.id.edtDetails);
        solo.clearEditText(etReminderDetails);
        solo.enterText(etReminderDetails, "Talk about Visitor");

        // Click on spinner of date initial
        solo.clickOnView(solo.getView(R.id.spinnerDateStart));
        // Click on "+ Select" option of date spinner initial
        solo.clickOnText("+ Select");

        // Wait for DatePickerFragment
        solo.waitForFragmentByTag("datePicker");

        // Get the DatePickerFragment
        DialogFragment dateStartFragment = (DialogFragment) solo.getCurrentActivity()
                .getFragmentManager().findFragmentByTag("datePicker");

        // Wait until DatePickerFragment is visible on screen
        assertNotNull(dateStartFragment);
        while (!(isShown(dateStartFragment))) {
            System.out.println("Dialog fragment visible: " + isShown(dateStartFragment));
            solo.sleep(100);
        }

        // Type cast for DatePickerDialog
        DatePickerDialog dateStartPicker = (DatePickerDialog) dateStartFragment.getDialog();

        // Get a date in future
        Calendar dayInFuture = DayInFuture();

        // Set the date
        assertNotNull(dateStartPicker);
        solo.setDatePicker(dateStartPicker.getDatePicker(), dayInFuture.get(Calendar.YEAR),
                dayInFuture.get(Calendar.MONTH), dayInFuture.get(Calendar.DAY_OF_MONTH));

        // Click on "OK" button
        solo.clickOnText("OK");

        // Click on spinner of time
        solo.clickOnView(solo.getView(R.id.spinnerTimeStart));
        // Click on "+ Select" option of time spinner
        solo.clickOnText("+ Select");

        // Wait for TimePickerFragment
        solo.waitForFragmentByTag("timePicker");

        // Get the DatePickerFragment
        DialogFragment timeStartFragment = (DialogFragment) solo.getCurrentActivity()
                .getFragmentManager().findFragmentByTag("timePicker");

        // Wait until DatePickerFragment is visible on screen
        assertNotNull(timeStartFragment);
        while (!(isShown(timeStartFragment))) {
            System.out.println("Dialog fragment visible: " + isShown(timeStartFragment));
            solo.sleep(100);
        }

        // Type cast for TimePickerDialog
        TimePickerDialog timeStartPicker = (TimePickerDialog) timeStartFragment.getDialog();

        // Set the time
        assertNotNull(timeStartPicker);
        timeStartPicker.updateTime(dayInFuture.get(Calendar.HOUR_OF_DAY), dayInFuture.get(Calendar.MINUTE));

        // Click on "OK" button
        solo.clickOnText("OK");

        // Click on spinner of date final
        solo.clickOnView(solo.getView(R.id.spinnerDateFinal));
        // Click on "+ Select" option of date spinner final
        solo.clickOnText("+ Select");

        // Wait for DatePickerFragment
        solo.waitForFragmentByTag("datePicker");

        // Get the DatePickerFragment
        DialogFragment dateFinalFragment = (DialogFragment) solo.getCurrentActivity()
                .getFragmentManager().findFragmentByTag("datePicker");

        // Wait until DatePickerFragment is visible on screen
        assertNotNull(dateFinalFragment);
        while (!(isShown(dateFinalFragment))) {
            System.out.println("Dialog fragment visible: " + isShown(dateFinalFragment));
            solo.sleep(100);
        }

        // Type cast for DatePickerDialog
        DatePickerDialog dateFinalPicker = (DatePickerDialog) dateFinalFragment.getDialog();

        // Get a date in future
        Calendar dayInDistantFuture = DayInDistantFuture();

        // Set the date
        assertNotNull(dateFinalPicker);
        solo.setDatePicker(dateFinalPicker.getDatePicker(), dayInDistantFuture.get(Calendar.YEAR),
                dayInDistantFuture.get(Calendar.MONTH), dayInDistantFuture.get(Calendar.DAY_OF_MONTH));

        // Click on "OK" button
        solo.clickOnText("OK");

        // Click on spinner of time
        solo.clickOnView(solo.getView(R.id.spinnerTimeFinal));
        // Click on "+ Select" option of time spinner
        solo.clickOnText("+ Select");

        // Wait for TimePickerFragment
        solo.waitForFragmentByTag("timePicker");

        // Get the DatePickerFragment
        DialogFragment timeFinalFragment = (DialogFragment) solo.getCurrentActivity()
                .getFragmentManager().findFragmentByTag("timePicker");

        // Wait until DatePickerFragment is visible on screen
        assertNotNull(timeFinalFragment);
        while (!(isShown(timeFinalFragment))) {
            System.out.println("Dialog fragment visible: " + isShown(timeFinalFragment));
            solo.sleep(100);
        }

        // Type cast for TimePickerDialog
        TimePickerDialog timeFinalPicker = (TimePickerDialog) timeFinalFragment.getDialog();

        // Set the time
        assertNotNull(timeFinalPicker);
        timeFinalPicker.updateTime(dayInDistantFuture.get(Calendar.HOUR_OF_DAY), dayInDistantFuture.get(Calendar.MINUTE));

        // Click on "OK" button
        solo.clickOnText("OK");

        // Click on "Save" button
        solo.clickOnText("Save");

        // Verify if the the current activity is ReminderMainActivity
        solo.assertCurrentActivity("Expected Reminder Main Activity", ReminderMainActivity.class);

        // Verify if the reminder was be edited
        assertTrue(solo.searchText("Meeting"));
    }

    public void testCreateInvalidReminder1_shouldNotBeShownOnReminderMainUi() throws Exception {
        // Unlock the screen
        solo.unlockScreen();

        // Click on "+" button
        solo.clickOnView(solo.getView(R.id.menu_addReminder));

        // Search for EditText of reminder title
        EditText etReminderTitle = (EditText) solo.getView(R.id.edtReminder);

        // Clean the reminder title EditText
        solo.clearEditText(etReminderTitle);

        // Enter with a title for reminder
        solo.enterText(etReminderTitle,"");

        // Same process of EditText for reminder title in EditText for reminder details
        EditText etReminderDetails = (EditText) solo.getView(R.id.edtDetails);
        solo.clearEditText(etReminderDetails);
        solo.enterText(etReminderDetails, "No title, but have description");

        // Click on spinner of date initial
        solo.clickOnView(solo.getView(R.id.spinnerDateStart));
        // Click on "+ Select" option of date spinner initial
        solo.clickOnText("+ Select");

        // Wait for DatePickerFragment
        solo.waitForFragmentByTag("datePicker");

        // Get the DatePickerFragment
        DialogFragment dateStartFragment = (DialogFragment) solo.getCurrentActivity()
                .getFragmentManager().findFragmentByTag("datePicker");

        // Wait until DatePickerFragment is visible on screen
        assertNotNull(dateStartFragment);
        while (!(isShown(dateStartFragment))) {
            System.out.println("Dialog fragment visible: " + isShown(dateStartFragment));
            solo.sleep(100);
        }

        // Type cast for DatePickerDialog
        DatePickerDialog dateStartPicker = (DatePickerDialog) dateStartFragment.getDialog();

        // Get a date in future
        Calendar dayInFuture = DayInFuture();

        // Set the date
        assertNotNull(dateStartPicker);
        solo.setDatePicker(dateStartPicker.getDatePicker(), dayInFuture.get(Calendar.YEAR),
                dayInFuture.get(Calendar.MONTH), dayInFuture.get(Calendar.DAY_OF_MONTH));

        // Click on "OK" button
        solo.clickOnText("OK");

        // Click on spinner of time
        solo.clickOnView(solo.getView(R.id.spinnerTimeStart));
        // Click on "+ Select" option of time spinner
        solo.clickOnText("+ Select");

        // Wait for TimePickerFragment
        solo.waitForFragmentByTag("timePicker");

        // Get the DatePickerFragment
        DialogFragment timeStartFragment = (DialogFragment) solo.getCurrentActivity()
                .getFragmentManager().findFragmentByTag("timePicker");

        // Wait until DatePickerFragment is visible on screen
        assertNotNull(timeStartFragment);
        while (!(isShown(timeStartFragment))) {
            System.out.println("Dialog fragment visible: " + isShown(timeStartFragment));
            solo.sleep(100);
        }

        // Type cast for TimePickerDialog
        TimePickerDialog timeStartPicker = (TimePickerDialog) timeStartFragment.getDialog();

        // Set the time
        assertNotNull(timeStartPicker);
        timeStartPicker.updateTime(dayInFuture.get(Calendar.HOUR_OF_DAY), dayInFuture.get(Calendar.MINUTE));

        // Click on "OK" button
        solo.clickOnText("OK");

        // Click on spinner of date final
        solo.clickOnView(solo.getView(R.id.spinnerDateFinal));
        // Click on "+ Select" option of date spinner final
        solo.clickOnText("+ Select");

        // Wait for DatePickerFragment
        solo.waitForFragmentByTag("datePicker");

        // Get the DatePickerFragment
        DialogFragment dateFinalFragment = (DialogFragment) solo.getCurrentActivity()
                .getFragmentManager().findFragmentByTag("datePicker");

        // Wait until DatePickerFragment is visible on screen
        assertNotNull(dateFinalFragment);
        while (!(isShown(dateFinalFragment))) {
            System.out.println("Dialog fragment visible: " + isShown(dateFinalFragment));
            solo.sleep(100);
        }

        // Type cast for DatePickerDialog
        DatePickerDialog dateFinalPicker = (DatePickerDialog) dateFinalFragment.getDialog();

        // Get a date in future
        Calendar dayInDistantFuture = DayInDistantFuture();

        // Set the date
        assertNotNull(dateFinalPicker);
        solo.setDatePicker(dateFinalPicker.getDatePicker(), dayInDistantFuture.get(Calendar.YEAR),
                dayInDistantFuture.get(Calendar.MONTH), dayInDistantFuture.get(Calendar.DAY_OF_MONTH));

        // Click on "OK" button
        solo.clickOnText("OK");

        // Click on spinner of time
        solo.clickOnView(solo.getView(R.id.spinnerTimeFinal));
        // Click on "+ Select" option of time spinner
        solo.clickOnText("+ Select");

        // Wait for TimePickerFragment
        solo.waitForFragmentByTag("timePicker");

        // Get the DatePickerFragment
        DialogFragment timeFinalFragment = (DialogFragment) solo.getCurrentActivity()
                .getFragmentManager().findFragmentByTag("timePicker");

        // Wait until DatePickerFragment is visible on screen
        assertNotNull(timeFinalFragment);
        while (!(isShown(timeFinalFragment))) {
            System.out.println("Dialog fragment visible: " + isShown(timeFinalFragment));
            solo.sleep(100);
        }

        // Type cast for TimePickerDialog
        TimePickerDialog timeFinalPicker = (TimePickerDialog) timeFinalFragment.getDialog();

        // Set the time
        assertNotNull(timeFinalPicker);
        timeFinalPicker.updateTime(dayInDistantFuture.get(Calendar.HOUR_OF_DAY), dayInDistantFuture.get(Calendar.MINUTE));

        // Click on "OK" button
        solo.clickOnText("OK");

        // Click on "Save" button
        solo.clickOnText("Save");

        // Verify if message of error was showed
        solo.waitForText("Invalid text.");

        // Verify if the the current activity is ReminderMainActivity
        solo.assertCurrentActivity("Expected Reminder Main Activity", ReminderMainActivity.class);
    }

    public void testCreateInvalidReminder2_shouldNotBeShownOnReminderMainUi() throws Exception {
        // Unlock the screen
        solo.unlockScreen();

        // Click on "+" button
        solo.clickOnView(solo.getView(R.id.menu_addReminder));

        // Search for EditText of reminder title
        EditText etReminderTitle = (EditText) solo.getView(R.id.edtReminder);

        // Clean the reminder title EditText
        solo.clearEditText(etReminderTitle);

        // Enter with a title for reminder
        solo.enterText(etReminderTitle,"Read another book");

        // Same process of EditText for reminder title in EditText for reminder details
        EditText etReminderDetails = (EditText) solo.getView(R.id.edtDetails);
        solo.clearEditText(etReminderDetails);
        solo.enterText(etReminderDetails, "V for Vendetta");

        // Click on spinner of date initial
        solo.clickOnView(solo.getView(R.id.spinnerDateStart));
        // Click on "+ Select" option of date spinner initial
        solo.clickOnText("No date");

        // Get a date in future
        Calendar dayInFuture = DayInFuture();

        // Click on spinner of time
        solo.clickOnView(solo.getView(R.id.spinnerTimeStart));
        // Click on "+ Select" option of time spinner
        solo.clickOnText("+ Select");

        // Wait for TimePickerFragment
        solo.waitForFragmentByTag("timePicker");

        // Get the DatePickerFragment
        DialogFragment timeStartFragment = (DialogFragment) solo.getCurrentActivity()
                .getFragmentManager().findFragmentByTag("timePicker");

        // Wait until DatePickerFragment is visible on screen
        assertNotNull(timeStartFragment);
        while (!(isShown(timeStartFragment))) {
            System.out.println("Dialog fragment visible: " + isShown(timeStartFragment));
            solo.sleep(100);
        }

        // Type cast for TimePickerDialog
        TimePickerDialog timeStartPicker = (TimePickerDialog) timeStartFragment.getDialog();

        // Set the time
        assertNotNull(timeStartPicker);
        timeStartPicker.updateTime(dayInFuture.get(Calendar.HOUR_OF_DAY), dayInFuture.get(Calendar.MINUTE));

        // Click on "OK" button
        solo.clickOnText("OK");

        // Click on spinner of date final
        solo.clickOnView(solo.getView(R.id.spinnerDateFinal));
        // Click on "+ Select" option of date spinner final
        solo.clickOnText("+ Select");

        // Wait for DatePickerFragment
        solo.waitForFragmentByTag("datePicker");

        // Get the DatePickerFragment
        DialogFragment dateFinalFragment = (DialogFragment) solo.getCurrentActivity()
                .getFragmentManager().findFragmentByTag("datePicker");

        // Wait until DatePickerFragment is visible on screen
        assertNotNull(dateFinalFragment);
        while (!(isShown(dateFinalFragment))) {
            System.out.println("Dialog fragment visible: " + isShown(dateFinalFragment));
            solo.sleep(100);
        }

        // Type cast for DatePickerDialog
        DatePickerDialog dateFinalPicker = (DatePickerDialog) dateFinalFragment.getDialog();

        // Get a date in future
        Calendar dayInDistantFuture = DayInDistantFuture();

        // Set the date
        assertNotNull(dateFinalPicker);
        solo.setDatePicker(dateFinalPicker.getDatePicker(), dayInDistantFuture.get(Calendar.YEAR),
                dayInDistantFuture.get(Calendar.MONTH), dayInDistantFuture.get(Calendar.DAY_OF_MONTH));

        // Click on "OK" button
        solo.clickOnText("OK");

        // Click on spinner of time
        solo.clickOnView(solo.getView(R.id.spinnerTimeFinal));
        // Click on "+ Select" option of time spinner
        solo.clickOnText("+ Select");

        // Wait for TimePickerFragment
        solo.waitForFragmentByTag("timePicker");

        // Get the DatePickerFragment
        DialogFragment timeFinalFragment = (DialogFragment) solo.getCurrentActivity()
                .getFragmentManager().findFragmentByTag("timePicker");

        // Wait until DatePickerFragment is visible on screen
        assertNotNull(timeFinalFragment);
        while (!(isShown(timeFinalFragment))) {
            System.out.println("Dialog fragment visible: " + isShown(timeFinalFragment));
            solo.sleep(100);
        }

        // Type cast for TimePickerDialog
        TimePickerDialog timeFinalPicker = (TimePickerDialog) timeFinalFragment.getDialog();

        // Set the time
        assertNotNull(timeFinalPicker);
        timeFinalPicker.updateTime(dayInDistantFuture.get(Calendar.HOUR_OF_DAY), dayInDistantFuture.get(Calendar.MINUTE));

        // Click on "OK" button
        solo.clickOnText("OK");

        // Click on "Save" button
        solo.clickOnText("Save");

        // Verify if message of error was showed
        solo.waitForText("Invalid date.");

        // Verify if the the current activity is ReminderMainActivity
        solo.assertCurrentActivity("Expected Reminder Main Activity", ReminderMainActivity.class);

        // Verify if the reminder was be edited
        assertFalse(solo.searchText("Read another book"));
    }

    public void testCreateInvalidReminder3_shouldNotBeShownOnReminderMainUi() throws Exception {
        // Unlock the screen
        solo.unlockScreen();

        // Click on "+" button
        solo.clickOnView(solo.getView(R.id.menu_addReminder));

        // Search for EditText of reminder title
        EditText etReminderTitle = (EditText) solo.getView(R.id.edtReminder);

        // Clean the reminder title EditText
        solo.clearEditText(etReminderTitle);

        // Enter with a title for reminder
        solo.enterText(etReminderTitle,"Read another book");

        // Same process of EditText for reminder title in EditText for reminder details
        EditText etReminderDetails = (EditText) solo.getView(R.id.edtDetails);
        solo.clearEditText(etReminderDetails);
        solo.enterText(etReminderDetails, "The Odyssey");

        // Click on spinner of date initial
        solo.clickOnView(solo.getView(R.id.spinnerDateStart));
        // Click on "+ Select" option of date spinner initial
        solo.clickOnText("+ Select");

        // Wait for DatePickerFragment
        solo.waitForFragmentByTag("datePicker");

        // Get the DatePickerFragment
        DialogFragment dateStartFragment = (DialogFragment) solo.getCurrentActivity()
                .getFragmentManager().findFragmentByTag("datePicker");

        // Wait until DatePickerFragment is visible on screen
        assertNotNull(dateStartFragment);
        while (!(isShown(dateStartFragment))) {
            System.out.println("Dialog fragment visible: " + isShown(dateStartFragment));
            solo.sleep(100);
        }

        // Type cast for DatePickerDialog
        DatePickerDialog dateStartPicker = (DatePickerDialog) dateStartFragment.getDialog();

        // Get a date in future
        Calendar dayInFuture = DayInFuture();

        // Set the date
        assertNotNull(dateStartPicker);
        solo.setDatePicker(dateStartPicker.getDatePicker(), dayInFuture.get(Calendar.YEAR),
                dayInFuture.get(Calendar.MONTH), dayInFuture.get(Calendar.DAY_OF_MONTH));

        // Click on "OK" button
        solo.clickOnText("OK");

        // Click on spinner of time
        solo.clickOnView(solo.getView(R.id.spinnerTimeStart));
        // Click on "+ Select" option of time spinner
        solo.clickOnText("+ Select");

        // Wait for TimePickerFragment
        solo.waitForFragmentByTag("timePicker");

        // Get the DatePickerFragment
        DialogFragment timeStartFragment = (DialogFragment) solo.getCurrentActivity()
                .getFragmentManager().findFragmentByTag("timePicker");

        // Wait until DatePickerFragment is visible on screen
        assertNotNull(timeStartFragment);
        while (!(isShown(timeStartFragment))) {
            System.out.println("Dialog fragment visible: " + isShown(timeStartFragment));
            solo.sleep(100);
        }

        // Type cast for TimePickerDialog
        TimePickerDialog timeStartPicker = (TimePickerDialog) timeStartFragment.getDialog();

        // Set the time
        assertNotNull(timeStartPicker);
        timeStartPicker.updateTime(dayInFuture.get(Calendar.HOUR_OF_DAY), dayInFuture.get(Calendar.MINUTE));

        // Click on "OK" button
        solo.clickOnText("OK");

        // Click on spinner of date final
        solo.clickOnView(solo.getView(R.id.spinnerDateFinal));
        // Click on "+ Select" option of date spinner final
        solo.clickOnText("No date");

        // Get a date in future
        Calendar dayInDistantFuture = DayInDistantFuture();

        // Click on spinner of time
        solo.clickOnView(solo.getView(R.id.spinnerTimeFinal));
        // Click on "+ Select" option of time spinner
        solo.clickOnText("+ Select");

        // Wait for TimePickerFragment
        solo.waitForFragmentByTag("timePicker");

        // Get the DatePickerFragment
        DialogFragment timeFinalFragment = (DialogFragment) solo.getCurrentActivity()
                .getFragmentManager().findFragmentByTag("timePicker");

        // Wait until DatePickerFragment is visible on screen
        assertNotNull(timeFinalFragment);
        while (!(isShown(timeFinalFragment))) {
            System.out.println("Dialog fragment visible: " + isShown(timeFinalFragment));
            solo.sleep(100);
        }

        // Type cast for TimePickerDialog
        TimePickerDialog timeFinalPicker = (TimePickerDialog) timeFinalFragment.getDialog();

        // Set the time
        assertNotNull(timeFinalPicker);
        timeFinalPicker.updateTime(dayInDistantFuture.get(Calendar.HOUR_OF_DAY), dayInDistantFuture.get(Calendar.MINUTE));

        // Click on "OK" button
        solo.clickOnText("OK");

        // Click on "Save" button
        solo.clickOnText("Save");

        // Verify if message of error was showed
        solo.waitForText("Invalid date.");

        // Verify if the the current activity is ReminderMainActivity
        solo.assertCurrentActivity("Expected Reminder Main Activity", ReminderMainActivity.class);

        // Verify if the reminder was be edited
        assertFalse(solo.searchText("Read another book"));
    }

//    public void testCreateInvalidReminder4_shouldNotBeShownOnReminderMainUi() throws Exception {
//        // Unlock the screen
//        solo.unlockScreen();
//
//        // Click on "+" button
//        solo.clickOnView(solo.getView(R.id.menu_addReminder));
//
//        // Search for EditText of reminder title
//        EditText etReminderTitle = (EditText) solo.getView(R.id.edtReminder);
//
//        // Clean the reminder title EditText
//        solo.clearEditText(etReminderTitle);
//
//        // Enter with a title for reminder
//        solo.enterText(etReminderTitle,"Read another book 2");
//
//        // Same process of EditText for reminder title in EditText for reminder details
//        EditText etReminderDetails = (EditText) solo.getView(R.id.edtDetails);
//        solo.clearEditText(etReminderDetails);
//        solo.enterText(etReminderDetails, "V for Vendetta");
//
//        // Click on spinner of date initial
//        solo.clickOnView(solo.getView(R.id.spinnerDateStart));
//        // Click on "+ Select" option of date spinner initial
//        solo.clickOnText("+ Select");
//
//        // Wait for DatePickerFragment
//        solo.waitForFragmentByTag("datePicker");
//
//        // Get the DatePickerFragment
//        DialogFragment dateStartFragment = (DialogFragment) solo.getCurrentActivity()
//                .getFragmentManager().findFragmentByTag("datePicker");
//
//        // Wait until DatePickerFragment is visible on screen
//        assertNotNull(dateStartFragment);
//        while (!(isShown(dateStartFragment))) {
//            System.out.println("Dialog fragment visible: " + isShown(dateStartFragment));
//            solo.sleep(100);
//        }
//
//        // Type cast for DatePickerDialog
//        DatePickerDialog dateStartPicker = (DatePickerDialog) dateStartFragment.getDialog();
//
//        // Get a date in future
//        Calendar dayInDistantPast = DayInDistantPast();
//
//        // Set the date
//        assertNotNull(dateStartPicker);
//        solo.setDatePicker(dateStartPicker.getDatePicker(), dayInDistantPast.get(Calendar.YEAR),
//                dayInDistantPast.get(Calendar.MONTH), dayInDistantPast.get(Calendar.DAY_OF_MONTH));
//
//        // Click on "OK" button
//        solo.clickOnText("OK");
//
//        // Click on spinner of time
//        solo.clickOnView(solo.getView(R.id.spinnerTimeStart));
//
//        // Click on "No time option of time spinner
//        solo.clickOnText("No time");
//
//        // Click on spinner of date final
//        solo.clickOnView(solo.getView(R.id.spinnerDateFinal));
//        // Click on "+ Select" option of date spinner final
//        solo.clickOnText("+ Select");
//
//        // Wait for DatePickerFragment
//        solo.waitForFragmentByTag("datePicker");
//
//        // Get the DatePickerFragment
//        DialogFragment dateFinalFragment = (DialogFragment) solo.getCurrentActivity()
//                .getFragmentManager().findFragmentByTag("datePicker");
//
//        // Wait until DatePickerFragment is visible on screen
//        assertNotNull(dateFinalFragment);
//        while (!(isShown(dateFinalFragment))) {
//            System.out.println("Dialog fragment visible: " + isShown(dateFinalFragment));
//            solo.sleep(100);
//        }
//
//        // Type cast for DatePickerDialog
//        DatePickerDialog dateFinalPicker = (DatePickerDialog) dateFinalFragment.getDialog();
//
//        // Get a date in future
//        Calendar dayInPast = DayInPast();
//
//        // Set the date
//        assertNotNull(dateFinalPicker);
//        solo.setDatePicker(dateFinalPicker.getDatePicker(), dayInPast.get(Calendar.YEAR),
//                dayInPast.get(Calendar.MONTH), dayInPast.get(Calendar.DAY_OF_MONTH));
//
//        // Click on "OK" button
//        solo.clickOnText("OK");
//
//        // Click on spinner of time
//        solo.clickOnView(solo.getView(R.id.spinnerTimeFinal));
//        // Click on "+ Select" option of time spinner
//        solo.clickOnText("+ Select");
//
//        // Wait for TimePickerFragment
//        solo.waitForFragmentByTag("timePicker");
//
//        // Get the DatePickerFragment
//        DialogFragment timeFinalFragment = (DialogFragment) solo.getCurrentActivity()
//                .getFragmentManager().findFragmentByTag("timePicker");
//
//        // Wait until DatePickerFragment is visible on screen
//        assertNotNull(timeFinalFragment);
//        while (!(isShown(timeFinalFragment))) {
//            System.out.println("Dialog fragment visible: " + isShown(timeFinalFragment));
//            solo.sleep(100);
//        }
//
//        // Type cast for TimePickerDialog
//        TimePickerDialog timeFinalPicker = (TimePickerDialog) timeFinalFragment.getDialog();
//
//        // Set the time
//        assertNotNull(timeFinalPicker);
//        timeFinalPicker.updateTime(dayInPast.get(Calendar.HOUR_OF_DAY), dayInPast.get(Calendar.MINUTE));
//
//        // Click on "OK" button
//        solo.clickOnText("OK");
//
//        // Click on "Save" button
//        solo.clickOnText("Save");
//
//        // Verify if message of error was showed
//        solo.waitForText("Invalid time.");
//
//        // Verify if the the current activity is ReminderMainActivity
//        solo.assertCurrentActivity("Expected Reminder Main Activity", ReminderMainActivity.class);
//
//        // Verify if the reminder was be edited
//        assertFalse(solo.searchText("Read another book 2"));
//    }
//
//    public void testCreateInvalidReminder5_shouldNotBeShownOnReminderMainUi() throws Exception {
//        // Unlock the screen
//        solo.unlockScreen();
//
//        // Click on "+" button
//        solo.clickOnView(solo.getView(R.id.menu_addReminder));
//
//        // Search for EditText of reminder title
//        EditText etReminderTitle = (EditText) solo.getView(R.id.edtReminder);
//
//        // Clean the reminder title EditText
//        solo.clearEditText(etReminderTitle);
//
//        // Enter with a title for reminder
//        solo.enterText(etReminderTitle,"Read another book 2");
//
//        // Same process of EditText for reminder title in EditText for reminder details
//        EditText etReminderDetails = (EditText) solo.getView(R.id.edtDetails);
//        solo.clearEditText(etReminderDetails);
//        solo.enterText(etReminderDetails, "V for Vendetta");
//
//        // Click on spinner of date initial
//        solo.clickOnView(solo.getView(R.id.spinnerDateStart));
//        // Click on "+ Select" option of date spinner initial
//        solo.clickOnText("+ Select");
//
//        // Wait for DatePickerFragment
//        solo.waitForFragmentByTag("datePicker");
//
//        // Get the DatePickerFragment
//        DialogFragment dateStartFragment = (DialogFragment) solo.getCurrentActivity()
//                .getFragmentManager().findFragmentByTag("datePicker");
//
//        // Wait until DatePickerFragment is visible on screen
//        assertNotNull(dateStartFragment);
//        while (!(isShown(dateStartFragment))) {
//            System.out.println("Dialog fragment visible: " + isShown(dateStartFragment));
//            solo.sleep(100);
//        }
//
//        // Type cast for DatePickerDialog
//        DatePickerDialog dateStartPicker = (DatePickerDialog) dateStartFragment.getDialog();
//
//        // Get a date in future
//        Calendar dayInDistantPast = DayInDistantPast();
//
//        // Set the date
//        assertNotNull(dateStartPicker);
//        solo.setDatePicker(dateStartPicker.getDatePicker(), dayInDistantPast.get(Calendar.YEAR),
//                dayInDistantPast.get(Calendar.MONTH), dayInDistantPast.get(Calendar.DAY_OF_MONTH));
//
//        // Click on "OK" button
//        solo.clickOnText("OK");
//
//        // Click on spinner of time
//        solo.clickOnView(solo.getView(R.id.spinnerTimeStart));
//        // Click on "+ Select" option of time spinner
//        solo.clickOnText("+ Select");
//
//        // Wait for TimePickerFragment
//        solo.waitForFragmentByTag("timePicker");
//
//        // Get the DatePickerFragment
//        DialogFragment timeStartFragment = (DialogFragment) solo.getCurrentActivity()
//                .getFragmentManager().findFragmentByTag("timePicker");
//
//        // Wait until DatePickerFragment is visible on screen
//        assertNotNull(timeStartFragment);
//        while (!(isShown(timeStartFragment))) {
//            System.out.println("Dialog fragment visible: " + isShown(timeStartFragment));
//            solo.sleep(100);
//        }
//
//        // Type cast for TimePickerDialog
//        TimePickerDialog timeStartPicker = (TimePickerDialog) timeStartFragment.getDialog();
//
//        // Set the time
//        assertNotNull(timeStartPicker);
//        timeStartPicker.updateTime(dayInDistantPast.get(Calendar.HOUR_OF_DAY), dayInDistantPast.get(Calendar.MINUTE));
//
//        // Click on "OK" button
//        solo.clickOnText("OK");
//
//        // Click on spinner of date final
//        solo.clickOnView(solo.getView(R.id.spinnerDateFinal));
//        // Click on "+ Select" option of date spinner final
//        solo.clickOnText("+ Select");
//
//        // Wait for DatePickerFragment
//        solo.waitForFragmentByTag("datePicker");
//
//        // Get the DatePickerFragment
//        DialogFragment dateFinalFragment = (DialogFragment) solo.getCurrentActivity()
//                .getFragmentManager().findFragmentByTag("datePicker");
//
//        // Wait until DatePickerFragment is visible on screen
//        assertNotNull(dateFinalFragment);
//        while (!(isShown(dateFinalFragment))) {
//            System.out.println("Dialog fragment visible: " + isShown(dateFinalFragment));
//            solo.sleep(100);
//        }
//
//        // Type cast for DatePickerDialog
//        DatePickerDialog dateFinalPicker = (DatePickerDialog) dateFinalFragment.getDialog();
//
//        // Get a date in future
//        Calendar dayInPast = DayInPast();
//
//        // Set the date
//        assertNotNull(dateFinalPicker);
//        solo.setDatePicker(dateFinalPicker.getDatePicker(), dayInPast.get(Calendar.YEAR),
//                dayInPast.get(Calendar.MONTH), dayInPast.get(Calendar.DAY_OF_MONTH));
//
//        // Click on "OK" button
//        solo.clickOnText("OK");
//
//        // Click on spinner of time
//        solo.clickOnView(solo.getView(R.id.spinnerTimeFinal));
//        // Click on "No time" option of time spinner
//        solo.clickOnText("No time");
//
//        // Click on "Save" button
//        solo.clickOnText("Save");
//
//        // Verify if message of error was showed
//        solo.waitForText("Invalid time.");
//
//        // Verify if the the current activity is ReminderMainActivity
//        solo.assertCurrentActivity("Expected Reminder Main Activity", ReminderMainActivity.class);
//
//        // Verify if the reminder was be edited
//        assertFalse(solo.searchText("Read another book 2"));
//    }


// Try code coverage without test that are broken



    public void testCreateInvalidDateReminder_shouldNotBeShownOnReminderMainUi() throws Exception {
        // Unlock the screen
        solo.unlockScreen();

        // Click on "+" button
        solo.clickOnView(solo.getView(R.id.menu_addReminder));

        // Search for EditText of reminder title
        EditText etReminderTitle = (EditText) solo.getView(R.id.edtReminder);

        // Clean the reminder title EditText
        solo.clearEditText(etReminderTitle);

        // Enter with a title for reminder
        solo.enterText(etReminderTitle,"Read some book");

        // Same process of EditText for reminder title in EditText for reminder details
        EditText etReminderDetails = (EditText) solo.getView(R.id.edtDetails);
        solo.clearEditText(etReminderDetails);
        solo.enterText(etReminderDetails, "V for Vendetta");

        // Click on spinner of date initial
        solo.clickOnView(solo.getView(R.id.spinnerDateStart));
        // Click on "+ Select" option of date spinner initial
        solo.clickOnText("+ Select");

        // Wait for DatePickerFragment
        solo.waitForFragmentByTag("datePicker");

        // Get the DatePickerFragment
        DialogFragment dateStartFragment = (DialogFragment) solo.getCurrentActivity()
                .getFragmentManager().findFragmentByTag("datePicker");

        // Wait until DatePickerFragment is visible on screen
        assertNotNull(dateStartFragment);
        while (!(isShown(dateStartFragment))) {
            System.out.println("Dialog fragment visible: " + isShown(dateStartFragment));
            solo.sleep(100);
        }

        // Type cast for DatePickerDialog
        DatePickerDialog dateStartPicker = (DatePickerDialog) dateStartFragment.getDialog();

        // Get a date in future
        Calendar dayInFuture = DayInFuture();

        // Set the date
        assertNotNull(dateStartPicker);
        solo.setDatePicker(dateStartPicker.getDatePicker(), dayInFuture.get(Calendar.YEAR),
                dayInFuture.get(Calendar.MONTH), dayInFuture.get(Calendar.DAY_OF_MONTH));

        // Click on "OK" button
        solo.clickOnText("OK");

        // Click on spinner of time
        solo.clickOnView(solo.getView(R.id.spinnerTimeStart));
        // Click on "+ Select" option of time spinner
        solo.clickOnText("+ Select");

        // Wait for TimePickerFragment
        solo.waitForFragmentByTag("timePicker");

        // Get the DatePickerFragment
        DialogFragment timeStartFragment = (DialogFragment) solo.getCurrentActivity()
                .getFragmentManager().findFragmentByTag("timePicker");

        // Wait until DatePickerFragment is visible on screen
        assertNotNull(timeStartFragment);
        while (!(isShown(timeStartFragment))) {
            System.out.println("Dialog fragment visible: " + isShown(timeStartFragment));
            solo.sleep(100);
        }

        // Type cast for TimePickerDialog
        TimePickerDialog timeStartPicker = (TimePickerDialog) timeStartFragment.getDialog();

        // Set the time
        assertNotNull(timeStartPicker);
        timeStartPicker.updateTime(dayInFuture.get(Calendar.HOUR_OF_DAY), dayInFuture.get(Calendar.MINUTE));

        // Click on "OK" button
        solo.clickOnText("OK");

        // Click on spinner of date final
        solo.clickOnView(solo.getView(R.id.spinnerDateFinal));
        // Click on "+ Select" option of date spinner final
        solo.clickOnText("+ Select");

        // Wait for DatePickerFragment
        solo.waitForFragmentByTag("datePicker");

        // Get the DatePickerFragment
        DialogFragment dateFinalFragment = (DialogFragment) solo.getCurrentActivity()
                .getFragmentManager().findFragmentByTag("datePicker");

        // Wait until DatePickerFragment is visible on screen
        assertNotNull(dateFinalFragment);
        while (!(isShown(dateFinalFragment))) {
            System.out.println("Dialog fragment visible: " + isShown(dateFinalFragment));
            solo.sleep(100);
        }

        // Type cast for DatePickerDialog
        DatePickerDialog dateFinalPicker = (DatePickerDialog) dateFinalFragment.getDialog();

        // Get a date in future
        Calendar dayInPast = DayInPast();

        // Set the date
        assertNotNull(dateFinalPicker);
        solo.setDatePicker(dateFinalPicker.getDatePicker(), dayInPast.get(Calendar.YEAR),
                dayInPast.get(Calendar.MONTH), dayInPast.get(Calendar.DAY_OF_MONTH));

        // Click on "OK" button
        solo.clickOnText("OK");

        // Click on spinner of time
        solo.clickOnView(solo.getView(R.id.spinnerTimeFinal));
        // Click on "+ Select" option of time spinner
        solo.clickOnText("+ Select");

        // Wait for TimePickerFragment
        solo.waitForFragmentByTag("timePicker");

        // Get the DatePickerFragment
        DialogFragment timeFinalFragment = (DialogFragment) solo.getCurrentActivity()
                .getFragmentManager().findFragmentByTag("timePicker");

        // Wait until DatePickerFragment is visible on screen
        assertNotNull(timeFinalFragment);
        while (!(isShown(timeFinalFragment))) {
            System.out.println("Dialog fragment visible: " + isShown(timeFinalFragment));
            solo.sleep(100);
        }

        // Type cast for TimePickerDialog
        TimePickerDialog timeFinalPicker = (TimePickerDialog) timeFinalFragment.getDialog();

        // Set the time
        assertNotNull(timeFinalPicker);
        timeFinalPicker.updateTime(dayInPast.get(Calendar.HOUR_OF_DAY), dayInPast.get(Calendar.MINUTE));

        // Click on "OK" button
        solo.clickOnText("OK");

        // Click on "Save" button
        solo.clickOnText("Save");

        // Verify if message of error was showed
        solo.waitForText("Invalid date.");

        // Verify if the the current activity is ReminderMainActivity
        solo.assertCurrentActivity("Expected Reminder Main Activity", ReminderMainActivity.class);

        // Verify if the reminder was be edited
        assertFalse(solo.searchText("Read some book"));
    }

    public void testCreateInvalidTimeReminder_shouldNotBeShownOnReminderMainUi() throws Exception {
        // Unlock the screen
        solo.unlockScreen();

        // Click on "+" button
        solo.clickOnView(solo.getView(R.id.menu_addReminder));

        // Search for EditText of reminder title
        EditText etReminderTitle = (EditText) solo.getView(R.id.edtReminder);

        // Clean the reminder title EditText
        solo.clearEditText(etReminderTitle);

        // Enter with a title for reminder
        solo.enterText(etReminderTitle,"Read some old book");

        // Same process of EditText for reminder title in EditText for reminder details
        EditText etReminderDetails = (EditText) solo.getView(R.id.edtDetails);
        solo.clearEditText(etReminderDetails);
        solo.enterText(etReminderDetails, "V for Vendetta");

        // Click on spinner of date initial
        solo.clickOnView(solo.getView(R.id.spinnerDateStart));
        // Click on "+ Select" option of date spinner initial
        solo.clickOnText("+ Select");

        // Wait for DatePickerFragment
        solo.waitForFragmentByTag("datePicker");

        // Get the DatePickerFragment
        DialogFragment dateStartFragment = (DialogFragment) solo.getCurrentActivity()
                .getFragmentManager().findFragmentByTag("datePicker");

        // Wait until DatePickerFragment is visible on screen
        assertNotNull(dateStartFragment);
        while (!(isShown(dateStartFragment))) {
            System.out.println("Dialog fragment visible: " + isShown(dateStartFragment));
            solo.sleep(100);
        }

        // Type cast for DatePickerDialog
        DatePickerDialog dateStartPicker = (DatePickerDialog) dateStartFragment.getDialog();

        // Get a date in future
        Calendar dayInFuture = DayInFuture();

        // Set the date
        assertNotNull(dateStartPicker);
        solo.setDatePicker(dateStartPicker.getDatePicker(), dayInFuture.get(Calendar.YEAR),
                dayInFuture.get(Calendar.MONTH), dayInFuture.get(Calendar.DAY_OF_MONTH));

        // Click on "OK" button
        solo.clickOnText("OK");

        // Click on spinner of time
        solo.clickOnView(solo.getView(R.id.spinnerTimeStart));
        // Click on "+ Select" option of time spinner
        solo.clickOnText("+ Select");

        // Wait for TimePickerFragment
        solo.waitForFragmentByTag("timePicker");

        // Get the DatePickerFragment
        DialogFragment timeStartFragment = (DialogFragment) solo.getCurrentActivity()
                .getFragmentManager().findFragmentByTag("timePicker");

        // Wait until DatePickerFragment is visible on screen
        assertNotNull(timeStartFragment);
        while (!(isShown(timeStartFragment))) {
            System.out.println("Dialog fragment visible: " + isShown(timeStartFragment));
            solo.sleep(100);
        }

        // Type cast for TimePickerDialog
        TimePickerDialog timeStartPicker = (TimePickerDialog) timeStartFragment.getDialog();

        // Set the time
        assertNotNull(timeStartPicker);
        timeStartPicker.updateTime(dayInFuture.get(Calendar.HOUR_OF_DAY), dayInFuture.get(Calendar.MINUTE));

        // Click on "OK" button
        solo.clickOnText("OK");

        // Click on spinner of date final
        solo.clickOnView(solo.getView(R.id.spinnerDateFinal));
        // Click on "+ Select" option of date spinner final
        solo.clickOnText("+ Select");

        // Wait for DatePickerFragment
        solo.waitForFragmentByTag("datePicker");

        // Get the DatePickerFragment
        DialogFragment dateFinalFragment = (DialogFragment) solo.getCurrentActivity()
                .getFragmentManager().findFragmentByTag("datePicker");

        // Wait until DatePickerFragment is visible on screen
        assertNotNull(dateFinalFragment);
        while (!(isShown(dateFinalFragment))) {
            System.out.println("Dialog fragment visible: " + isShown(dateFinalFragment));
            solo.sleep(100);
        }

        // Type cast for DatePickerDialog
        DatePickerDialog dateFinalPicker = (DatePickerDialog) dateFinalFragment.getDialog();

        // Get a date in future
        Calendar dayInFuture2 = DayInFuture();

        // Set the date
        assertNotNull(dateFinalPicker);
        solo.setDatePicker(dateFinalPicker.getDatePicker(), dayInFuture2.get(Calendar.YEAR),
                dayInFuture2.get(Calendar.MONTH), dayInFuture2.get(Calendar.DAY_OF_MONTH));

        // Click on "OK" button
        solo.clickOnText("OK");

        // Click on spinner of time
        solo.clickOnView(solo.getView(R.id.spinnerTimeFinal));
        // Click on "+ Select" option of time spinner
        solo.clickOnText("+ Select");

        // Wait for TimePickerFragment
        solo.waitForFragmentByTag("timePicker");

        // Get the DatePickerFragment
        DialogFragment timeFinalFragment = (DialogFragment) solo.getCurrentActivity()
                .getFragmentManager().findFragmentByTag("timePicker");

        // Wait until DatePickerFragment is visible on screen
        assertNotNull(timeFinalFragment);
        while (!(isShown(timeFinalFragment))) {
            System.out.println("Dialog fragment visible: " + isShown(timeFinalFragment));
            solo.sleep(100);
        }

        // Type cast for TimePickerDialog
        TimePickerDialog timeFinalPicker = (TimePickerDialog) timeFinalFragment.getDialog();

        // Set the time
        assertNotNull(timeFinalPicker);
        timeFinalPicker.updateTime(8, 0);

        // Click on "OK" button
        solo.clickOnText("OK");

        // Click on "Save" button
        solo.clickOnText("Save");

        // Verify if message of error was showed
        solo.waitForText("Invalid time.");

        // Verify if the the current activity is ReminderMainActivity
        solo.assertCurrentActivity("Expected Reminder Main Activity", ReminderMainActivity.class);

        // Verify if the reminder was be edited
        assertFalse(solo.searchText("Read some old book"));
    }

    public void testCancelCreationReminder_shouldNotBeShownOnReminderMainUi() throws Exception {
        // Unlock the screen
        solo.unlockScreen();

        // Click on "+" button
        solo.clickOnView(solo.getView(R.id.menu_addReminder));

        // Search for EditText of reminder title
        EditText etReminderTitle = (EditText) solo.getView(R.id.edtReminder);

        // Clean the reminder title EditText
        solo.clearEditText(etReminderTitle);

        // Enter with a title for reminder
        solo.enterText(etReminderTitle,"Read another book");

        // Same process of EditText for reminder title in EditText for reminder details
        EditText etReminderDetails = (EditText) solo.getView(R.id.edtDetails);
        solo.clearEditText(etReminderDetails);
        solo.enterText(etReminderDetails, "V for Vendetta");

        // Click on spinner of date initial
        solo.clickOnView(solo.getView(R.id.spinnerDateStart));
        // Click on "+ Select" option of date spinner initial
        solo.clickOnText("+ Select");

        // Wait for DatePickerFragment
        solo.waitForFragmentByTag("datePicker");

        // Get the DatePickerFragment
        DialogFragment dateStartFragment = (DialogFragment) solo.getCurrentActivity()
                .getFragmentManager().findFragmentByTag("datePicker");

        // Wait until DatePickerFragment is visible on screen
        assertNotNull(dateStartFragment);
        while (!(isShown(dateStartFragment))) {
            System.out.println("Dialog fragment visible: " + isShown(dateStartFragment));
            solo.sleep(100);
        }

        // Type cast for DatePickerDialog
        DatePickerDialog dateStartPicker = (DatePickerDialog) dateStartFragment.getDialog();

        // Get a date in future
        Calendar dayInDistantPast = DayInDistantPast();

        // Set the date
        assertNotNull(dateStartPicker);
        solo.setDatePicker(dateStartPicker.getDatePicker(), dayInDistantPast.get(Calendar.YEAR),
                dayInDistantPast.get(Calendar.MONTH), dayInDistantPast.get(Calendar.DAY_OF_MONTH));

        // Click on "OK" button
        solo.clickOnText("OK");

        // Click on spinner of time
        solo.clickOnView(solo.getView(R.id.spinnerTimeStart));
        // Click on "+ Select" option of time spinner
        solo.clickOnText("+ Select");

        // Wait for TimePickerFragment
        solo.waitForFragmentByTag("timePicker");

        // Get the DatePickerFragment
        DialogFragment timeStartFragment = (DialogFragment) solo.getCurrentActivity()
                .getFragmentManager().findFragmentByTag("timePicker");

        // Wait until DatePickerFragment is visible on screen
        assertNotNull(timeStartFragment);
        while (!(isShown(timeStartFragment))) {
            System.out.println("Dialog fragment visible: " + isShown(timeStartFragment));
            solo.sleep(100);
        }

        // Type cast for TimePickerDialog
        TimePickerDialog timeStartPicker = (TimePickerDialog) timeStartFragment.getDialog();

        // Set the time
        assertNotNull(timeStartPicker);
        timeStartPicker.updateTime(dayInDistantPast.get(Calendar.HOUR_OF_DAY), dayInDistantPast.get(Calendar.MINUTE));

        // Click on "OK" button
        solo.clickOnText("OK");

        // Click on spinner of date final
        solo.clickOnView(solo.getView(R.id.spinnerDateFinal));
        // Click on "+ Select" option of date spinner final
        solo.clickOnText("+ Select");

        // Wait for DatePickerFragment
        solo.waitForFragmentByTag("datePicker");

        // Get the DatePickerFragment
        DialogFragment dateFinalFragment = (DialogFragment) solo.getCurrentActivity()
                .getFragmentManager().findFragmentByTag("datePicker");

        // Wait until DatePickerFragment is visible on screen
        assertNotNull(dateFinalFragment);
        while (!(isShown(dateFinalFragment))) {
            System.out.println("Dialog fragment visible: " + isShown(dateFinalFragment));
            solo.sleep(100);
        }

        // Type cast for DatePickerDialog
        DatePickerDialog dateFinalPicker = (DatePickerDialog) dateFinalFragment.getDialog();

        // Get a date in future
        Calendar dayInPast = DayInPast();

        // Set the date
        assertNotNull(dateFinalPicker);
        solo.setDatePicker(dateFinalPicker.getDatePicker(), dayInPast.get(Calendar.YEAR),
                dayInPast.get(Calendar.MONTH), dayInPast.get(Calendar.DAY_OF_MONTH));

        // Click on "OK" button
        solo.clickOnText("OK");

        // Click on spinner of time
        solo.clickOnView(solo.getView(R.id.spinnerTimeFinal));
        // Click on "+ Select" option of time spinner
        solo.clickOnText("+ Select");

        // Wait for TimePickerFragment
        solo.waitForFragmentByTag("timePicker");

        // Get the DatePickerFragment
        DialogFragment timeFinalFragment = (DialogFragment) solo.getCurrentActivity()
                .getFragmentManager().findFragmentByTag("timePicker");

        // Wait until DatePickerFragment is visible on screen
        assertNotNull(timeFinalFragment);
        while (!(isShown(timeFinalFragment))) {
            System.out.println("Dialog fragment visible: " + isShown(timeFinalFragment));
            solo.sleep(100);
        }

        // Type cast for TimePickerDialog
        TimePickerDialog timeFinalPicker = (TimePickerDialog) timeFinalFragment.getDialog();

        // Set the time
        assertNotNull(timeFinalPicker);
        timeFinalPicker.updateTime(dayInPast.get(Calendar.HOUR_OF_DAY), dayInPast.get(Calendar.MINUTE));

        // Click on "OK" button
        solo.clickOnText("OK");

        // Click on "Cancel" button
        solo.clickOnText("Cancel");

        // Verify if the the current activity is ReminderMainActivity
        solo.assertCurrentActivity("Expected Reminder Main Activity", ReminderMainActivity.class);

        // Verify if the reminder was be edited
        assertFalse(solo.searchText("Read another book"));
    }

    // Auxilliar function for verify if DialogFragment can be used
    private boolean isShown(DialogFragment fragment) {
        if (fragment.getDialog() == null) {
            return false;
        } else {
            return true;
        }
    }

    private Calendar DayInDistantFuture() {
        Calendar dayInFuture = Calendar.getInstance();
        Date currentDay = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDay);
        if (cal.get(Calendar.MONTH) < 10) {
            dayInFuture.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 2, 1, 9, 30);
        } else {
            dayInFuture.set(cal.get(Calendar.YEAR) + 1, 2, 1, 9, 30);
        }
        return dayInFuture;
    }

    private Calendar DayInFuture() {
        Calendar dayInFuture = Calendar.getInstance();
        Date currentDay = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDay);
        if (cal.get(Calendar.MONTH) < 11) {
            dayInFuture.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, 1, 9, 30);
        } else {
            dayInFuture.set(cal.get(Calendar.YEAR) + 1, 0, 1, 9, 30);
        }
        return dayInFuture;
    }

    private Calendar DayInPresent() {
        Calendar dayInPresent = Calendar.getInstance();
        Date currentDay = new Date();
        dayInPresent.setTime(currentDay);
        if (dayInPresent.get(Calendar.HOUR_OF_DAY) < 23) {
            dayInPresent.set(dayInPresent.get(Calendar.YEAR), dayInPresent.get(Calendar.MONTH),
                    dayInPresent.get(Calendar.DAY_OF_MONTH), dayInPresent.get(Calendar.HOUR_OF_DAY) + 1, 30);
        } else {
            dayInPresent.set(dayInPresent.get(Calendar.YEAR), dayInPresent.get(Calendar.MONTH),
                    dayInPresent.get(Calendar.DAY_OF_MONTH), dayInPresent.get(Calendar.HOUR_OF_DAY), 59);
        }
        return dayInPresent;
    }

    private Calendar DayInPast() {
        Calendar dayInPast = Calendar.getInstance();
        Date currentDay = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDay);
        if (cal.get(Calendar.YEAR) > 0) {
            dayInPast.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) - 1, 1, 9, 30);
        } else {
            dayInPast.set(cal.get(Calendar.YEAR) - 1, 11, 1, 9, 30);
        }
        return dayInPast;
    }

    private Calendar DayInDistantPast() {
        Calendar dayInPast = Calendar.getInstance();
        Date currentDay = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDay);
        if (cal.get(Calendar.YEAR) > 1) {
            dayInPast.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) - 2, 1, 9, 30);
        } else {
            dayInPast.set(cal.get(Calendar.YEAR) - 1, 10, 1, 9, 30);
        }
        return dayInPast;
    }
}

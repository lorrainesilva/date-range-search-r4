package reminder.daterangesearch.br.unb.cic.reminders.view;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import reminder.daterangesearch.br.unb.cic.reminders.controller.Controller;
import
reminder.daterangesearch.br.unb.cic.reminders.model.InvalidDateException;
import
reminder.daterangesearch.br.unb.cic.reminders.model.InvalidTextException;
import reminder.daterangesearch.br.unb.cic.reminders.model.Reminder;
import br.unb.cic.reminders2.R;
/*** added by dManageReminder* modified by dDateRange
 */
public abstract class ReminderActivity extends Activity {
	protected Reminder reminder;
	protected EditText edtReminder, edtDetails, edtDate, edtTime;
	private Button btnSave, btnCancel;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.reminder_add);
		if(reminder == null) reminder = new Reminder();
		initializeFields();
		initializeListeners();
		initializeValues();
	}
	private void initializeListeners() {
		addListenerToBtnSave();
		addListenerToBtnCancel();
		addListenerToSpinnerDate();
		addListenerToSpinnerTime();
	}
	protected abstract void initializeValues();
	private void addListenerToBtnSave() {
		btnSave.setOnClickListener(new Button.OnClickListener() {
				public void onClick(View v) {
					try {
						createReminder();
						persist(reminder);
						finish();
					}
					catch(Exception e) {
						Log.e("ReminderActivity", e.getMessage());
						e.printStackTrace();
					}
				}
			});
	}
	private void addListenerToBtnCancel() {
		btnCancel.setOnClickListener(new Button.OnClickListener() {
				public void onClick(View v) {
					finish();
				}
			});
	}
	private void createReminder() {
		try {
			reminder.setText(edtReminder.getText().toString());
			reminder.setDetails(edtDetails.getText().toString());
			setValuesOnReminder();
		}
		catch(InvalidTextException e) {
			Toast.makeText(getApplicationContext(), "Invalid text.",
				Toast.LENGTH_SHORT).show();
		}
		catch(InvalidDateException e) {
			Toast.makeText(getApplicationContext(), "Invalid date.",
				Toast.LENGTH_SHORT).show();
		}
		catch(InvalidHourException e) {
			Toast.makeText(getApplicationContext(), "Invalid time.",
				Toast.LENGTH_SHORT).show();
		}
		catch(Exception e) {
			Toast.makeText(getApplicationContext(), "Serious error.",
				Toast.LENGTH_SHORT).show();
		}
	}
	@SuppressWarnings("unchecked")
	protected void updateSpinnerDateHour(Spinner spinner, String dateOrHour) {
		if(dateOrHour == null) return;
		ArrayAdapter<String> adapter = ( ArrayAdapter<String> ) spinner.getAdapter();
		int count = adapter.getCount();
		if(count > 2) {
			for(int i = 2;
				i < count;
				++ i) adapter.remove(adapter.getItem(i));
		}
		adapter.add(dateOrHour);
		spinner.setSelection(2);
	}
	protected abstract void persist(Reminder reminder);
	/*** added by dDateRange
	 */
	protected Calendar dateStart, timeStart, dateFinal, timeFinal;
	/*** added by dDateRange
	 */
	protected Spinner spinnerDateStart, spinnerTimeStart, spinnerDateFinal,
	spinnerTimeFinal;
	/*** added by dDateRange
	 */
	private void initializeFields() {
		btnSave = ( Button ) findViewById(R.id.btnSave);
		btnCancel = ( Button ) findViewById(R.id.btnCancel);
		edtReminder = ( EditText ) findViewById(R.id.edtReminder);
		edtDetails = ( EditText ) findViewById(R.id.edtDetails);
		spinnerDateStart = getSpinnerDateStart();
		spinnerTimeStart = getSpinnerTimeStart();
		spinnerDateFinal = getSpinnerDateFinal();
		spinnerTimeFinal = getSpinnerTimeFinal();
	}
	/*** added by dDateRange
	 */
	private void setValuesOnReminder() throws Exception {
		reminder.setDateStart(dateToString(dateStart));
		reminder.setHourStart(timeToString(timeStart));
		reminder.setDateFinal(dateToString(dateFinal));
		reminder.setHourFinal(timeToString(timeFinal));
	}
	/*** added by dDateRange
	 */
	private void addListenerToSpinnerDate() {
		spinnerDateStart.setOnTouchListener(new View.OnTouchListener() {
				public boolean onTouch(View v, MotionEvent event) {
					spinnerDateStart = getSpinnerDateStart();
					return false;
				}
			});
		spinnerDateStart.setOnKeyListener(new View.OnKeyListener() {
				public boolean onKey(View v, int keyCode, KeyEvent event) {
					spinnerDateStart = getSpinnerDateStart();
					return false;
				}
			});
		spinnerDateStart.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onItemSelected(AdapterView<? extends Object> parent, View view,
					int pos, long id) {
					switch(pos) {
						case 0 : dateStart = null;
						break;
						case 1 : if(dateStart == null) dateStart = Calendar.getInstance();
						DialogFragment newFragment = new DatePickerDialogFragment(dateStart,
							spinnerDateStart);
						newFragment.show(getFragmentManager(), "datePicker");
						break;
						default :
					}
				}
				public void onNothingSelected(AdapterView<? extends Object> arg0) {
				}
			});
		spinnerDateFinal.setOnTouchListener(new View.OnTouchListener() {
				public boolean onTouch(View v, MotionEvent event) {
					spinnerDateFinal = getSpinnerDateFinal();
					return false;
				}
			});
		spinnerDateFinal.setOnKeyListener(new View.OnKeyListener() {
				public boolean onKey(View v, int keyCode, KeyEvent event) {
					spinnerDateFinal = getSpinnerDateFinal();
					return false;
				}
			});
		spinnerDateFinal.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onItemSelected(AdapterView<? extends Object> parent, View view,
					int pos, long id) {
					switch(pos) {
						case 0 : dateFinal = null;
						break;
						case 1 : if(dateFinal == null) dateFinal = Calendar.getInstance();
						DialogFragment newFragment = new DatePickerDialogFragment(dateFinal,
							spinnerDateFinal);
						newFragment.show(getFragmentManager(), "datePicker");
						break;
						default :
					}
				}
				public void onNothingSelected(AdapterView<? extends Object> arg0) {
				}
			});
	}
	/*** added by dDateRange
	 */
	private void addListenerToSpinnerTime() {
		spinnerTimeStart.setOnTouchListener(new View.OnTouchListener() {
				public boolean onTouch(View v, MotionEvent event) {
					spinnerTimeStart = getSpinnerTimeStart();
					return false;
				}
			});
		spinnerTimeStart.setOnKeyListener(new View.OnKeyListener() {
				public boolean onKey(View v, int keyCode, KeyEvent event) {
					spinnerTimeStart = getSpinnerTimeStart();
					return false;
				}
			});
		spinnerTimeStart.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onItemSelected(AdapterView<? extends Object> parent, View view,
					int pos, long id) {
					switch(pos) {
						case 0 : timeStart = null;
						break;
						case 1 : if(timeStart == null) timeStart = Calendar.getInstance();
						DialogFragment newFragment = new TimePickerDialogFragment(timeStart,
							spinnerTimeStart);
						newFragment.show(getFragmentManager(), "timePicker");
						break;
						default :
					}
				}
				public void onNothingSelected(AdapterView<? extends Object> arg0) {
				}
			});
		spinnerTimeFinal.setOnTouchListener(new View.OnTouchListener() {
				public boolean onTouch(View v, MotionEvent event) {
					spinnerTimeFinal = getSpinnerTimeFinal();
					return false;
				}
			});
		spinnerTimeFinal.setOnKeyListener(new View.OnKeyListener() {
				public boolean onKey(View v, int keyCode, KeyEvent event) {
					spinnerTimeFinal = getSpinnerTimeFinal();
					return false;
				}
			});
		spinnerTimeFinal.setOnItemSelectedListener(new OnItemSelectedListener() {
				public void onItemSelected(AdapterView<? extends Object> parent, View view,
					int pos, long id) {
					switch(pos) {
						case 0 : timeFinal = null;
						break;
						case 1 : if(timeFinal == null) timeFinal = Calendar.getInstance();
						DialogFragment newFragment = new TimePickerDialogFragment(timeFinal,
							spinnerTimeFinal);
						newFragment.show(getFragmentManager(), "timePicker");
						break;
						default :
					}
				}
				public void onNothingSelected(AdapterView<? extends Object> arg0) {
				}
			});
	}
	/*** added by dDateRange
	 */
	private String dateToString(Calendar date) {
		if(date == null) return null;
		String sDate;
		sDate = Integer.toString(date.get(Calendar.MONTH) + 1);
		if(date.get(Calendar.MONTH) + 1 < 10) sDate = "0" + sDate;
		sDate = Integer.toString(date.get(Calendar.DAY_OF_MONTH)) + "-" + sDate;
		if(date.get(Calendar.DAY_OF_MONTH) < 10) sDate = "0" + sDate;
		sDate += "-" + Integer.toString(date.get(Calendar.YEAR));
		return sDate;
	}
	/*** added by dDateRange
	 */
	private String timeToString(Calendar time) {
		if(time == null) return null;
		String sTime;
		sTime = Integer.toString(time.get(Calendar.MINUTE));
		if(time.get(Calendar.MINUTE) < 10) sTime = "0" + sTime;
		sTime = Integer.toString(time.get(Calendar.HOUR_OF_DAY)) + ":" + sTime;
		if(time.get(Calendar.HOUR_OF_DAY) < 10) sTime = "0" + sTime;
		return sTime;
	}
	/*** added by dDateRange
	 */
	protected void updateDateFromString(String sDate, boolean isFinal) {
		if(sDate == null || sDate.equals("")) {
			if(isFinal) dateFinal = null;
			else dateStart = null;
			return;
		}
		char sDay [] = {
			sDate.charAt(0), sDate.charAt(1)
		};
		int day = Integer.parseInt(new String(sDay), 10);
		char sMonth [] = {
			sDate.charAt(3), sDate.charAt(4)
		};
		int month = Integer.parseInt(new String(sMonth), 10);
		char sYear [] = {
			sDate.charAt(6), sDate.charAt(7), sDate.charAt(8), sDate.charAt(9)
		};
		int year = Integer.parseInt(new String(sYear), 10);
		if(dateFinal == null) dateFinal = Calendar.getInstance();
		if(dateStart == null) dateStart = Calendar.getInstance();
		if(isFinal) dateFinal.set(year, month - 1, day);
		else dateStart.set(year, month - 1, day);
	}
	/*** added by dDateRange
	 */
	protected void updateTimeFromString(String sTime, boolean isFinal) {
		if(sTime == null || sTime.equals("")) {
			if(isFinal) timeFinal = null;
			else timeStart = null;
			return;
		}
		char sHour [] = {
			sTime.charAt(0), sTime.charAt(1)
		};
		int hour = Integer.parseInt(new String(sHour), 10);
		char sMinute [] = {
			sTime.charAt(3), sTime.charAt(4)
		};
		int minute = Integer.parseInt(new String(sMinute), 10);
		if(timeStart == null) timeStart = Calendar.getInstance();
		if(timeFinal == null) timeFinal = Calendar.getInstance();
		if(isFinal) {
			timeFinal.set(Calendar.MINUTE, minute);
			timeFinal.set(Calendar.HOUR_OF_DAY, hour);
		}
		else {
			timeStart.set(Calendar.MINUTE, minute);
			timeStart.set(Calendar.HOUR_OF_DAY, hour);
		}
	}
	/*** added by dDateRange
	 */
	private Spinner getSpinnerDateStart() {
		Spinner spinner = ( Spinner ) findViewById(R.id.spinnerDateStart);
		SpinnerAdapterGenerator<String> adapterDateGenerator = new
		SpinnerAdapterGenerator<String>();
		List<String> items = new ArrayList<String>();
		items.add("No date");
		items.add("+ Select");
		spinner.setAdapter(adapterDateGenerator.getSpinnerAdapter(items, this));
		return spinner;
	}
	/*** added by dDateRange
	 */
	private Spinner getSpinnerTimeStart() {
		Spinner spinner = ( Spinner ) findViewById(R.id.spinnerTimeStart);
		SpinnerAdapterGenerator<String> adapterTimeGenerator = new
		SpinnerAdapterGenerator<String>();
		List<String> items = new ArrayList<String>();
		items.add("No time");
		items.add("+ Select");
		spinner.setAdapter(adapterTimeGenerator.getSpinnerAdapter(items, this));
		return spinner;
	}
	/*** added by dDateRange
	 */
	private Spinner getSpinnerDateFinal() {
		Spinner spinner = ( Spinner ) findViewById(R.id.spinnerDateFinal);
		SpinnerAdapterGenerator<String> adapterDateGenerator = new
		SpinnerAdapterGenerator<String>();
		List<String> items = new ArrayList<String>();
		items.add("No date");
		items.add("+ Select");
		spinner.setAdapter(adapterDateGenerator.getSpinnerAdapter(items, this));
		return spinner;
	}
	/*** added by dDateRange
	 */
	private Spinner getSpinnerTimeFinal() {
		Spinner spinner = ( Spinner ) findViewById(R.id.spinnerTimeFinal);
		SpinnerAdapterGenerator<String> adapterTimeGenerator = new
		SpinnerAdapterGenerator<String>();
		List<String> items = new ArrayList<String>();
		items.add("No time");
		items.add("+ Select");
		spinner.setAdapter(adapterTimeGenerator.getSpinnerAdapter(items, this));
		return spinner;
	}
}
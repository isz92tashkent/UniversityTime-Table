package universitytimetable.developer;

import java.util.Calendar;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.Toast;
import universitytimetable.developer.bean.AddLessons;
import universitytimetable.developer.db.DBHandler;

@SuppressWarnings("deprecation")
public class Add_New_Lesson extends ActionBarActivity {

	private EditText start_time;
	private EditText end_time;
	private EditText upcoming_examinfo;
	private EditText credit_hour;
	private EditText tasks;
	private EditText teacher_name;
	private EditText teacher_email;
	private EditText module_code;
	private EditText module_name;
	private Button submit;
	private EditText date;
	private int year;
	private int month;
	private int day;
	private static final int DATE_DIALOG_ID = 1;
	String currentDate = "";
	private ImageView back;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add__new__lesson);

		Toolbar toolbar = (Toolbar) findViewById(R.id.my_awesome_toolbar);
		if (toolbar != null) {
			setSupportActionBar(toolbar);
		}

		getSupportActionBar().setDisplayShowTitleEnabled(false);
//		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		
		back = (ImageView) findViewById(R.id.back);
		back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				onBackPressed();

			}
		});

		start_time = (EditText) findViewById(R.id.start_time);
		end_time = (EditText) findViewById(R.id.end_time);
		module_name = (EditText) findViewById(R.id.module_name);
		module_code = (EditText) findViewById(R.id.module_code);
		teacher_name = (EditText) findViewById(R.id.teacher_name);
		teacher_email = (EditText) findViewById(R.id.teacher_email);
		credit_hour = (EditText) findViewById(R.id.credit_hour);
		tasks = (EditText) findViewById(R.id.tasks);
		date = (EditText) findViewById(R.id.date);
		upcoming_examinfo = (EditText) findViewById(R.id.examinfo);
		submit = (Button) findViewById(R.id.submit);

		Typeface typeface = Typeface.createFromAsset(getAssets(), "OpenSans-Light.ttf");
		submit.setTypeface(typeface);

		submit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				boolean error = false;

				String start = start_time.getText().toString().trim();
				String end = end_time.getText().toString().trim();
				String mo_name = module_name.getText().toString().trim();
				String mo_code = module_code.getText().toString().trim();
				String credit = credit_hour.getText().toString().trim();
				String task = tasks.getText().toString().trim();
				String upcoming = upcoming_examinfo.getText().toString().trim();
				String teacher_na = teacher_name.getText().toString().trim();
				String teacher_em = teacher_email.getText().toString().trim();
				String date_string = date.getText().toString().trim();

				Log.i("start", date_string);

				if (mo_name.equals("")) {
					error = true;

					Toast.makeText(Add_New_Lesson.this, "Enter Module Name !!", Toast.LENGTH_LONG).show();

				} else if (mo_code.equals("")) {

					error = true;
					Toast.makeText(Add_New_Lesson.this, "Enter Module Code !!", Toast.LENGTH_LONG).show();

				} else if (teacher_na.equals("")) {
					error = true;

					Toast.makeText(Add_New_Lesson.this, "Enter Teacher Name !!", Toast.LENGTH_LONG).show();

				} else if (teacher_em.equals("")) {

					error = true;
					Toast.makeText(Add_New_Lesson.this, "Enter Teacher Email !!", Toast.LENGTH_LONG).show();

				} else if (credit.equals("")) {

					error = true;
					Toast.makeText(Add_New_Lesson.this, "Enter Credit Hour !!", Toast.LENGTH_LONG).show();

				} else if (date_string.equals("")) {

					error = true;
					Toast.makeText(Add_New_Lesson.this, "Enter Date !!", Toast.LENGTH_LONG).show();

				} else if (start.equals("")) {

					error = true;
					Toast.makeText(Add_New_Lesson.this, "Enter Start Time !!", Toast.LENGTH_LONG).show();

				} else if (end.equals("")) {
					error = true;
					Toast.makeText(Add_New_Lesson.this, "Enter End Time !!", Toast.LENGTH_LONG).show();

				} else if (task.equals("")) {

					error = true;
					Toast.makeText(Add_New_Lesson.this, "Enter Tasks !!", Toast.LENGTH_LONG).show();

				} else if (upcoming.equals("")) {

					error = true;
					Toast.makeText(Add_New_Lesson.this, "Enter Upcoming Exam Info !!", Toast.LENGTH_LONG).show();

				}

				if (!error) {

					start_time.setText("");
					end_time.setText("");
					module_code.setText("");
					module_name.setText("");
					teacher_email.setText("");
					teacher_name.setText("");
					credit_hour.setText("");
					tasks.setText("");
					upcoming_examinfo.setText("");
					date.setText("");

					Log.i("start", date_string);

					AddLessons lesson = new AddLessons(mo_name, mo_code, teacher_na, teacher_em, credit, start, end,
							task, upcoming, date_string);

					DBHandler handler = new DBHandler(Add_New_Lesson.this);
					handler.addUser(lesson);

					Toast.makeText(Add_New_Lesson.this, "You have Added Lesson Successfully !!", Toast.LENGTH_LONG)
							.show();
				}

			}
		});

		date.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				final Calendar c = Calendar.getInstance();
				year = c.get(Calendar.YEAR);
				month = c.get(Calendar.MONTH);
				day = c.get(Calendar.DAY_OF_MONTH);
				showDialog(DATE_DIALOG_ID);

			}
		});
		start_time.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Calendar mcurrentTime = Calendar.getInstance();
				int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
				int minute = mcurrentTime.get(Calendar.MINUTE);
				TimePickerDialog mTimePicker;
				mTimePicker = new TimePickerDialog(Add_New_Lesson.this, new TimePickerDialog.OnTimeSetListener() {
					@Override
					public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
						start_time.setText(selectedHour + ":" + selectedMinute);
					}
				}, hour, minute, true);// Yes 24 hour time
				// mTimePicker.setTitle("Select Time");
				mTimePicker.requestWindowFeature(Window.FEATURE_NO_TITLE);
				mTimePicker.show();

			}
		});

		end_time.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Calendar mcurrentTime = Calendar.getInstance();
				int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
				int minute = mcurrentTime.get(Calendar.MINUTE);
				TimePickerDialog mTimePicker;
				mTimePicker = new TimePickerDialog(Add_New_Lesson.this, new TimePickerDialog.OnTimeSetListener() {
					@Override
					public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
						end_time.setText(selectedHour + ":" + selectedMinute);
					}
				}, hour, minute, true);// Yes 24 hour time
				// mTimePicker.setTitle("Select Time");
				mTimePicker.requestWindowFeature(Window.FEATURE_NO_TITLE);
				mTimePicker.show();

			}
		});
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			onBackPressed();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	OnDateSetListener myDateSetListener = new OnDateSetListener() {

		@Override
		public void onDateSet(DatePicker datePicker, int i, int j, int k) {

			year = i;
			month = j;
			day = k;
			currentDate = new StringBuilder().append(day).append("-").append(month + 1).append("-").append(year)
					.toString();
			date.setText(currentDate);
		}
	};

	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DATE_DIALOG_ID:
			return new DatePickerDialog(this, myDateSetListener, year, month, day);
		}
		return null;
	}
}

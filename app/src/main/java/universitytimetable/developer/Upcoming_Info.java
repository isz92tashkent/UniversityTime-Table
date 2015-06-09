package universitytimetable.developer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

@SuppressWarnings("deprecation")
public class Upcoming_Info extends ActionBarActivity {

	private TextView date;
	private TextView info;
	private TextView task;
	private TextView module_name;
	private TextView module_code;
	private TextView credit;
	private TextView teacher_name;
	private TextView teacher_email;
	private TextView start;
	private TextView end;
	private ImageView back;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_upcoming__info);

		Toolbar toolbar = (Toolbar) findViewById(R.id.my_awesome_toolbar);
		if (toolbar != null) {
			setSupportActionBar(toolbar);
		}

		getSupportActionBar().setDisplayShowTitleEnabled(false);
		// getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		back = (ImageView) findViewById(R.id.back);
		back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				onBackPressed();

			}
		});

		date = (TextView) findViewById(R.id.date);
		task = (TextView) findViewById(R.id.task);
		module_name = (TextView) findViewById(R.id.module_name);
		module_code = (TextView) findViewById(R.id.module_code);
		credit = (TextView) findViewById(R.id.credit);
		teacher_name = (TextView) findViewById(R.id.teacher_name);
		teacher_email = (TextView) findViewById(R.id.email);
		start = (TextView) findViewById(R.id.start);
		end = (TextView) findViewById(R.id.end);
		info = (TextView) findViewById(R.id.info);

		Intent i = getIntent();

		date.setText("Date Is : " + i.getStringExtra("date"));
		info.setText("Exam Info Is : " + i.getStringExtra("info"));
		task.setText(i.getStringExtra("task"));
		module_name.setText("Module Name Is : " + i.getStringExtra("module_name"));
		module_code.setText("Module Code Is : " + i.getStringExtra("module_code"));
		credit.setText("Credit Hour Is : " + i.getStringExtra("credit"));
		teacher_name.setText("Teacher Name Is : " + i.getStringExtra("tech_name"));
		teacher_email.setText("Teacher Email Is : " + i.getStringExtra("tech_email"));
		start.setText("Start Time Is : " + i.getStringExtra("start"));
		end.setText("End Time Is : " + i.getStringExtra("end"));

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
}

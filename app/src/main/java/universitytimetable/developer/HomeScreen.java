package universitytimetable.developer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

@SuppressWarnings("deprecation")
public class HomeScreen extends ActionBarActivity {

	private LinearLayout add_lesson;
	private LinearLayout today_classes;
	private LinearLayout upcoming_tasks;
	private LinearLayout about;
	private LinearLayout contact_us;
	private LinearLayout weekview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_screen);

		Toolbar toolbar = (Toolbar) findViewById(R.id.my_awesome_toolbar);
		if (toolbar != null) {
			setSupportActionBar(toolbar);
		}

		getSupportActionBar().setDisplayShowTitleEnabled(false);

		add_lesson = (LinearLayout) findViewById(R.id.newlesson);
		today_classes = (LinearLayout) findViewById(R.id.classes);
		upcoming_tasks = (LinearLayout) findViewById(R.id.upcoming_tasks);
		about = (LinearLayout) findViewById(R.id.about);
		contact_us = (LinearLayout) findViewById(R.id.contact);
		weekview = (LinearLayout) findViewById(R.id.weekview);

		weekview.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent intent = new Intent(HomeScreen.this, Weekview.class);
				startActivity(intent);

			}
		});
		contact_us.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(HomeScreen.this, Contact_Us.class);
				startActivity(intent);

			}
		});
		about.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(HomeScreen.this, AboutApp.class);
				startActivity(intent);

			}
		});
		upcoming_tasks.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent intent = new Intent(HomeScreen.this, Upcoming_Task.class);
				startActivity(intent);

			}
		});

		add_lesson.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(HomeScreen.this, Add_New_Lesson.class);
				startActivity(intent);

			}
		});

		today_classes.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(HomeScreen.this, Today_Classes.class);
				startActivity(intent);

			}
		});

	}

}

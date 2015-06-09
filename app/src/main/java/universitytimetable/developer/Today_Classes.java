package universitytimetable.developer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import universitytimetable.developer.adapters.InfoAdapter;
import universitytimetable.developer.adapters.TodayAdapter;
import universitytimetable.developer.bean.AddLessons;
import universitytimetable.developer.bean.UpdateDataset;
import universitytimetable.developer.db.DBHandler;

@SuppressWarnings("deprecation")
public class Today_Classes extends ActionBarActivity {

	private List<AddLessons> lesson;

	private ArrayList<UpdateDataset> upcoming;

	private ListView list;
	UpdateDataset set;

	private ImageView back;

	@SuppressLint("SimpleDateFormat")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_today__classes);

		Toolbar toolbar = (Toolbar) findViewById(R.id.my_awesome_toolbar);
		list = (ListView) findViewById(R.id.list);
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

		DBHandler handler = new DBHandler(Today_Classes.this);

		lesson = handler.getUser();

		// Log.i("size", lesson.get(i). + " ");
		upcoming = new ArrayList<UpdateDataset>();

		for (int i = 0; i < lesson.size(); i++) {

			// Log.i("date", lesson.get(i).getDatee());
			set = new UpdateDataset();

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			Calendar c = Calendar.getInstance();
			String formattedDate = sdf.format(c.getTime());

			try {
				Date date1 = sdf.parse(lesson.get(i).getDatee());
				Date date2 = sdf.parse(formattedDate);

				if (date1.after(date2)) {

				}

				if (date1.before(date2)) {
					Log.i("date", "is before " + lesson.get(i).getDatee());
				}

				if (date1.equals(date2)) {

					set.setDate(lesson.get(i).getDatee());
					set.setInfo(lesson.get(i).getExam_info());
					set.setTasks(lesson.get(i).getTasks());
					set.setModule_name(lesson.get(i).getModule_name());
					set.setModule_code(lesson.get(i).getModule_code());
					set.setTeach_name(lesson.get(i).getTeach_name());
					set.setTech_email(lesson.get(i).getTech_email());
					set.setCredit(lesson.get(i).getCredit());
					set.setStart_time(lesson.get(i).getStart_time());
					set.setEnd_time(lesson.get(i).getEnd_time());
					upcoming.add(set);
					Log.i("date", "is after " + lesson.get(i).getDatee());
					System.out.println("Date1 is equal Date2");
				}

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		TodayAdapter adpt = new TodayAdapter(Today_Classes.this, upcoming);
		list.setAdapter(adpt);

		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

				Intent intent = new Intent(Today_Classes.this, Upcoming_Info.class);
				intent.putExtra("date", upcoming.get(position).getDate());
				intent.putExtra("info", upcoming.get(position).getInfo());
				intent.putExtra("task", upcoming.get(position).getTasks());
				intent.putExtra("module_name", upcoming.get(position).getModule_name());
				intent.putExtra("module_code", upcoming.get(position).getModule_code());
				intent.putExtra("tech_name", upcoming.get(position).getTeach_name());
				intent.putExtra("tech_email", upcoming.get(position).getTech_email());
				intent.putExtra("credit", upcoming.get(position).getCredit());
				intent.putExtra("start", upcoming.get(position).getStart_time());
				intent.putExtra("end", upcoming.get(position).getEnd_time());
				startActivity(intent);

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

}

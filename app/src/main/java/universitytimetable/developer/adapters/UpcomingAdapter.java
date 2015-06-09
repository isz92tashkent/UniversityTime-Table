package universitytimetable.developer.adapters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import universitytimetable.developer.R;
import universitytimetable.developer.bean.UpdateDataset;

public class UpcomingAdapter extends ArrayAdapter<UpdateDataset> {

	Context mcontext;

	ArrayList<UpdateDataset> upcoming;

	private static class ViewHolder {
		TextView date;
		TextView info;

	}

	public UpcomingAdapter(Context context, ArrayList<UpdateDataset> upcoming) {
		super(context, R.layout.info_raw, upcoming);
		this.mcontext = context;
		this.upcoming = upcoming;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// Get the data item for this position
		final UpdateDataset user = getItem(position);

		Log.i("info", user.getInfo());
		// Check if an existing view is being reused, otherwise inflate the view
		ViewHolder viewHolder; // view lookup cache stored in tag
		if (convertView == null) {
			viewHolder = new ViewHolder();
			LayoutInflater inflater = LayoutInflater.from(getContext());
			convertView = inflater.inflate(R.layout.info_raw, parent, false);
			viewHolder.date = (TextView) convertView.findViewById(R.id.date);
			viewHolder.info = (TextView) convertView.findViewById(R.id.info);
			convertView.setTag(viewHolder);

		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		// Populate the data into the template view using the data object
		SimpleDateFormat inFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date;
		String goal = "";
		try {
			date = inFormat.parse(upcoming.get(position).getDate());
			SimpleDateFormat outFormat = new SimpleDateFormat("EEEE");
			goal = outFormat.format(date);
			Log.i("day", goal);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		viewHolder.date.setText(upcoming.get(position).getTasks() + "  " + upcoming.get(position).getStart_time()
				+ " To " + upcoming.get(position).getEnd_time());
		viewHolder.info.setText(goal);

		return convertView;
	}
}

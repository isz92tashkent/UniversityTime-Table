package universitytimetable.developer.db;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import universitytimetable.developer.bean.AddLessons;

public class DBHandler extends SQLiteOpenHelper {

	public static final String DB_NAME = "university";
	public static final int DB_VERSION = 2;
	public static final String TABLE_NAME = "add_lessons";
	public static final String USERID = "userid";
	public static final String START_TIME = "start_time";
	public static final String END_TIME = "end_time";
	public static final String TEACH_NAME = "tech_name";
	public static final String TECH_EMAIL = "tech_email";
	public static final String CREDIT = "credit";
	public static final String MODULE_NAME = "module_name";
	public static final String MODULE_CODE = "module_code";
	public static final String TASKS = "tasks";
	public static final String INFO = "info";
	public static final String DATEE = "date_colum";

	public DBHandler(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// create table
		String createTable = "CREATE TABLE " + TABLE_NAME + " ( " + USERID + " INTEGER PRIMARY KEY AUTOINCREMENT , "
				+ MODULE_NAME + " VARCHAR(255), " + MODULE_CODE + " VARCHAR(255), " + START_TIME + " VARCHAR(255), "
				+ END_TIME + " VARCHAR(255), " + TEACH_NAME + " VARCHAR(255), " + TECH_EMAIL + " VARCHAR(255), "
				+ CREDIT + " VARCHAR(255) , " + TASKS + " VARCHAR(255), " + INFO + " VARCHAR(255), " + DATEE
				+ " VARCHAR(255))";

		db.execSQL(createTable);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		String dropquery = "DROP TABLE IF EXISTS " + TABLE_NAME;
		onCreate(db);
	}

	public void addUser(AddLessons user) {
		SQLiteDatabase sqldb = getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(MODULE_NAME, user.getModule_name());
		values.put(MODULE_CODE, user.getModule_code());
		values.put(TEACH_NAME, user.getTeach_name());
		values.put(TECH_EMAIL, user.getTech_email());
		values.put(CREDIT, user.getCredit());
		values.put(START_TIME, user.getStart_time());
		values.put(END_TIME, user.getEnd_time());
		values.put(TASKS, user.getTasks());
		values.put(INFO, user.getExam_info());
		values.put(DATEE, user.getDatee());
		sqldb.insert(TABLE_NAME, USERID, values);
		sqldb.close();
	}

	public List<AddLessons> getUser() {
		List<AddLessons> users = new ArrayList<AddLessons>();

		SQLiteDatabase sqldb = getReadableDatabase();

		String[] columns = { USERID, MODULE_NAME, MODULE_CODE, TEACH_NAME, TECH_EMAIL, CREDIT, START_TIME, END_TIME,
				TASKS, INFO, DATEE };
		Cursor cursor = sqldb.query(TABLE_NAME, columns, null, null, null, null, null);

		while (cursor.moveToNext()) {

			AddLessons user = new AddLessons(cursor.getInt(0), cursor.getString(1), cursor.getString(2),
					cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6),
					cursor.getString(7), cursor.getString(8), cursor.getString(9), cursor.getString(10));
			users.add(user);
		}
		cursor.close();
		sqldb.close();
		return users;
	}

	// public User findUser(long id) {
	// Log.e("<>>>>>>>>>>>>", id + "");
	// SQLiteDatabase sqldb = getReadableDatabase();
	// String[] columns = { USERID, USERNAME, PASSWORD, NAME, EMAIL };
	//
	// String selection = USERID + "=" + id;
	// Cursor cursor = sqldb.query(TABLE_NAME, columns, selection, null, null,
	// null, null);
	// cursor.moveToNext();
	// User user = new User(cursor.getInt(0), cursor.getString(1),
	// cursor.getString(2), cursor.getString(3),
	// cursor.getString(4));
	// Log.e("<>>>>>", user.getUserid() + "");
	// cursor.close();
	// sqldb.close();
	// return user;
	// }

	// public void updateUser(User user) {
	// SQLiteDatabase sqldb = getWritableDatabase();
	// ContentValues values = new ContentValues();
	// values.put(USERNAME, user.getUsername());
	// values.put(PASSWORD, user.getPassword());
	// values.put(NAME, user.getName());
	// values.put(EMAIL, user.getEmail());
	// String whereClause = USERID + " = " + user.getUserid();
	// sqldb.update(TABLE_NAME, values, whereClause, null);
	// sqldb.close();
	//
	// }

	// public void deleteUser(int userid) {
	// SQLiteDatabase sqldb = getWritableDatabase();
	// String whereClause = USERID + " = " + userid;
	// sqldb.delete(TABLE_NAME, whereClause, null);
	// sqldb.close();
	//
	// }

}

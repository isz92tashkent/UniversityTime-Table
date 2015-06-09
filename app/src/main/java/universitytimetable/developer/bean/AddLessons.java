package universitytimetable.developer.bean;

public class AddLessons {

	private int id;
	private String module_name;
	private String module_code;
	private String teach_name;
	private String tech_email;
	private String start_time;
	private String end_time;
	private String tasks;
	private String exam_info;
	private String datee;

	public AddLessons(String module_name, String module_code, String teach_name, String tech_email, String credit,
			String start_time, String end_time, String tasks, String exam_info, String datee) {
		super();
		this.module_name = module_name;
		this.module_code = module_code;
		this.teach_name = teach_name;
		this.tech_email = tech_email;
		this.credit = credit;
		this.start_time = start_time;
		this.end_time = end_time;
		this.tasks = tasks;
		this.exam_info = exam_info;
		this.datee = datee;
	}

	private String credit;

	public AddLessons(int id, String module_name, String module_code, String teach_name, String tech_email,
			String credit, String start_time, String end_time, String tasks, String exam_info, String datee) {
		super();
		this.id = id;
		this.module_name = module_name;
		this.module_code = module_code;
		this.teach_name = teach_name;
		this.tech_email = tech_email;
		this.credit = credit;
		this.start_time = start_time;
		this.end_time = end_time;
		this.tasks = tasks;
		this.exam_info = exam_info;
		this.datee = datee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getModule_name() {
		return module_name;
	}

	public void setModule_name(String module_name) {
		this.module_name = module_name;
	}

	public String getModule_code() {
		return module_code;
	}

	public void setModule_code(String module_code) {
		this.module_code = module_code;
	}

	public String getTeach_name() {
		return teach_name;
	}

	public void setTeach_name(String teach_name) {
		this.teach_name = teach_name;
	}

	public String getTech_email() {
		return tech_email;
	}

	public void setTech_email(String tech_email) {
		this.tech_email = tech_email;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getTasks() {
		return tasks;
	}

	public void setTasks(String tasks) {
		this.tasks = tasks;
	}

	public String getExam_info() {
		return exam_info;
	}

	public void setExam_info(String exam_info) {
		this.exam_info = exam_info;
	}

	public String getDatee() {
		return datee;
	}

	public void setDatee(String datee) {
		this.datee = datee;
	}

}

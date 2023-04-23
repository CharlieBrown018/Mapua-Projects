package net.codejava.ws.bean;

import java.sql.Date;

public class Task {

	private int task_id;
	private String task_name;
	private String task_type;
	private String task_status;
	private Date task_duedate;
	
	// for auto-increment of task_id
	public Task(String task_name, String task_type, String task_status, Date task_duedate) {
		super();
		this.task_name = task_name;
		this.task_type = task_type;
		this.task_status = task_status;
		this.task_duedate = task_duedate;
	}

	public Task(int task_id, String task_name, String task_type, String task_status, Date task_duedate) {
		super();
		this.task_id = task_id;
		this.task_name = task_name;
		this.task_type = task_type;
		this.task_status = task_status;
		this.task_duedate = task_duedate;
	}
	
	public int getTask_id() {
		return task_id;
	}
	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}
	public String getTask_name() {
		return task_name;
	}
	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}
	public String getTask_type() {
		return task_type;
	}
	public void setTask_type(String task_type) {
		this.task_type = task_type;
	}
	public String getTask_status() {
		return task_status;
	}
	public void setTask_status(String task_status) {
		this.task_status = task_status;
	}
	public Date getTask_duedate() {
		return task_duedate;
	}
	public void setTask_duedate(Date task_duedate) {
		this.task_duedate = task_duedate;
	}
	
	
}

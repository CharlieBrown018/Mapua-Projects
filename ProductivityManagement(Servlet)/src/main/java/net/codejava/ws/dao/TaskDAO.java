package net.codejava.ws.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import net.codejava.ws.bean.Task;

public class TaskDAO {

	//?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
	//?useSSL=false
	private String jdbcURL = "jdbc:mysql://localhost:3307/product_db?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	
	private static final String INSERT_TASKS_SQL = "INSERT INTO tasks_table" + " (task_name, task_type, task_status, task_duedate) VALUES " +
	" (?, ?, ?, ?);";
	
	private static final String SELECT_TASK_BY_ID = "select task_id, task_name, task_type, task_status, task_duedate from tasks_table where task_id = ?";
	private static final String SELECT_ALL_TASKS = "select * from tasks_table";
	private static final String DELETE_TASKS_SQL = "delete from tasks_table where task_id = ?;";
	private static final String UPDATE_TASKS_SQL = "update tasks_table set task_name = ?, task_type = ?, task_status = ?, task_duedate = ? where task_id = ?;";
	
	public TaskDAO() {	
	}
	
	// connecting to mysql db
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	// insert task
	public void insertTask(Task task) throws SQLException {
		System.out.println(INSERT_TASKS_SQL);
		try (Connection  connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TASKS_SQL)) {
			preparedStatement.setString(1, task.getTask_name());
			preparedStatement.setString(2, task.getTask_type());
			preparedStatement.setString(3, task.getTask_status());
			preparedStatement.setDate(4, task.getTask_duedate());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		} 
	}
	
	// select task by id
	public Task selectTask(int task_id) {
		Task task = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				
			// Step 2: Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TASK_BY_ID);) {
			preparedStatement.setInt(1, task_id);
			System.out.println(preparedStatement);
			
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			
			//Step 4: Process the ResultSet object
			while (rs.next()) {
				String task_name = rs.getString("task_name");
				String task_type = rs.getString("task_type");
				String task_status = rs.getString("task_status");
				Date task_duedate = rs.getDate("task_duedate");
				task = new Task(task_id, task_name, task_type, task_status, task_duedate);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return task;
	}
	
	// select all tasks
	public List<Task> selectAllTasks() {
		
		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Task> tasks = new ArrayList<>();
		
		// Step 1: Establishing a connection
		try (Connection connection = getConnection();
				
		// Step 2: Create a statement using connection object
		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TASKS);) {
		System.out.println(preparedStatement);
		
		// Step 3: Execute the query or update query
		ResultSet rs = preparedStatement.executeQuery();
		
		// Step 4: Process the ResultSet object
		while (rs.next()) {
			int task_id = rs.getInt("task_id");
			String task_name = rs.getString("task_name");
			String task_type = rs.getString("task_type");
			String task_status = rs.getString("task_status");
			Date task_duedate = rs.getDate("task_duedate");
			tasks.add(new Task(task_id, task_name, task_type, task_status, task_duedate));
			}
		
		} catch (SQLException e) {
			printSQLException(e);
		}
		return tasks;
	}
	
	// update task
	public boolean updateTask(Task task) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(UPDATE_TASKS_SQL);) {
			System.out.println("updated task: " + statement);
			statement.setString(1, task.getTask_name());
			statement.setString(2, task.getTask_type());
			statement.setString(3, task.getTask_status());
			statement.setDate(4, task.getTask_duedate());
			statement.setInt(5, task.getTask_id());
			
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;		
	}
	
	// delete task
	public boolean deleteTask(int task_id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_TASKS_SQL);) {
			statement.setInt(1, task_id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	
	// for debugging db-related issues
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}

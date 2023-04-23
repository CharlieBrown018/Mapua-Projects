package net.codejava.ws.web;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.text.SimpleDateFormat;
import java.text.ParseException;

import net.codejava.ws.bean.*;
import net.codejava.ws.dao.*;

/**
 * Servlet implementation class TaskServlet
 */
@WebServlet("/")
public class TaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TaskDAO taskDAO;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		taskDAO = new TaskDAO();
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		// actions
		switch(action)
		{
			case "/new":
			showNewForm(request, response);
			break;
			
			case "/insert":
			try {
				insertTask(request, response);
			} catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
			case "/delete":
			try {
				deleteTask(request, response);
			} catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
			case "/edit":
			try {
				showEditForm(request, response);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
			case "/update":
			try {
				updateTask(request, response);
			} catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
			default:
			try {
				listTask(request, response);
			} catch (SQLException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
	}
		
		// new form for creating task
		private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("task-form.jsp");
			dispatcher.forward(request, response);
		}
		
		// insert task
		private void insertTask(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
			String task_name = request.getParameter("task_name");
		    String task_type = request.getParameter("task_type");
		    String task_status = request.getParameter("task_status");
		    String task_duedate_str = request.getParameter("task_duedate");

		    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		    java.util.Date task_duedate = null;
		    try {
		        task_duedate = formatter.parse(task_duedate_str);
		    } catch (ParseException e) {
		        e.printStackTrace();
		    }

		    java.sql.Date sqlDate = new java.sql.Date(task_duedate.getTime());

		    Task newTask = new Task(task_name, task_type, task_status, sqlDate);

		    taskDAO.insertTask(newTask);
		    response.sendRedirect("list");
		}
		
		// delete task
		private void deleteTask(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
		{
			int task_id = Integer.parseInt(request.getParameter("task_id"));
			taskDAO.deleteTask(task_id);
			response.sendRedirect("list");
		}
		
		// edit task, "task" is a key to get existing user and write in table
		private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
			int task_id = Integer.parseInt(request.getParameter("task_id"));
			
			Task existingTask = taskDAO.selectTask(task_id);
			RequestDispatcher dispatcher = request.getRequestDispatcher("task-form.jsp");
			request.setAttribute("task", existingTask);
			dispatcher.forward(request, response);
		}
		
		// update task
		private void updateTask(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
		{
		    int task_id = Integer.parseInt(request.getParameter("task_id"));
		    String task_name = request.getParameter("task_name");
		    String task_type = request.getParameter("task_type");
		    String task_status = request.getParameter("task_status");
		    String task_duedate_str = request.getParameter("task_duedate");
		    Date task_duedate = null;
		    try {
		        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		        task_duedate = (Date) formatter.parse(task_duedate_str);
		    } catch (ParseException e) {
		        e.printStackTrace();
		    }

		    Task task = new Task(task_id, task_name, task_type, task_status, task_duedate);
		    taskDAO.updateTask(task);
		    response.sendRedirect("list");
		}
		
		// default action
		private void listTask(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException
		{
				List<Task> listTask = taskDAO.selectAllTasks();
				request.setAttribute("listTask", listTask);
				RequestDispatcher dispatcher = request.getRequestDispatcher("task-list.jsp"); //task-list.jsp
				dispatcher.forward(request, response);
		}
	}



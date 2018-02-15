package com.moss.project.eneasy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.compass.core.CompassDetachedHits;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.moss.project.eneasy.business.ITopicService;
import com.moss.project.eneasy.model.Topic;

/**
 * Servlet implementation class TopicServlet
 */
public class TopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ITopicService topicService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TopicServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		ApplicationContext context = WebApplicationContextUtils
				.getWebApplicationContext(getServletContext());
		topicService = (ITopicService) context.getBean("topicService");
		super.init();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		dispatchAction(request, response);
	}

	
	private void dispatchAction(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		String action = (String) request.getParameter("action");
		
		if (action.equals("add")) {
			addNewTopic(request, response);
		}
		else if (action.equals("viewWaitingTopics")) {
			viewWaitingTopics(request, response);
		}
		else if (action.equals("approve")) {
			approveTopic(request, response);
		}
		else if (action.equals("cancel")) {
			cancelTopic(request, response);
		}	
		else if (action.equals("search")) {
			searchTopic(request, response);
		}
		else if (action.equals("viewLastTopics")) {
			viewLastTopics(request, response);
		}		
		else if (action.equals("read")) {
			readTopic(request, response);
		}		
		else if (action.equals("viewMyTopics")) {
			viewMyTopics(request, response);
		}			
	}
	
	private void addNewTopic(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		topicService.addNewTopic(name,content);
		response.sendRedirect("pages/topic/insertSucc.jsp");
	}
	
	private void viewLastTopics(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		List<Topic> topics = topicService.readLastTopics();
		request.getSession().setAttribute("topics", topics);
//		request.setAttribute("topic", topics.get(4));
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}	
	
	private void approveTopic(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		String objid = request.getParameter("objid");
		topicService.approveTopic(objid);
		viewWaitingTopics(request, response);
	}
	
	private void cancelTopic(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		String objid = request.getParameter("objid");
		topicService.cancelTopic(objid);
		viewWaitingTopics(request, response);
	}	
	
	private void viewWaitingTopics(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		List<Topic> topics = topicService.readWaitingTopics();
		request.setAttribute("waitingTopics", topics);
		request.getRequestDispatcher("pages/admin/").forward(request, response);
	}	
	
	private void searchTopic(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		String title = request.getParameter("title");
		CompassDetachedHits topics = topicService.searchTopic(title);
		request.setAttribute("searchTopics", topics.getDatas());
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}		
	
	private void readTopic(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		String objid = request.getParameter("objid");
		Topic topic = topicService.readTopic(objid);
		request.setAttribute("topic", topic);
		request.getSession().setAttribute("myTopic", topic);
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

	private void viewMyTopics(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		List<Topic> topics = topicService.readMyTopics();
		request.setAttribute("myTopics", topics);
		request.getRequestDispatcher("my-page.jsp").forward(request, response);
	}
}

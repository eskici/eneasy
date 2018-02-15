package com.moss.project.eneasy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.moss.project.eneasy.business.IEntryService;
import com.moss.project.eneasy.business.ITopicService;
import com.moss.project.eneasy.model.Entry;
import com.moss.project.eneasy.model.Topic;

/**
 * Servlet implementation class EntryServlet
 */
public class EntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IEntryService entryService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EntryServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		ApplicationContext context = WebApplicationContextUtils
				.getWebApplicationContext(getServletContext());
		entryService = (IEntryService) context.getBean("entryService");
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
			addNewEntry(request, response);
		}
		if (action.equals("viewWaitingEntries")) {
			viewWaitingEntries(request, response);
		}
		if (action.equals("edit")) {
			updateEntry(request, response);
		}
		else if (action.equals("approve")) {
			approveEntry(request, response);
		}
		else if (action.equals("cancel")) {
			cancelEntry(request, response);
		}			
	}
	
	private void addNewEntry(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String content = request.getParameter("content");
		Topic topic = (Topic) request.getSession().getAttribute("myTopic");
		entryService.addNewEntry(topic,content);
		response.sendRedirect("pages/entry/insertSucc.jsp");
	}
	
	private void viewLastTopics(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
	}	
	
	private void viewWaitingEntries(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		List<Entry> entries = entryService.readWaitingEntrys();
		request.setAttribute("waitingEntries", entries);
		request.getRequestDispatcher("pages/admin/").forward(request, response);
	}
	
	private void viewMyEntries(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		List<Entry> entries= entryService.readMyEntries();
		request.setAttribute("entries", entries);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}	

	private void updateEntry(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		String content = request.getParameter("content");
		String objid = request.getParameter("objid");
		entryService.updateEntry(objid,content);
//		request.getRequestDispatcher("index.jsp").forward(request, response);
	}	
	
	private void approveEntry(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		String objid = request.getParameter("objid");
		entryService.approveEntry(objid);
		viewWaitingEntries(request, response);
	}
	
	private void cancelEntry(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		String objid = request.getParameter("objid");
		entryService.cancelEntry(objid);
		viewWaitingEntries(request, response);
	}		
}

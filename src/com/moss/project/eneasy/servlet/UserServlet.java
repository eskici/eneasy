package com.moss.project.eneasy.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.moss.project.eneasy.business.IUserService;
import com.moss.project.eneasy.business.MyCaptchaService;
import com.moss.project.eneasy.model.UserEntity;
import com.moss.project.eneasy.util.MyConstants;
import com.octo.captcha.service.CaptchaServiceException;

/**
 * Servlet implementation class UserEntityServlet
 */
public class UserServlet extends HttpServlet implements MyConstants {
	private static final long serialVersionUID = 1L;
	private IUserService userService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		ApplicationContext context = WebApplicationContextUtils
				.getWebApplicationContext(getServletContext());
		userService = (IUserService) context.getBean("userService");
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
			addNewUser(request, response);
		}
		else if (action.equals("view")) {
			viewWaitingUserEntitys(request, response);
		}
		else if (action.equals("approve")) {
			approveUserEntity(request, response);
		}
		else if (action.equals("cancel")) {
			cancelUserEntity(request, response);
		}	
		else if (action.equals("search")) {
			searchUserEntity(request, response);
		}
		else if (action.equals("viewLastUserEntitys")) {
			viewLastUserEntitys(request, response);
		}		
		else if (action.equals("read")) {
			readUserEntity(request, response);
		}		
		
	}
	
	private void addNewUser(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String userCaptchaResponse = request.getParameter("jcaptcha");
	    String captchaId = request.getSession().getId();

		boolean captchaPassed = false;
		
		try {
			captchaPassed = MyCaptchaService.getInstance().validateResponseForID(captchaId,
					userCaptchaResponse);
		} catch (CaptchaServiceException cse) {
		}
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		UserEntity user = new UserEntity(username, password, ROLE_USER, MyConstants.STATUS_WAITING,email);
		File image = null;
		image = new File(getServletContext().getRealPath ("images/user.jpg"));
		byte[] fileArray = FileCopyUtils.copyToByteArray(image);
		user.setAvatar(fileArray);
		   
		userService.addNewUserEntity(user);
		response.sendRedirect("pages/topic/view.jsp");
	}
	
	private void viewLastUserEntitys(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		List<UserEntity> topics = userService.readLastUserEntitys();
		request.setAttribute("topics", topics);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}	
	
	private void approveUserEntity(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String objid = request.getParameter("objid");
		userService.approveUserEntity(objid);
		response.sendRedirect("pages/topic/view.jsp");
	}
	
	private void cancelUserEntity(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String objid = request.getParameter("objid");
		userService.cancelUserEntity(objid);
		response.sendRedirect("pages/topic/view.jsp");
	}	
	
	private void viewWaitingUserEntitys(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		List<UserEntity> topics = userService.readWaitingUserEntitys();
		request.setAttribute("topics", topics);
		request.getRequestDispatcher("pages/topic/view.jsp").forward(request, response);
	}	
	
	private void searchUserEntity(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		String title = request.getParameter("title");
		List<UserEntity> topics = userService.searchUserEntity(title);
		request.setAttribute("topics", topics);
		request.getRequestDispatcher("pages/topic/view.jsp").forward(request, response);
	}		
	
	private void readUserEntity(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		String objid = request.getParameter("objid");
		UserEntity topic = userService.readUserEntity(objid);
		request.setAttribute("topic", topic);
		request.getSession().setAttribute("myUserEntity", topic);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}	
	
	public void getDynamicImage(HttpServletRequest request, HttpServletResponse response) {
		 ServletOutputStream out = null;
//		 try {
//			 request.get
//		     response.setContentType("multipart/form-data");
//		     out = response.getOutputStream();
//		     FsWareImages fsWareImage = fsWareImagesManager.get(imageId);
//		     out.write(fsWareImage.getImageData());
//		     out.flush();
//		 } catch (IOException e) {
//		     e.printStackTrace();
//		 } catch (Exception e) {
//		     e.printStackTrace();
//		 } finally {
//		     if (out != null)
//		     try {
//		         out.close();
//		     } catch (IOException e) {
//		         e.printStackTrace();
//		     }
//		 }
		}	
}

package com.validation.demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.javabean.demo.PersonalInfoBean;

public class PersonalInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PersonalInfoBean personalInfoBean = new PersonalInfoBean();
		personalInfoBean.setFirstName(request.getParameter("firstname"));
		personalInfoBean.setLastName(request.getParameter("lastname"));
		personalInfoBean.setGender(request.getParameter("gender"));
		
		String errors = "";
		if (checkFieldBlank(personalInfoBean.getFirstName())||!(matchField("^[A-Za-z][\\p{L} .'-]+$",personalInfoBean.getFirstName()))) {
			errors += "Enter a valid first name  <br/>";
		}
		if (checkFieldBlank(personalInfoBean.getLastName())||!(matchField("^[A-Za-z][\\p{L} .'-]+$",personalInfoBean.getFirstName()))) {
			errors += "Enter a valid last name <br/>";
		}
		
		if(checkFieldBlank(personalInfoBean.getGender())){
			errors +=" Select a gender <br/>";
		}
		
		if (checkFieldBlank(errors)) {
			HttpSession ses = request.getSession();
			ses.setAttribute("pInfo", personalInfoBean);
			response.sendRedirect("html/contactinfo.html");
		}
		
		else {

			request.setAttribute("errors", errors);
			RequestDispatcher rd = (RequestDispatcher) request.getRequestDispatcher("jsp/personalinfo.jsp");
			rd.forward(request, response);

		}
			
}
		
		private boolean checkFieldBlank(String fieldValue) {
			return fieldValue == null || fieldValue.length() == 0;
		}
		
		private boolean matchField(String regex, String entry){
			Pattern pattern = Pattern.compile(regex);
			
			Matcher matcher = pattern.matcher(entry);
			return (matcher.matches());
		}

}

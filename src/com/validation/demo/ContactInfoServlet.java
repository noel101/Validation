package com.validation.demo;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javabean.demo.PersonalInfoBean;

public class ContactInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PersonalInfoBean personalInfoBean = (PersonalInfoBean) request.getSession().getAttribute("pInfo");
		if (personalInfoBean == null) {
			personalInfoBean = new PersonalInfoBean(); /*
														 * if null, create a new
														 * PersonalInfoBean
														 * instance
														 */
		}
		// STEP 1:

		personalInfoBean.setAddress(request.getParameter("address"));
		personalInfoBean.setCity(request.getParameter("city"));
		personalInfoBean.setCountry(request.getParameter("country"));
		personalInfoBean.setState(request.getParameter("state"));
		personalInfoBean.setPhone(request.getParameter("phone"));

		String errors = "";
		if (checkFieldBlank(personalInfoBean.getAddress())
				|| !(matchField("^[A-Za-z0-9][\\p{L} .'-0-9]+$", personalInfoBean.getAddress()))) {
			errors += "Enter a valid Address  <br/>";
		}

		if (checkFieldBlank(personalInfoBean.getCity())
				|| !(matchField("^[\\p{L} .'-]+$", personalInfoBean.getCity()))) {
			errors += "Enter a valid City field  <br/>";
		}

		if (checkFieldBlank(personalInfoBean.getCountry())) {
			errors += " Country Field is left blank <br/>";
		}

		if (checkFieldBlank(personalInfoBean.getState())) {
			errors += " State Field is left blank <br/>";
		}

		if (checkFieldBlank(personalInfoBean.getPhone()) || (personalInfoBean.getPhone().length() != 10)||matchField("[0-9]",personalInfoBean.getPhone())) {
			errors += " Enter a valid phone number <br/>";
		}

		if (checkFieldBlank(errors)) {
			HttpSession ses = request.getSession();
			ses.setAttribute("pInfo", personalInfoBean);
			response.sendRedirect("html/bankinfo.html");
		}

		else {

			request.setAttribute("errors", errors);
			RequestDispatcher rd = (RequestDispatcher) request.getRequestDispatcher("jsp/contactinfo.jsp");
			rd.forward(request, response);

		}
	}

	private boolean checkFieldBlank(String fieldValue) {
		return fieldValue == null || fieldValue.length() == 0;
	}

	private boolean matchField(String regex, String entry) {
		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher(entry);
		return (matcher.matches());
	}

}

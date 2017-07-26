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

public class BankInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PersonalInfoBean personalInfoBean = (PersonalInfoBean) request.getSession().getAttribute("pInfo");
		if (personalInfoBean == null) {
			personalInfoBean = new PersonalInfoBean();
		}
		personalInfoBean.setBankName(request.getParameter("bankname"));
		personalInfoBean.setAccountNumber(request.getParameter("accountname"));
		personalInfoBean.setSsn(request.getParameter("ssn"));

		// valid ssn example: 856-45-6789

		String errors = "";
		if (checkFieldBlank(personalInfoBean.getBankName())) {
			errors += "Enter a Bank Name <br/>";
		}
		if (checkFieldBlank(personalInfoBean.getAccountNumber())
				|| (personalInfoBean.getAccountNumber().length() != 10)) {
			errors += "Enter a valid Account Number <br/>";
		}

		if (checkFieldBlank(personalInfoBean.getSsn())
				|| !(matchField("^(?!000|666)[0-8][0-9]{2}-(?!00)[0-9]{2}-(?!0000)[0-9]{4}$",
						personalInfoBean.getSsn()))) {
			errors += "Enter a valid SSN in this format ***-**-****   <br/>";
		}
		if (checkFieldBlank(errors)) {
			HttpSession ses = request.getSession();
			ses.setAttribute("pInfo", personalInfoBean);
			response.sendRedirect("jsp/outputsuccess.jsp");
		}

		else {

			request.setAttribute("errors", errors);
			RequestDispatcher rd = (RequestDispatcher) request.getRequestDispatcher("jsp/bankinfo.jsp");
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

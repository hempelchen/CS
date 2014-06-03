package com.chb.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class API
 */
public class Common extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String postType = "";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Common() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter returnHTML;
		readForm(request);
		response.setContentType("text/html;charset=utf-8");
		returnHTML = response.getWriter();
		returnHTML.println("<html><head><title>");
		returnHTML.println("API Common servlet (Get)");
		returnHTML.println("</title></head><body>");
		returnHTML.println("<h2> Welcome from Get! Greetings," + "this is you servlet answering.</h2></body></html>");
		returnHTML.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter returnHTML;
		returnHTML = response.getWriter();
		readForm(request);
		if( postType.equals("html")) {
			response.setContentType("text/html;charset=utf-8");
			returnHTML.println("<html><head><title>");
			returnHTML.println("API Common servlet (Post)");
			returnHTML.println("</title></head><body>");
			returnHTML.println("<h2>Welcome from Post! Greetings," + "this is you servlet answering.</h2></body></html>");		
		} else if (postType.equals("json")){
			response.setContentType("application/json");
			String jsonTest="[{\"Id\":\"101\",\"number\":\"790319\"},{\"Id\":\"102\",\"number\":\"830426\"}]";
			returnHTML.println(jsonTest);
		}
		returnHTML.close();
	}
	
    /** 
     * 获取表单参数 
     */  
    private void readForm(HttpServletRequest request) {  
        // TODO Auto-generated method stub  
        Enumeration e = request.getParameterNames();  
        while (e.hasMoreElements()) {  
            String parameterName = (String) e.nextElement();  
            String parameterValue= request.getParameter(parameterName);  
//            request.setAttribute(parameterName, parameterValue);  
            if(parameterName.equals("type")) {
            	postType = parameterValue;
            }
        }  
          
    }  

}

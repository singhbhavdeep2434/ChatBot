package com.bhavdeep;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class ChatbotService extends HttpServlet {
	
    private static final long serialVersionUID = 1L;
	
    private static Map<String, String> responseMap = new HashMap<>();
    
    
    static {
        responseMap.put("1", "1 is pressed");
        responseMap.put("2", "2 is pressed");
        responseMap.put("3", "3 is pressed");  // Fixed the key here
        responseMap.put("4", "4 is pressed");
        responseMap.put("5", "5 is pressed");
    }

    public static String getResponse(String userQuery) {
        return responseMap.getOrDefault(userQuery, "Sorry, I don't understand that question.");
    }

    public ChatbotService() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String userQuery = request.getParameter("userQuery");
        String chatbotResponse = getResponse(userQuery);

        request.setAttribute("response", chatbotResponse);
        request.getRequestDispatcher("/chatbot.jsp").forward(request, response);
    }
}

<%@ page import="java.util.*, java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>AI Chatbot</title>
</head>
<body>
    <h2>AI Chatbot Simulation</h2>
    <form action="ChatBotServlet" method="post">
        <label>Ask a question:</label>
        <input type="text" name="userQuery" />
        <input type="submit" value="Submit" />
    </form>
    
    <h3>Chatbot Response:</h3>
    <p>${response}</p> <!-- JSP EL to display chatbot response -->
</body>
</html>





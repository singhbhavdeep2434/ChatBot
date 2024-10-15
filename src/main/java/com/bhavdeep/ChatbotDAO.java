package com.bhavdeep;

import java.sql.Timestamp;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class ChatbotDAO {

    
    public static void saveConversation(String userQuery, String chatbotResponse) {
       
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Conversation conversation = new Conversation();
        conversation.setUserQuery(userQuery);
        conversation.setChatbotResponse(chatbotResponse);
        conversation.setTimestamp(new Timestamp(System.currentTimeMillis()));

        session.save(conversation);
        tx.commit();
        session.close();
    }
}

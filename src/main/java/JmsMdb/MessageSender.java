/*
package JmsMdb;

import com.google.protobuf.Message;
import com.mysql.cj.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {
    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage(final String message)
    {

        jmsTemplate.send(new MessageCreator()
        {
            public Message createMessage(Session session) throws JMSException
            {
                ObjectMessage objectMessage = session.createObjectMessage(message);
                return objectMessage;
            }
        });
    }
}
*/

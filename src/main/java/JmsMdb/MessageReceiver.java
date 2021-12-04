/*
package JmsMdb;

import com.mysql.cj.protocol.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {
    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    MessageConverter messageConverter;

    public String receiveMessage()
    {
        try
        {
            */
/*
             * Here we receive the message.
             *//*

            Message message = jmsTemplate.receive();
            String response = (String) messageConverter.fromMessage(message);
            return response;

        }
        catch (Exception exe)
        {
            exe.printStackTrace();
        }

        return null;
    }
}
*/

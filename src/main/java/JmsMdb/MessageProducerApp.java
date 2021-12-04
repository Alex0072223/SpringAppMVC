/*
package JmsMdb;

import com.mysql.cj.protocol.MessageSender;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MessageProducerApp {

    public static void main(String[] args)
    {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(
                AppConfig.class);
        MessageSender messageSender = context.getBean(MessageSender.class);



        messageSender.sendMessage("Light containment zone is lockdown and ready for decontamination, the remove of all organic
               substances has now begun");


        System.out.println("Message has been sent successfully...");

        ((AbstractApplicationContext) context).close();
    }

}
*/

/*
package JmsMdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

// через @Import подключаем к проекту

@Configuration
public class MessageConfig {
    private static final String DEFAULT_BROKER_URL = "http://localhost:8080";
    private static final String MESSAGE_QUEUE = "message_queue";

    @Autowired
    MessageReceiver messageReceiver;

    @Bean
    public ConnectionFactory connectionFactory()
    {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(DEFAULT_BROKER_URL);
        connectionFactory.setTrustedPackages(Arrays.asList("название директории"));
        return connectionFactory;
    }

    */
/*
     * Used here for Sending Messages.
     *//*

    @Bean
    public JmsTemplate jmsTemplate()
    {
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory());
        template.setDefaultDestinationName(MESSAGE_QUEUE);
        return template;
    }

    @Bean
    MessageConverter converter()
    {
        return new SimpleMessageConverter();
    }
}
*/

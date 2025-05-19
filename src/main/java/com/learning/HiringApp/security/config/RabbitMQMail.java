    package com.learning.HiringApp.security.config;

    import org.springframework.amqp.rabbit.core.RabbitTemplate;
    import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
    import org.springframework.amqp.support.converter.MessageConverter;
    import org.springframework.context.annotation.Bean;
    import org.springframework.amqp.core.*;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.amqp.rabbit.connection.ConnectionFactory;


    @Configuration
    public class RabbitMQMail {

//        //rabbitmq->producer->consumer->emailservice
//
//        // for mailing (candidate status updates)
//        public static final String QUEUE_NAME = "myQueue";
//        public static final String EXCHANGE = "myExchange";
//        public static final String ROUTING_KEY = "myRoutingKey";
//
//        @Bean
//        public Queue queue() {
//            return new Queue(QUEUE_NAME, true); // durable queue
//        }
//
//        @Bean
//        public DirectExchange exchange() {
//            return new DirectExchange(EXCHANGE);
//        }
//
//        @Bean
//        public Binding binding(Queue queue, DirectExchange exchange) {
//            return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
//        }

        // OTP queue and exchange
        public static final String OTP_QUEUE = "hiringAuthOtpQueue";
        public static final String OTP_EXCHANGE = "hiringAuthOtpTopicExchange";
        public static final String OTP_ROUTING_KEY = "auth.otp";

        @Bean
        public Queue otpQueue() {
            return new Queue(OTP_QUEUE, true); // durable queue
        }

        @Bean
        public TopicExchange otpExchange() {
            return new TopicExchange(OTP_EXCHANGE);
        }

        @Bean
        public Binding otpBinding(Queue otpQueue, TopicExchange otpExchange) {
            return BindingBuilder.bind(otpQueue).to(otpExchange).with(OTP_ROUTING_KEY);
        }

        // for document
        public static final String DOCUMENT_QUEUE = "document.queue";
        public static final String DOCUMENT_EXCHANGE = "document.exchange";
        public static final String DOCUMENT_ROUTING_KEY = "document.routingKey";

        @Bean
        public Queue documentQueue() {
            return new Queue(DOCUMENT_QUEUE);
        }

        @Bean
        public TopicExchange documentExchange() {
            return new TopicExchange(DOCUMENT_EXCHANGE);
        }

        @Bean
        public Binding documentBinding(Queue documentQueue, TopicExchange documentExchange) {
            return BindingBuilder.bind(documentQueue).to(documentExchange).with(DOCUMENT_ROUTING_KEY);
        }

        // for deserialization so RabbitMQ can process it
        @Bean
        public MessageConverter jsonMessageConverter() {
            return new Jackson2JsonMessageConverter();
        }

//        @Bean
//        public AmqpTemplate amqpTemplate(org.springframework.amqp.rabbit.connection.ConnectionFactory connectionFactory) {
//            RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
//            rabbitTemplate.setMessageConverter(jsonMessageConverter());
//            return rabbitTemplate;
//        }
@Bean
public RabbitTemplate rabbitTemplate(ConnectionFactory cf) {
    RabbitTemplate tpl = new RabbitTemplate(cf);
    tpl.setMessageConverter(jsonMessageConverter());
    return tpl;
}
    }
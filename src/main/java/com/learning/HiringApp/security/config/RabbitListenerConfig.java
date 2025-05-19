//    package com.learning.HiringApp.security.config;
//
//
//    import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//    import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
//    import org.springframework.context.annotation.Bean;
//    import org.springframework.context.annotation.Configuration;
//
//    @Configuration
//    public class RabbitListenerConfig {
//
//        @Bean
//        public org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory<?> rabbitListenerContainerFactory(
//                ConnectionFactory connectionFactory,
//                Jackson2JsonMessageConverter jsonMessageConverter) {
//
//            var factory = new org.springframework.amqp.rabbit.listener.SimpleRabbitListenerContainerFactory();
//            factory.setConnectionFactory(connectionFactory);
//            factory.setMessageConverter(jsonMessageConverter);
//            factory.setDefaultRequeueRejected(false);
//            factory.setPrefetchCount(5);
//            return factory;
//        }
//
//    }
//

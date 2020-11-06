package com.ynov.nantes.soap;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;


/**
 * Classe de configuration du WebService.
 * 
 * @author Matthieu BACHELIER
 * @since 2020-10
 * @version 1.0
 */
//@EnableWs
@Configuration
public class WebServiceConfig {
    
    /*@Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(
            ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<MessageDispatcherServlet>(servlet, "/ws/*");
    }

    ///

    @Bean(name = "author")
    public DefaultWsdl11Definition authorsWsdl11Definition(XsdSchema authorsSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("AuthorPort");
        wsdl11Definition.setLocationUri("/ws/author");
        wsdl11Definition.setTargetNamespace("http://nantes.ynov.com/soap/author");
        wsdl11Definition.setSchema(authorsSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema authorsSchema() {
        return new SimpleXsdSchema(new ClassPathResource("author.xsd"));
    }

    ///

    @Bean(name = "book")
    public DefaultWsdl11Definition booksWsdl11Definition(XsdSchema booksSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("BookPort");
        wsdl11Definition.setLocationUri("/ws/book");
        wsdl11Definition.setTargetNamespace("http://nantes.ynov.com/soap/book");
        wsdl11Definition.setSchema(booksSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema booksSchema() {
        return new SimpleXsdSchema(new ClassPathResource("book.xsd"));
    }*/
}

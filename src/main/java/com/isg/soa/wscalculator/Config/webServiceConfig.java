package com.isg.soa.wscalculator.Config;


import com.isg.soa.wscalculator.EndPoint.calulatorEndPoint;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
import javax.servlet.Servlet;

@EnableWs
@Configuration
public class webServiceConfig {
        @Bean
        //The ApplicationContext interface provides the getBean()
        // method to retrieve bean from the spring container.
        //
        public ServletRegistrationBean<Servlet> messageDispatcherServet(ApplicationContext appCtx){
            //MessageDispatcherServlet is the core component of Spring-WS.
            // With simple configuration, a Web-Service can be set up in minutes.
            MessageDispatcherServlet servlet =new MessageDispatcherServlet();
            servlet.setApplicationContext(appCtx);
            servlet.setTransformWsdlLocations(true);
            return new ServletRegistrationBean<Servlet>(servlet, "/simpleCalculator/*");
        }
        @Bean(name="calculator")
        public Wsdl11Definition defaultWsdlDefinition(XsdSchema calculatorSchema){
            DefaultWsdl11Definition wsdef=new DefaultWsdl11Definition();
            wsdef.setPortTypeName("calculator");
            wsdef.setLocationUri("/simpleCalculator");
            wsdef.setTargetNamespace(calulatorEndPoint.NAMESPACE_URI);
            wsdef.setSchema(calculatorSchema);
            return wsdef;
        }
        @Bean
        public XsdSchema promotionSchema(){
            return new SimpleXsdSchema(new ClassPathResource("Calculator.xsd"));
        }

    }

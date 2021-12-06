package de.marcnow.coronaService.soap;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import coronaservice_grp6.GetCovidKeyIndicatorsRequest;
import coronaservice_grp6.GetCovidKeyIndicatorsResponse;

/**
* This class creates the web service to access our .wsdl file
* @author Niklas Frochte
* @version 1.0
*/

@EnableWs
@Configuration
public class WebServiceConfig {
	
	/**
	 * This method identifies the path to access the .wsdl file
	 * @param context
	 * @return the servlet registration bean 
	 */
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
		MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
		messageDispatcherServlet.setApplicationContext(context);
		messageDispatcherServlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(messageDispatcherServlet, "/soapservice/*");
	}
	/**
	 * This method invokes when /soapservice/covidkeyindicators.wsdl is called
	 * @param covidKeyIndicatorsSchema
	 * @return a default wsdl definition
	 */
	@Bean(name = "covidkeyindicators")
	public DefaultWsdl11Definition defaultWsdl11Definition (XsdSchema covidKeyIndicatorsSchema) {
		
		DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
		definition.setPortTypeName("CovidKeyIndicatorsPort");
		definition.setTargetNamespace("coronaservice-grp6");
		definition.setLocationUri("/soapservice");
		definition.setSchema(covidKeyIndicatorsSchema);
		return definition;
	}
	
	/**
	 * @return a xsd schema
	 */
	@Bean
	public XsdSchema covidKeyIndicatorsSchema() {
		return new SimpleXsdSchema(new ClassPathResource("covidkeyindicators.xsd"));
	}
}

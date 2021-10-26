package com.example.config;

import com.example.rest.MyRestService;
import com.example.soap.MySuperSoapService;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;
import java.util.Arrays;

@Configuration
public class WebConfiguration {
    @Autowired
    private SpringBus bus;

    @Autowired
    private MySuperSoapService mySuperSoapService;

    @Autowired
    private MyRestService myRestService;

    @Bean
    public Endpoint getStudentEndPoint(){
        EndpointImpl endpoint=new EndpointImpl(bus,mySuperSoapService);
        endpoint.publish("/student");
        return endpoint;
    }

    @Bean
    public Server rsServer() {
        JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
        endpoint.setBus(bus);
        endpoint.setAddress("/");
        endpoint.setServiceBeans(Arrays.asList(myRestService));
        endpoint.setProvider(new JacksonJaxbJsonProvider());
        return endpoint.create();
    }

}

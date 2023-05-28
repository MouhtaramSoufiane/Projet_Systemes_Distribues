package org.sid.microserviceimmatri.web.soap;




import lombok.AllArgsConstructor;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

 @Configuration
 @AllArgsConstructor
public class CxfConfig {
  private Bus bus;
  private OwnerSoapService ownerSoapService;

 @Bean
  public EndpointImpl endpoint(){
      EndpointImpl endpoint=new EndpointImpl(bus,ownerSoapService);
      endpoint.publish("/OwnerService");
      return endpoint;
  }

}

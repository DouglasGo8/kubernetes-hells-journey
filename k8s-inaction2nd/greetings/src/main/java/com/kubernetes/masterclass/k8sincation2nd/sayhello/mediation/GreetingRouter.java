package com.kubernetes.masterclass.k8sincation2nd.sayhello.mediation;

import com.kubernetes.masterclass.k8sincation2nd.sayhello.service.GreetingService;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.NoArgsConstructor;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

@ApplicationScoped
@NoArgsConstructor
public class GreetingRouter extends RouteBuilder {

  @Override
  public void configure() throws Exception {

    //final String hostname = ;

    from("direct:saysHi").routeId("SayHi")
            .log(LoggingLevel.INFO, "direct:saysHi fired")
            .transform(method(GreetingService.class))
            //.marshal().json(JsonLibrary.Jackson)
            .end();
  }
}

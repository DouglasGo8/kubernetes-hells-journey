package com.kubernetes.hells.journey.b01.k8sincation2nd.sayhello.mediation;

import com.kubernetes.hells.journey.b01.k8sincation2nd.sayhello.service.GreetingService;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.NoArgsConstructor;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;

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

package com.kubernetes.hells.journey.b01.k8sincation2nd.sayhello.mediation;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.NoArgsConstructor;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

import java.net.InetAddress;

@ApplicationScoped
@NoArgsConstructor
public class GreetingRouter extends RouteBuilder {

  @Override
  public void configure() throws Exception {

    final String hostname = InetAddress.getLocalHost().getHostName();

    from("direct:saysHi").routeId("SayHi")
            .log(LoggingLevel.INFO, "direct:saysHi fired")
            .transform(simple("Hi, ${header.name} you're hosted in ".concat(hostname)))
            .end();
  }
}

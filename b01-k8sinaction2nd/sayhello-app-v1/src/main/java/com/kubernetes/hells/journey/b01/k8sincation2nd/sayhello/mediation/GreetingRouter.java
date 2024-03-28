package com.kubernetes.hells.journey.b01.k8sincation2nd.sayhello.mediation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.NoArgsConstructor;
import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.health.HealthCheck;
import org.apache.camel.health.HealthCheckHelper;

import java.net.InetAddress;
import java.util.Collection;

import static org.apache.camel.Exchange.CONTENT_TYPE;
import static org.apache.camel.Exchange.HTTP_RESPONSE_CODE;

@ApplicationScoped
@NoArgsConstructor
public class GreetingRouter extends RouteBuilder {

  @Override
  public void configure() throws Exception {

    final String hostname = InetAddress.getLocalHost().getHostName();

    from("direct:saysHi").routeId("SayHi")
            .log(LoggingLevel.INFO, "direct:saysHi fired")
            .transform(simple("Hi ${header.name} we are now in ".concat(hostname)))
            .end();
  }
}

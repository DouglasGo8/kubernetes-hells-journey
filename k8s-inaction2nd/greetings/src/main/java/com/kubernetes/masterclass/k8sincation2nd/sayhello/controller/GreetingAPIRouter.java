package com.kubernetes.masterclass.k8sincation2nd.sayhello.controller;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.NoArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.health.DefaultHealthCheckRegistry;
import org.apache.camel.impl.health.RoutesHealthCheckRepository;
import org.apache.camel.model.rest.RestBindingMode;

@ApplicationScoped
@NoArgsConstructor
public class GreetingAPIRouter extends RouteBuilder {

  @Override
  public void configure() throws Exception {


    restConfiguration().component("netty-http")
            // ---------- CONTEXT PATH BEGIN ---------------------
            .contextPath("/api")
            // ---------- CONTEXT PATH END -----------------------
            .dataFormatProperty("prettyPrint", "true")
            .host("0.0.0.0").port("{{server.port}}").bindingMode(RestBindingMode.auto);

    rest().path("/greeting/")
              .get("/{name}")
                .to("direct:saysHi");
  }
}

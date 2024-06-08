package com.kubernetes.hells.journey.b01.k8sincation2nd.mongodb.mediation;

import com.mongodb.client.model.Filters;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.NoArgsConstructor;
import org.apache.camel.Exchange;
import org.apache.camel.Expression;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mongodb.MongoDbConstants;

@ApplicationScoped
@NoArgsConstructor
public class GreetingMediationRouter extends RouteBuilder {
  @Override
  public void configure() {


    from("direct:sayHi").routeId("GreetingMediationRouteId")
            //.setHeader(MongoDbConstants.CRITERIA, Filters.eq("fname", "${header.name}"))
            //.setBody(constant("{}"))
            .setHeader(MongoDbConstants.CRITERIA, new Expression() {
              @Override
              public <T> T evaluate(Exchange exchange, Class<T> type) {
                var name = exchange.getIn().getHeader("name", String.class);
                var equalsClause = Filters.eq("fname", name);
                //
                return exchange.getContext().getTypeConverter().convertTo(type, equalsClause);
              }
            })
            .to("{{mongodb-query}}")
            .log("${body}");

  }
}

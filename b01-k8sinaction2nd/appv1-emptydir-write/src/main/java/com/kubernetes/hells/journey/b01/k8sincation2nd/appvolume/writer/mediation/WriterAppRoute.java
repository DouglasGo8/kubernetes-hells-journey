package com.kubernetes.hells.journey.b01.k8sincation2nd.appvolume.writer.mediation;

import com.kubernetes.hells.journey.b01.k8sincation2nd.appvolume.writer.model.Quotes;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.NoArgsConstructor;
import org.apache.camel.builder.AggregationStrategies;
import org.apache.camel.builder.RouteBuilder;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

@NoArgsConstructor
@ApplicationScoped
public class WriterAppRoute extends RouteBuilder {
  @Override
  public void configure() {

    from("timer://writerApp?fixedRate=true&period=2s")
            .bean(Quotes::new)
            .process(e-> Files.deleteIfExists(Paths.get("/tmp/lost/input/quotes.txt")))
            .aggregate(constant(true), AggregationStrategies.flexible().accumulateInCollection(ArrayList.class))
              .completionSize(5)
            .split(body()).convertBodyTo(String.class)
              .to("file:///tmp/lost/input/?fileName=quotes.txt&fileExist=Append")
            .end();
  }
}

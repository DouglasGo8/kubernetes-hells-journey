package com.kubernetes.hells.journey.b01.k8sincation2nd.appvolume.writer.mediation;

import com.kubernetes.hells.journey.b01.k8sincation2nd.appvolume.writer.model.Quotes;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.NoArgsConstructor;
import org.apache.camel.builder.RouteBuilder;

@NoArgsConstructor
@ApplicationScoped
public class WriterAppRoute extends RouteBuilder {
  @Override
  public void configure() {


    from("timer://writerApp?fixedRate=true&period=10s")
            .bean(Quotes::new)
            //.log("${body}")
            .to("file:///tmp/lost/?fileName=quotes.txt&fileExist=Override")
            //.log("done")
            .end();

  }
}

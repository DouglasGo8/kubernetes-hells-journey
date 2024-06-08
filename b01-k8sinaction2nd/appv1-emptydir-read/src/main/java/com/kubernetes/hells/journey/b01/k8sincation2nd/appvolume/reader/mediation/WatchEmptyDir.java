package com.kubernetes.hells.journey.b01.k8sincation2nd.appvolume.reader.mediation;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.NoArgsConstructor;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

@ApplicationScoped
@NoArgsConstructor
public class WatchEmptyDir extends RouteBuilder {
  @Override
  public void configure() {

    from("file-watch:///tmp/lost?events=CREATE,MODIFY&antInclude=**/*.txt&recursive=false")
            .log(LoggingLevel.INFO, "!!!FIRED!!!")
            //.log(LoggingLevel.INFO, "${header.CamelFileParent}")
            //.setVariable("fileName", simple("${header.CamelFileAbsolutePath}"))
            //.log("File event: ${header.CamelFileEventType} occurred on file ${header.CamelFileName} at ${header.CamelFileLastModified}")
            .pollEnrich()
              .simple("file://${header.CamelFileParent}?fileName=${header.CamelFileName}")
              .log(LoggingLevel.INFO,"${body}")
            .end();
  }
}

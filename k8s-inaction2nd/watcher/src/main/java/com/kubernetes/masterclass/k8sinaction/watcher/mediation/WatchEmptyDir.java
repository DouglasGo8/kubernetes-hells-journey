package com.kubernetes.masterclass.k8sinaction.watcher.mediation;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.NoArgsConstructor;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;


@ApplicationScoped
@NoArgsConstructor
public class WatchEmptyDir extends RouteBuilder {
  @Override
  public void configure() {

    // We can use a different dir (output), but we need the same volume Pod as target
    from("file-watch:///tmp/lost/output?events=CREATE&antInclude=**/*.txt&recursive=false")
            //.log(LoggingLevel.INFO, "------------------------------------------------------------------------")
            .enrich()
              .simple("file://${header.CamelFileParent}?fileName=${header.CamelFileName}")
              .split(body()).streaming()
                .log(LoggingLevel.INFO, "${body}\\n")
            .end()
            //.process(e -> Files.walk(Paths.get("/tmp/lost/output"), 1)
            //        .filter(Files::isRegularFile)
            //       .map(Path::toFile)
            //        .forEach(File::delete))
            //.log(LoggingLevel.INFO, "------------------------------------------------------------------------")
            .end();
  }
}

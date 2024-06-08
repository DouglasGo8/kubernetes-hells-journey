package com.kubernetes.hells.journey.b01.k8sincation2nd.appvolume.writer;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.apache.camel.quarkus.main.CamelMainApplication;

@QuarkusMain
public class AppEmptyDirWrite {
  public static void main(String... args) {
    Quarkus.run(CamelMainApplication.class, args);
  }
}

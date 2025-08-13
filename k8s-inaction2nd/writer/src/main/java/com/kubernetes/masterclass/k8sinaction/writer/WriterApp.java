package com.kubernetes.masterclass.k8sinaction.writer;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.apache.camel.quarkus.main.CamelMainApplication;

@QuarkusMain
public class WriterApp {
  public static void main(String... args) {
    Quarkus.run(CamelMainApplication.class, args);
  }
}

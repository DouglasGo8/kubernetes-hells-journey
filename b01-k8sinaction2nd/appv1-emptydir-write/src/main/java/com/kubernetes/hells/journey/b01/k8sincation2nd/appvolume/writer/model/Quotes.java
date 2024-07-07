package com.kubernetes.hells.journey.b01.k8sincation2nd.appvolume.writer.model;

import jakarta.inject.Singleton;
import lombok.NoArgsConstructor;
import org.apache.camel.Handler;

import java.util.concurrent.ThreadLocalRandom;

@Singleton
@NoArgsConstructor
public class Quotes {

  final String[] quotes = new String[]{
          "I drink too much.\n",
          "My psychiatrist told me I was crazy.\n",
          "I am not afraid of an army of lions led by a sheep.\n",
          "Management is doing things right.\n",

  };

  @Handler
  public String randomQuotes() {
    return quotes[ThreadLocalRandom.current().nextInt(0, quotes.length)];
  }
}

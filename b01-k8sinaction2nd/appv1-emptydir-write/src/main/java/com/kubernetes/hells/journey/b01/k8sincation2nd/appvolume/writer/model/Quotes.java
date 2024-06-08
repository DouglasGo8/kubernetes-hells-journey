package com.kubernetes.hells.journey.b01.k8sincation2nd.appvolume.writer.model;

import jakarta.inject.Singleton;
import lombok.NoArgsConstructor;
import org.apache.camel.Handler;

import java.util.concurrent.ThreadLocalRandom;

@Singleton
@NoArgsConstructor
public class Quotes {

  final String[] quotes = new String[]{
          "I drink too much. The last time I gave a urine sample it had an olive in it.",
          "My psychiatrist told me I was crazy and I said I want a second opinion. He said okay, you're ugly too",
          "I am not afraid of an army of lions led by a sheep; I am afraid of an army of sheep led by a lion.",
          "Management is doing things right; leadership is doing the right things.",

  };

  @Handler
  public String randomQuotes() {
    return quotes[ThreadLocalRandom.current().nextInt(0, quotes.length)];
  }
}

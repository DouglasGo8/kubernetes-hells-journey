package com.kubernetes.hells.journey.b01.k8sincation2nd.sayhello.service;

import com.kubernetes.hells.journey.b01.k8sincation2nd.sayhello.model.Greeting;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.apache.camel.Handler;
import org.apache.camel.Header;

import java.net.InetAddress;

@NoArgsConstructor
@ApplicationScoped
public class GreetingService {

  @Handler
  @SneakyThrows
  public Greeting sayHi(@Header("name") String name) {
    var message = "Hi " + name + " from " + InetAddress.getLocalHost().getHostName();
    return new Greeting(message);
  }

}

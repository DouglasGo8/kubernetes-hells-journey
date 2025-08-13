package com.kubernetes.masterclass.k8sincation2nd.sayhello.model;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public record Greeting(String name) {
}

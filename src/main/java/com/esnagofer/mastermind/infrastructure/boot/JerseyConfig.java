package com.esnagofer.mastermind.infrastructure.boot;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.esnagofer.mastermind.infrastructure.adapter.rest.jaxrs.HelloWorldEndpoint;
import com.esnagofer.mastermind.infrastructure.adapter.rest.jaxrs.codemaker.CodeMakerApi;

/**
 * The Class JerseyConfig.
 */
@Component
public class JerseyConfig extends ResourceConfig {
    
    /**
     * Instantiates a new jersey config.
     */
    public JerseyConfig() {
        registerEndpoints();
    }
    
    /**
     * Register endpoints.
     */
    private void registerEndpoints() {
        register(HelloWorldEndpoint.class);
        register(CodeMakerApi.class);
    }
    
}
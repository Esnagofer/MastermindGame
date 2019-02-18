package com.esnagofer.mastermind.infrastructure.adapter.rest.jaxrs;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.springframework.stereotype.Component;

/**
 * The Class RestApplication.
 */
@Component
@ApplicationPath("/mastermind")
public class RestApplication extends Application {}
 
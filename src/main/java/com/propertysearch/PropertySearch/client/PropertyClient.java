package com.propertysearch.PropertySearch.client;

import com.propertysearch.PropertySearch.model.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
public class PropertyClient {

    private final WebClient webClient;

    @Autowired
    public PropertyClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8083").build();
    }

    public Flux<Property> getProperties() {
        return webClient.get()
                .uri("/properties")
                .retrieve()
                .bodyToFlux(Property.class);
    }
}
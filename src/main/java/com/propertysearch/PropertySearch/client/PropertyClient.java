package com.propertysearch.PropertySearch.client;

import com.propertysearch.PropertySearch.model.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

//responsible for making HTTP requests to the property listing API and retrieving property data.
@Component
public class PropertyClient {

    private final WebClient webClient;

    @Autowired
    public PropertyClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://propertylistingfinal-production.up.railway.app").build();
    }

    //retrieves list of properties from the property listing API using a WebClient.
    public Flux<Property> getProperties() {
        return webClient.get()
                .uri("/properties")
                .retrieve()
                .bodyToFlux(Property.class);
    }
}
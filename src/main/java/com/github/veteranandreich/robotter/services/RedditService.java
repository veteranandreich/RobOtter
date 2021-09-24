package com.github.veteranandreich.robotter.services;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import javax.annotation.ParametersAreNonnullByDefault;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.veteranandreich.robotter.config.Config;
import com.github.veteranandreich.robotter.dto.ChatDto;
import com.github.veteranandreich.robotter.exceptions.ResponseStatusException;
import com.github.veteranandreich.robotter.lambdas.RandomRedditLambda;
import com.github.veteranandreich.robotter.models.RedditMemeContainer;

/**
 * Service for getting Reddit memes
 */
@ParametersAreNonnullByDefault
public class RedditService {
    private static final String MEME_ENDPOINT = "https://meme-api.herokuapp.com/gimme/";

    private final HttpClient httpClient;

    public RedditService() {
        this.httpClient = HttpClient.newHttpClient();
    }

    /**
     * Get random meme
     * @return Optional.empty() - if request wasn't successful, otherwise {@link RedditMemeContainer}
     */
    public Optional<RedditMemeContainer> getMemes(int count) {
        try {
            HttpRequest request = buildRequest(MEME_ENDPOINT, count);
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                throw new ResponseStatusException("Response status code is not 200");
            }

            ObjectMapper mapper = Config.getObjectMapper();

            return Optional.of(mapper.readValue(response.body(), RedditMemeContainer.class));
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    private HttpRequest buildRequest(String url, int count) throws URISyntaxException {
        return HttpRequest.newBuilder()
                .uri(new URI(url + count))
                .timeout(Duration.of(10, ChronoUnit.SECONDS))
                .GET()
                .build();
    }
}

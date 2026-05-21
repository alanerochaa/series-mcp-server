package br.com.alane.tvmaze_mcp.client;

import br.com.alane.tvmaze_mcp.dto.tvmaze.TvMazeSearchResponse;
import br.com.alane.tvmaze_mcp.dto.tvmaze.TvMazeShowDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
public class TvMazeClient {

    private final WebClient tvMazeWebClient;

    public TvMazeClient(WebClient tvMazeWebClient) {
        this.tvMazeWebClient = tvMazeWebClient;
    }

    public List<TvMazeSearchResponse> buscarSeriesPorTitulo(String titulo) {
        return tvMazeWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/search/shows")
                        .queryParam("q", titulo)
                        .build())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<TvMazeSearchResponse>>() {})
                .block();
    }

    public TvMazeShowDto buscarSeriePorId(Integer id) {
        return tvMazeWebClient.get()
                .uri("/shows/{id}", id)
                .retrieve()
                .bodyToMono(TvMazeShowDto.class)
                .block();
    }
}
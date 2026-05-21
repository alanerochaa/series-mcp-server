package br.com.alane.tvmaze_mcp.service.impl;

import br.com.alane.tvmaze_mcp.client.TvMazeClient;
import br.com.alane.tvmaze_mcp.dto.response.SerieDetalheResponse;
import br.com.alane.tvmaze_mcp.dto.response.SerieResumoResponse;
import br.com.alane.tvmaze_mcp.dto.tvmaze.TvMazeSearchResponse;
import br.com.alane.tvmaze_mcp.dto.tvmaze.TvMazeShowDto;
import br.com.alane.tvmaze_mcp.service.SerieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieServiceImpl implements SerieService {

    private final TvMazeClient tvMazeClient;

    public SerieServiceImpl(TvMazeClient tvMazeClient) {
        this.tvMazeClient = tvMazeClient;
    }

    @Override
    public List<SerieResumoResponse> buscarPorTitulo(String titulo) {
        return tvMazeClient.buscarSeriesPorTitulo(titulo)
                .stream()
                .map(TvMazeSearchResponse::show)
                .map(show -> new SerieResumoResponse(
                        show.id(),
                        show.name(),
                        extrairAno(show.premiered()),
                        limparHtml(show.summary())
                ))
                .toList();
    }

    @Override
    public SerieDetalheResponse buscarDetalhesPorId(Integer id) {
        TvMazeShowDto show = tvMazeClient.buscarSeriePorId(id);

        return new SerieDetalheResponse(
                show.id(),
                show.name(),
                extrairAno(show.premiered()),
                limparHtml(show.summary()),
                show.genres(),
                show.rating() != null ? show.rating().average() : null,
                show.runtime()
        );
    }

    private String extrairAno(String data) {
        if (data == null || data.length() < 4) {
            return "Não informado";
        }

        return data.substring(0, 4);
    }

    private String limparHtml(String texto) {
        if (texto == null) {
            return "Não informado";
        }

        return texto.replaceAll("<[^>]*>", "");
    }
}
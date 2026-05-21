package br.com.alane.tvmaze_mcp.dto.response;

import java.util.List;

public record SerieDetalheResponse(
        Integer id,
        String nome,
        String anoEstreia,
        String sinopse,
        List<String> generos,
        Double notaMedia,
        Integer duracaoMediaMinutos
) {
}
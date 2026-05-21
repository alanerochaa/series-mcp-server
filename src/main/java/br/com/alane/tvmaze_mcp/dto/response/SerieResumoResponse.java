package br.com.alane.tvmaze_mcp.dto.response;

public record SerieResumoResponse(
        Integer id,
        String nome,
        String anoEstreia,
        String sinopse
) {
}
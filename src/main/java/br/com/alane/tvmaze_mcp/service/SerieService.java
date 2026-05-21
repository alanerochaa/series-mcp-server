package br.com.alane.tvmaze_mcp.service;

import br.com.alane.tvmaze_mcp.dto.response.SerieDetalheResponse;
import br.com.alane.tvmaze_mcp.dto.response.SerieResumoResponse;

import java.util.List;

public interface SerieService {

    List<SerieResumoResponse> buscarPorTitulo(String titulo);

    SerieDetalheResponse buscarDetalhesPorId(Integer id);
}
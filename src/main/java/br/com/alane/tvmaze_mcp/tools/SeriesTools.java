package br.com.alane.tvmaze_mcp.tools;

import br.com.alane.tvmaze_mcp.dto.response.SerieDetalheResponse;
import br.com.alane.tvmaze_mcp.dto.response.SerieResumoResponse;
import br.com.alane.tvmaze_mcp.service.SerieService;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SeriesTools {

    private final SerieService serieService;

    public SeriesTools(SerieService serieService) {
        this.serieService = serieService;
    }

    @Tool(
            name = "buscar_series_por_titulo",
            description = "Busca séries de TV pelo título informado usando a API pública do TVMaze. Retorna id, nome, ano de estreia e sinopse."
    )
    public List<SerieResumoResponse> buscarSeriesPorTitulo(
            @ToolParam(description = "Título ou parte do título da série de TV") String titulo
    ) {
        return serieService.buscarPorTitulo(titulo);
    }

    @Tool(
            name = "buscar_detalhes_serie_por_id",
            description = "Busca os detalhes completos de uma série de TV pelo identificador numérico do TVMaze. Retorna nome, ano de estreia, sinopse, gêneros, nota média e duração média dos episódios."
    )
    public SerieDetalheResponse buscarDetalhesSeriePorId(
            @ToolParam(description = "Identificador numérico da série no TVMaze") Integer id
    ) {
        return serieService.buscarDetalhesPorId(id);
    }
}
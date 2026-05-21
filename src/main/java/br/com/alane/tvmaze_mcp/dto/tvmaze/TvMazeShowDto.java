package br.com.alane.tvmaze_mcp.dto.tvmaze;

import java.util.List;

public record TvMazeShowDto(
        Integer id,
        String name,
        String premiered,
        String summary,
        List<String> genres,
        TvMazeRatingDto rating,
        Integer runtime
) {
}
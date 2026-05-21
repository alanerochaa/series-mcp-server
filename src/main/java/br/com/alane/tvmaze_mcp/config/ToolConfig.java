package br.com.alane.tvmaze_mcp.config;

import br.com.alane.tvmaze_mcp.tools.SeriesTools;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ToolConfig {

    @Bean
    public MethodToolCallbackProvider seriesToolCallbackProvider(SeriesTools seriesTools) {
        return MethodToolCallbackProvider.builder()
                .toolObjects(seriesTools)
                .build();
    }
}
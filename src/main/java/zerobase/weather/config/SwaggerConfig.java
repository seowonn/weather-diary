package zerobase.weather.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Configuration;


@OpenAPIDefinition(
        info = @Info(title = "날씨 일기 프로젝트 :)",
                description = "날씨 일기를 CRUD 할 수 있는 백엔드 API 입니다.",
                version = "1.1"))
@Configuration
public class SwaggerConfig {

    private OpenAPI openAPI(){
        return new OpenAPI();
    }
}

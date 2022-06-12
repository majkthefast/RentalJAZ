package pl.pjatk.RentalService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;


@Configuration
@EnableSwagger2
public class DataConfiguration {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public Docket get(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/rent/**"))
                .build().apiInfo(createApiInfo());
    }
    private ApiInfo createApiInfo(){
        return new ApiInfo(
                "Rental API",
                "Movies DB,rental api",
                "1.00",
                "TOS",
                new Contact("Mikołaj","default url","s22982@pjwstk.edu.pl"),
                "my own licence",
                "default url",
                Collections.emptyList()
        );
    }
}

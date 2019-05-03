package zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import zuul.filters.pre.SimplePreFilter;


@EnableZuulProxy
@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class,args);

    }


    @Bean
    public SimplePreFilter simplePreFilter(){
        return new SimplePreFilter();
    }
}

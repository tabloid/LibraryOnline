package GVA.LibraryOnline;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@org.springframework.context.annotation.Configuration
@EnableAutoConfiguration
public class WebConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/weblib/**").addResourceLocations(
                "/WEB-INF/weblib/");
        registry.addResourceHandler("/api/**").addResourceLocations(
                "/${server.servlet-path}/api/**");
    }


}
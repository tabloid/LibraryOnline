package GVA.LibraryOnline;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@org.springframework.context.annotation.Configuration
@EnableAutoConfiguration
public class WebConfiguration extends WebMvcConfigurerAdapter {

    @Value("${server.servlet-path}")
    private String version;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(version + "web/weblib/**").addResourceLocations(
                "/WEB-INF/weblib/");
    }


}
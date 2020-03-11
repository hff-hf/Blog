package com.hff.myConfig;

import com.hff.component.MyHandlerItercept;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @auther hff
 * @time 2020/3/2 - 15:43
 **/
@Component
public class WebViewConfig {

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){

        WebMvcConfigurer webMvc = new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new MyHandlerItercept()).addPathPatterns("/**")
                        .excludePathPatterns("/allsource/**","/assets/**","/admin","/admin/login","/view");
            }

//            @Override
//            public void addViewControllers(ViewControllerRegistry registry) {
//                registry.addViewController("/").setViewName("views/index");
//                registry.addViewController("/index.html").setViewName("views/index");
//            }
        };

        return webMvc;
    }

}

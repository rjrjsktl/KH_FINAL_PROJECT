//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class WebMvcConfig implements WebMvcConfigurer {
//
//    private final CheckPwService checkPwService;
//    
//    public WebMvcConfig(CheckPwService checkPwService) {
//        this.checkPwService = checkPwService;
//    }
//    
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new MtmDetailInterceptor(checkPwService))
//                .addPathPatterns("/mtm_detail/**");
//    }
//}
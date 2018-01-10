package lab.phb.suratkeluar.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig
		extends WebMvcConfigurerAdapter{

			@Override
			public void addViewControllers(
				ViewControllerRegistry reg){
			reg.addViewController("/")
                                .setViewName("daftar-suratkeluar");
            reg.addViewController("/keluarin-donk")
                                .setViewName("coba");
            reg.addViewController("/list")
                                .setViewName("daftar-suratkeluar"); 
			reg.addViewController("/tambah")
                                .setViewName("form");   
            reg.addViewController("/form-edit")
                                .setViewName("edit");                    

		}

	}
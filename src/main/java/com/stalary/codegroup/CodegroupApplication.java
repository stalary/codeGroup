package com.stalary.codegroup;

import com.stalary.codegroup.controller.filter.ApiAuthenticatingFilter;
import com.stalary.codegroup.controller.filter.CrossOriginFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

import javax.servlet.Filter;

@SpringBootApplication
@EnableAutoConfiguration
@ServletComponentScan
public class CodegroupApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodegroupApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean crossOriginFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(crossOriginFilter());
		registration.addUrlPatterns("*");
		registration.setName("crossOriginFilter");
		registration.addInitParameter("allowOrigin", "*");
		registration.setOrder(1);
		return registration;
	}

	@Bean
	FilterRegistrationBean apiAuthenticatingFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(apiAuthenticatingFilter());
		registration.addUrlPatterns("*");
		registration.setName("apiAuthenticatingFilter");
		registration.setOrder(2);
		return registration;
	}

	@Bean(name = "crossOriginFilter")
	public Filter crossOriginFilter() {
		return new CrossOriginFilter();
	}

	@Bean(name = "apiAuthenticatingFilter")
	public Filter apiAuthenticatingFilter() {
		return new ApiAuthenticatingFilter();
	}
}

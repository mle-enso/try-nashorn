package com.chrgue.nashorn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.script.ScriptTemplateConfigurer;
import org.springframework.web.servlet.view.script.ScriptTemplateViewResolver;

@Configuration
public class TemplateEngineConfiguration {

	@Bean
	public ViewResolver reactViewResolver() {
		ScriptTemplateViewResolver viewResolver = new ScriptTemplateViewResolver();
		viewResolver.setPrefix("static/templates/");
		viewResolver.setSuffix(".ejs");
		return viewResolver;
	}

	@Bean
	public ScriptTemplateConfigurer reactConfigurer() {
		ScriptTemplateConfigurer configurer = new ScriptTemplateConfigurer();
		configurer.setEngineName("nashorn");

		configurer.setScripts("static/js/polyfill.js", "/META-INF/resources/webjars/ejs/2.5.2/ejs-v2.5.2/ejs.js",
				"static/js/server.app.js");

		configurer.setRenderFunction("renderServer");
		// why are we setting this to false?
		configurer.setSharedEngine(false);

		return configurer;
	}
}

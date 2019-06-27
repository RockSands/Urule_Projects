package com.urule.client.servlet;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.bstek.urule.KnowledgePackageReceiverServlet;

@Component
public class URuleServletRegistration {
	@Bean
	public ServletRegistrationBean registerURuleServlet() {
		return new ServletRegistrationBean(new KnowledgePackageReceiverServlet(), "/knowledgepackagereceiver");
	}
}

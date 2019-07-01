package com.urule.client;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.bstek.urule.runtime.KnowledgePackage;
import com.bstek.urule.runtime.KnowledgeSession;
import com.bstek.urule.runtime.KnowledgeSessionFactory;
import com.bstek.urule.runtime.response.RuleExecutionResponse;
import com.bstek.urule.runtime.service.KnowledgeService;
import com.urule.entity.Customer;

@SpringBootApplication
public class UruleClientApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(UruleClientApplication.class, args);
		KnowledgeService knowledgeService = (KnowledgeService) ctx.getBean(KnowledgeService.BEAN_ID);
		try {
			KnowledgePackage knowledgePackage = knowledgeService.getKnowledge("CCB/Test");
			System.out.println("==knowledgePackage==>" + knowledgePackage.getId());
			// 通过取到的KnowledgePackage对象创建KnowledgeSession对象
			KnowledgeSession session = KnowledgeSessionFactory.newKnowledgeSession(knowledgePackage);
			Customer customer = new Customer();
			customer.setAge(19);
			customer.setCar(true);
			customer.setGender(true);
			customer.setHouse(true);
			customer.setLevel(5);
			customer.setMarried(true);
			// 将业务数据对象Employee插入到KnowledgeSession中
			session.insert(customer);
			// 执行所有满足条件的规则
			RuleExecutionResponse response = session.fireRules();
			System.out.println("==response==>" + response);
			// 同步?
			System.out.println("==Result==>" + customer.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

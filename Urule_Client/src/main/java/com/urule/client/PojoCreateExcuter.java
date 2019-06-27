package com.urule.client;

import java.io.File;

import com.bstek.urule.ClassUtils;
import com.urule.entity.Customer;

/**
 * 将客户端的实体类生成XML，  该xml可以导入至urule的服务器上
 * 
 * @author Administrator
 *
 */
public class PojoCreateExcuter {

	public static void main(String[] args) {
		File file = new File("d:/customer.xml");
		ClassUtils.classToXml(Customer.class, file);
	}

}

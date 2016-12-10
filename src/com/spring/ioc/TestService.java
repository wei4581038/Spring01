package com.spring.ioc;

import java.util.HashMap;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestService {

	@Test
	public void testUserService(){
		
		IUserDaoBean bean = new UserDaoBeanImpl();
		//����service�����ʵ��
		
		//���Ʒ�תIOC:���ϵ�ԭ������Ŀ���Ȩ�����ⲿ������������ά���Ĺ���
		//����ע��:�ڶ��������ڼ��һ���������Ķ���ע�뵽�ö�����
		
		//ʹ��IOC(���Ʒ�ת)�������,[���캯��ע�뷽ʽ]
		UserServiceImpl userServiceImpl = new UserServiceImpl(bean);
		userServiceImpl.show();
		
		//Ҳ����ʹ��set�ķ�ʽ��������ע��
		userServiceImpl.setBean(bean);
		userServiceImpl.show();
		
		///
		//ͨ�����䴴��UserDaoBeanImpl����ʵ��
		try {
			IUserDaoBean userDao = (UserDaoBeanImpl) Class.forName("com.spring.ioc.UserDaoBeanImpl").newInstance();
			userDao.showUserInfo();
			Map<String,Object> objectBean = new HashMap<String,Object>();
			//��ID��Ϊkey,��classͨ���������ɵĶ�����Ϊvalue
			objectBean.put("userDao", userDao);
			userDao = (UserDaoBeanImpl)objectBean.get("userDao");
			userDao.showUserInfo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void initSpringContext(){
		//ʵ����Spring����  ע��:����org.springframework.context.ApplicationContext�µ�
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
		//����������ô֪�����bean.xml�Ķ����Ƿ��Ѿ�����������?������UserDaoBeanImplȥ����һ�����캯��,�������캯���Ƿ��Ѿ������þͿ�����!
		System.out.println("applicationContext:="+applicationContext);
		IUserDaoBean userDao = (UserDaoBeanImpl)applicationContext.getBean("userDao");
		userDao.showUserInfo();
		//�������ڿ��԰�bean.xml����ļ�����һ������,ֻҪ�����Ҫ��spring������Ķ���������bean.xml�ļ���,
		//�Ϳ���ͨ��applicationContext���õ�����Ҫ�ķ���,����Ҫ��ȥnew�ӿڵ�ʵ����
		UserServiceImpl userServiceImpl = (UserServiceImpl) applicationContext.getBean("UserService");
		//userServiceImpl.setBean(userDao);
		userServiceImpl.show();
		System.out.println("----------ͨ��setter��������ע��----------------");
		UserServiceImpl userServiceImpl1 = (UserServiceImpl)applicationContext.getBean("UserService1");
		userServiceImpl1.show();
	}
}

package com.tpg.app;

import com.tpg.mobile.bo.MobileBo;
import com.tpg.mobile.model.Phone;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by IntelliJ IDEA.
 * User: raul.lepsa
 * Date: 11/9/11
 * Time: 2:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class App {
    public static void main(String[] args) {
        // Get the application context
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config/BeanLocations.xml");

        // Get the mobile business object bean
        MobileBo mobileBo = (MobileBo)applicationContext.getBean("mobileBo");

        // Insert a new mobile phone into the DB
        Phone phone = new Phone();
        phone.setPhoneCode("SMSG_GX");
        phone.setPhoneName("Samsung Galaxy");
        mobileBo.save(phone);
    }
}

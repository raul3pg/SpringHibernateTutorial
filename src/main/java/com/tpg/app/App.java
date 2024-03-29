package com.tpg.app;

import com.tpg.mobile.bo.MobileBo;
import com.tpg.mobile.model.Phone;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: raul.lepsa
 * Date: 11/9/11
 * Time: 2:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class App {

    private static MobileBo mobileBo;

    public static void main(String[] args) {

        // Get the application context
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config/BeanLocations.xml");

        // Get the mobile business object bean
        mobileBo = (MobileBo)applicationContext.getBean("mobileBo");

        // List the existing phone(s)
        System.out.println(getAllMobilePhones().toString());
    }

    private static List<Phone> getAllMobilePhones(){
        return mobileBo.getAllPhones();
    }

    private static void insertPhone(String phoneName, String phoneCode){
        if (mobileBo.getByPhoneCode(phoneCode) != null){
            return;
        }
        Phone phone = new Phone(phoneName, phoneCode);
        phone.setPhoneCode(phoneCode);
        phone.setPhoneName(phoneName);
        mobileBo.save(phone);
    }

    private static void updatePhone(String phoneName, String phoneCode){
        Phone phone = mobileBo.getByPhoneCode(phoneCode);
        if (phone == null)
            return;
        phone.setPhoneName(phoneName);
        mobileBo.update(phone);
    }

    private static void deletePhoneByCode(String phoneCode){
        Phone phone = mobileBo.getByPhoneCode(phoneCode);
        if (phone == null)
            return;
        mobileBo.delete(phone);
    }

    private static void deletePhoneById(Long id){
        Phone phone = mobileBo.getById(id);
        if (phone == null)
            return;
        mobileBo.delete(phone);
    }
}

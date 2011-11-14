package com.tpg.mobile.bo.impl;

import com.tpg.mobile.bo.MobileBo;
import com.tpg.mobile.dao.MobileDao;
import com.tpg.mobile.model.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: raul.lepsa
 * Date: 11/9/11
 * Time: 3:34 PM
 * To change this template use File | Settings | File Templates.
 */

@Service("mobileBo")
public class MobileBoImpl implements MobileBo{

    @Autowired
    private MobileDao mobileDao;

    public void setMobileDao(MobileDao mobileDao) {
		this.mobileDao = mobileDao;
	}

    public void save(Phone phone) {
        mobileDao.save(phone);
    }

    public void delete(Phone phone) {
        mobileDao.delete(phone);
    }

    public void update(Phone phone) {
        mobileDao.update(phone);
    }

    public Phone getByPhoneCode(String phoneCode) {
        return mobileDao.getByPhoneCode(phoneCode);
    }

    public Phone getById(Long id){
        return mobileDao.getById(id);
    }

    public List getAllPhones(){
        return mobileDao.getAllPhones();
    }
}

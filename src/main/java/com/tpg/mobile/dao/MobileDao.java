package com.tpg.mobile.dao;

import com.tpg.mobile.model.Phone;

/**
 * Created by IntelliJ IDEA.
 * User: raul.lepsa
 * Date: 11/9/11
 * Time: 2:51 PM
 * To change this template use File | Settings | File Templates.
 */
public interface MobileDao {

    void save(Phone phone);
    void delete(Phone phone);
    void update(Phone phone);
    Phone findByMobilePhoneCode(String mobilePhoneCode);
}
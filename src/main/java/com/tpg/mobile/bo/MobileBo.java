package com.tpg.mobile.bo;

import com.tpg.mobile.model.Phone;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: raul.lepsa
 * Date: 11/9/11
 * Time: 3:33 PM
 * To change this template use File | Settings | File Templates.
 */
public interface MobileBo {

    void save(Phone phone);
    void delete(Phone phone);
    void update(Phone phone);
    Phone findByMobilePhoneCode(String mobilePhoneCode);
    List getAllMobilePhones();
}

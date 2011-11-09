package com.tpg.mobile.dao.impl;

import com.tpg.mobile.dao.MobileDao;
import com.tpg.mobile.model.Phone;
import com.tpg.util.CustomHibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: raul.lepsa
 * Date: 11/9/11
 * Time: 3:18 PM
 * To change this template use File | Settings | File Templates.
 */

@Repository("mobileDao")
public class MobileDaoImpl extends CustomHibernateDaoSupport implements MobileDao{

    public void save(Phone phone) {
        getHibernateTemplate().save(phone);
    }

    public void delete(Phone phone) {
        getHibernateTemplate().delete(phone);
    }

    public void update(Phone phone) {
        getHibernateTemplate().update(phone);
    }

    public Phone findByMobilePhoneCode(String mobilePhoneCode) {
        List list = getHibernateTemplate().find("From mobile_phone where mobilePhoneCode=?", mobilePhoneCode);
        return (Phone)list;
    }
}
package com.tpg.mobile.model;

import java.io.Serializable;
import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by IntelliJ IDEA.
 * User: raul.lepsa
 * Date: 11/9/11
 * Time: 2:49 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "phone", uniqueConstraints = {@UniqueConstraint(columnNames = "PHONE_CODE")})
public class Phone implements Serializable{

    private Long phoneId;
    private String phoneName;
    private String phoneCode;


    public Phone(){}

    public Phone(String phoneName, String phoneCode) {
        this.phoneName = phoneName;
        this.phoneCode = phoneCode;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "PHONE_ID", unique = true, nullable = false)
    public Long getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(Long phoneId) {
        this.phoneId = phoneId;
    }

    @Column(name = "PHONE_CODE", unique = true, nullable = false, length = 20)
    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    @Column(name = "PHONE_NAME", nullable = false, length = 40)
    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    @Override
    public String toString(){
        return "Mobile phone[id: " + getPhoneId() + ", code: " + getPhoneCode() + ", name: " + getPhoneName() + "].";
    }
}

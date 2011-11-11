package com.tpg.mobile.web;

/**
 * Created by IntelliJ IDEA.
 * User: raul.lepsa
 * Date: 11/11/11
 * Time: 9:28 AM
 * To change this template use File | Settings | File Templates.
 */
import com.tpg.mobile.model.Phone;

import java.util.ArrayList;
import java.util.Collection;

import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Class for mapping the UI model and the domain model of the Phone class.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
@XmlRootElement
public class BindablePhone {

	@XmlElement
	private Long id;

	@XmlElement
	@Pattern(regexp = "\\w+ \\w+")
	private String name;

	@XmlElement
	@Pattern(regexp = "\\w+( \\w+)?")
	private String code;

	public BindablePhone() {}

	public BindablePhone(Phone phone) {
		this.id = phone.getPhoneId();
		this.name = phone.getPhoneName();
		this.code = phone.getPhoneCode();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public static Collection<BindablePhone> bindablePhones(Collection<Phone> Phones) {
		Collection<BindablePhone> bindablePhones = new ArrayList<BindablePhone>();
		for (Phone phone : Phones) {
			bindablePhones.add(new BindablePhone(phone));
		}
		return bindablePhones;
	}

	public Phone asPhone() {
		return new Phone(name, code);
	}

}
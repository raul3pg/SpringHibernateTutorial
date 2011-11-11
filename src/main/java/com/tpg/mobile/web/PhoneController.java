package com.tpg.mobile.web;

/**
 * Created by IntelliJ IDEA.
 * User: raul.lepsa
 * Date: 11/11/11
 * Time: 9:32 AM
 * To change this template use File | Settings | File Templates.
 */
import java.util.Collection;

import javax.validation.Valid;

import com.tpg.mobile.bo.MobileBo;
import com.tpg.mobile.model.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/phones")
public class PhoneController {

	@Autowired
	private MobileBo mobileBo;

	@RequestMapping(method = RequestMethod.GET)
	public Collection<BindablePhone> getAllMobilePhones() {
		return BindablePhone.bindablePhones(mobileBo.getAllPhones());
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String get(Model model) {
		return get(null, model);
	}

	@RequestMapping(value = "/{phoneId}", method = RequestMethod.GET)
	public String get(@PathVariable Long employeeId, Model model) {
		Phone phone = mobileBo.getById(employeeId);
		if (phone != null) {
			model.addAttribute(new BindablePhone(phone));
		} else {
			model.addAttribute(new BindablePhone());
		}
		return "phone";
	}

	@RequestMapping(value = "/{phoneId}/delete", method = RequestMethod.GET)
	public String deleteViaGet(@PathVariable Long phoneId) {
		return delete(phoneId);
	}

	@RequestMapping(value = "/{phoneId}", method = RequestMethod.DELETE)
	public String delete(@PathVariable Long phoneId) {
		Phone phone = mobileBo.getById(phoneId);
        if (phone != null)
            mobileBo.delete(phone);
		return "redirect:../../phones";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String save(@Valid BindablePhone bindablePhone, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "phone";
		}

		mobileBo.save(bindablePhone.asPhone());
		return "redirect:phones";
	}
}
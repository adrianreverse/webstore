package com.common.ui;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author Adrian Dudziak
 *
 */
public abstract class AbstractSaveController<FORM> {

	private static final String EDIT = "edit";
	private static final String FORM = "form";
	
	@RequestMapping(value = "/" + EDIT, method = RequestMethod.GET)
	public ModelAndView getForm() {
		ModelAndView mav = new ModelAndView(EDIT);
		return prepareAttributes(mav);
	}
	
	@RequestMapping(value = "/" + EDIT, method = RequestMethod.POST)
	public ModelAndView postForm(@Valid @ModelAttribute(FORM) FORM form, BindingResult bindingResult) {
		
		ModelAndView mav = new ModelAndView(EDIT);
		
		if(bindingResult.hasErrors()) {
			return prepareAttributes(mav);
		}
		
		action(form);
		
		return new ModelAndView("view");
	}
	
	public abstract ModelAndView prepareAttributes(ModelAndView mav);

	public abstract void action(FORM form);
}

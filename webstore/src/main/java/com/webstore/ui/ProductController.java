package com.webstore.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.common.ui.AbstractSaveController;
import com.webstore.application.command.product.ProductApplicationService;

/**
 * 
 * @author Adrian Dudziak
 *
 */
@RequestMapping(value = ProductUrl.URL)
public class ProductController extends AbstractSaveController<ProductAttributesEditForm> {

	@Autowired
	private ProductApplicationService service;
	
	@Override
	public ModelAndView prepareAttributes(ModelAndView mav) {
		return mav.addObject("test", "to jest test");
	}

	@Override
	public void action(ProductAttributesEditForm form) {
		service.addProduct(form);
	}

}

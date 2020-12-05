package com.max.beanvalidation;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/customerInputSpForm")
    public String customerInputSpForm(Model customerModel) {
        customerModel.addAttribute("customer", new Customer());
        return "beanvalidationForms/customer-form";
    }

    @RequestMapping("/customerConfirmationSpForm")
    public String processCustomerForm(@Valid @ModelAttribute("customer") Customer customer,
                                      BindingResult bindingResult) {
        System.out.println(bindingResult);

        if(bindingResult.hasErrors()){
            return "beanvalidationForms/customer-form";
        }else {
            return "beanvalidationForms/customer-confirmation-form";
        }
    }
}

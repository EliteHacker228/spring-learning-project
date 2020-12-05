package com.max.student.name;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/studentName")
public class StudentNameController {

    @RequestMapping("/nameInputHtmlForm")
    public String showNameInputHtmlFormPage(){
        return "studentNameView/name-input-html-form";
    }

    @RequestMapping("/showNameFromParameters")
    public String showNameFromParameters(){
        return "studentNameView/show-name";
    }

    @RequestMapping("/showNameFromHttpServletRequestParameterAndModel")
    public String showNameFromHttpServletRequestParameterAndModel(HttpServletRequest request, Model model){
        var studentName = request.getParameter("studentName");
        var message = "Your name is " + studentName + "!";
        model.addAttribute("message", message);
        return "studentNameView/show-name";
    }

    @RequestMapping("/showNameFromRequestParamAndModel")
    public String showNameFromHttpServletRequestParameterAndModel(@RequestParam("studentName") String studentName, Model model){
        var annotatedMessage = "Your name is " + studentName + "!";
        model.addAttribute("annotatedMessage", annotatedMessage);
        return "studentNameView/show-name";
    }
}

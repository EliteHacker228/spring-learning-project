package com.max.student.springform.controller;

import com.max.student.springform.service.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/springForm")
public class StudentFormController {

    @RequestMapping("/studentInputSpringForm")
    public String getStudentSpringInputForm(Model studentModel){
        var student = new Student();
        student.setFirstName("Thomas");
        student.setLastName("Angelo");
        studentModel.addAttribute("student", student);

        return "studentSpringFormsView/student-input-spring-form";
    }

    @RequestMapping("/studentOutputSpringForm")
    public String getStudentSpringOutputForm(@ModelAttribute("student") Student student){

        //System.out.println("До атрибута " + student.getFirstName() + " " + student.getLastName());
        //student = (Student)model.getAttribute("student");
        System.out.println("После атрибута " + student.getFirstName() + " " + student.getLastName());


        return "studentSpringFormsView/student-output-spring-form";
    }
}

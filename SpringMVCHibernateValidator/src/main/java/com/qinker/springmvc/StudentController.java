package com.qinker.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @ClassName:  StudentController   
 * @Description:Spring MVC Hibernate验证器
 * @author: Lory
 * @date:   2018年3月5日 下午4:42:06   
 *     
 * @Copyright: 2018 www.qinker.com Inc. All rights reserved. 
 * 注意：本内容仅限于坤刻网络科技技术股份有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Controller
public class StudentController {

	@RequestMapping(value = "/addStudent", method = RequestMethod.GET)
	public ModelAndView student() {
		return new ModelAndView("addStudent", "command", new Student());
	}

	//该注解会在requesMapping映射之前创建key为"student"的对象到model当中
	@ModelAttribute(value = "student")
	public Student createStudentModel() {
		return new Student();
	}

	@RequestMapping(value="/addStudent",method=RequestMethod.POST)
	public String addStudent(@ModelAttribute("student") @Validated Student student, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			return "addStudent";
		}
		model.addAttribute("name", student.getName());
		model.addAttribute("age", student.getAge());
		model.addAttribute("id", student.getId());

		return "result";
	}
}

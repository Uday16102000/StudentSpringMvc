package studentManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import studentManagement.dao.StudentDao;
import studentManagement.dto.Student;

@Controller
public class StudentController {

	@Autowired
	private StudentDao dao;
	
	@RequestMapping("/register")
	public ModelAndView registerStudent() {
		
		ModelAndView modelAndView= new ModelAndView();
		modelAndView.addObject("student",new Student());
		modelAndView.setViewName("register.jsp");
		return modelAndView;
		
	}
	@RequestMapping("/save")
	public ModelAndView saveStudent(@ModelAttribute Student student)
	{
		
		ModelAndView modelAndView= new ModelAndView();
		dao.saveStudent(student);
		List<Student> list=dao.getAllStudent();
		modelAndView.addObject("list",list);
		modelAndView.setViewName("display.jsp");
		modelAndView.setViewName("display.jsp");
		
		return modelAndView;
		
	}
	
	@RequestMapping("/delete")
	public ModelAndView deleteStudent(@RequestParam int id) {
		ModelAndView modelAndView= new ModelAndView();
		dao.deleteById(id);
		List<Student> list=dao.getAllStudent();
		modelAndView.addObject("list",list);
		modelAndView.setViewName("display.jsp");
		return modelAndView;
	}
	
	@RequestMapping("/edit")
	public ModelAndView editStudent(@RequestParam int id) {
		ModelAndView modelAndView= new ModelAndView();
		Student student=dao.findStudentById(id);
		modelAndView.addObject("student",student);
		modelAndView.setViewName("edit.jsp");
		
		return modelAndView;
		
	}
	
	@RequestMapping("/update")
	public ModelAndView updateStudent(@ModelAttribute Student student)
{    		ModelAndView modelAndView= new ModelAndView();
		dao.updateStudent(student);
//		modelAndView.addObject("student1",student1);
		List<Student> list=dao.getAllStudent();
		modelAndView.addObject("list",list);
		modelAndView.setViewName("display.jsp");
		
		
     
	return modelAndView;
		}
}


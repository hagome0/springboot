package kr.ac.springboot.term.resume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResumeController {

    // '/' ==> list
    // '/register' ==> create
    // '/{rno} ==> view
    // '/{rno}/update ==> update'
    // '/{rno}/delete ==> delete'

	@Autowired
	ResumeRepository repo;
	
    @GetMapping("/")
    public String resumeIndex(Model model) {
    	model.addAttribute("resume", repo.findByName("하상엽"));
        return "resume";
    }

    @GetMapping("/resume")
    public void list(Model model) {
        model.addAttribute("resume", repo.findByName("하상엽"));
    }
    

}

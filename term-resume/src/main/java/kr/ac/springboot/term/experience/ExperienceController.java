package kr.ac.springboot.term.experience;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import kr.ac.springboot.term.resume.ResumeRepository;

@Controller
public class ExperienceController {

	@Autowired
	private ExperienceRepository exrepo;

	@Autowired
	private ResumeRepository rerepo;

	@GetMapping("/{eno}")
	public String view(@PathVariable("eno") long eno, Model model) {
		if (exrepo.findById(eno).isPresent()) {
			model.addAttribute("result", exrepo.findById(eno).get());
		} else {
			return "errors/404";
		}
		return "/view";
	}

	@GetMapping("/experience")
	public String experienceIn(Model model) {
		model.addAttribute("experience", exrepo.findAll());
		return "experience";
	}

	@GetMapping("/register")
	public void registerGET(@ModelAttribute("vo") Experience vo) {
	}

	@PostMapping("/register")
	public String registerPOST(@ModelAttribute("vo") Experience vo) {
		rerepo.findById((long) 1);
		vo.setResume(rerepo.findById((long) 1).get());
		exrepo.save(vo);
		return "redirect:/experience";
	}

	@GetMapping("{eno}/delete")
	public String delete(@PathVariable("eno") long eno) {
		if (exrepo.findById(eno).isPresent()) {
			exrepo.deleteById(eno);
		} else {
			return "errors/404";
		}
		return "redirect:/experience";
	}

	@GetMapping("{eno}/update")
	public String updateGet(@PathVariable("eno") long eno, @ModelAttribute("vo") Experience vo, Model model) {
		if (exrepo.findById(eno).isPresent()) {
			model.addAttribute("vo", exrepo.findById(eno).get());
		} else {
			return "errors/404";
		}
		return "/update";
	}

	@PostMapping("/update")
	public String updatePost(@ModelAttribute("vo") Experience vo) {
		Optional<Experience> experience = exrepo.findById(vo.getEno());
		if (experience.isPresent()) {
			experience.get().setProject(vo.getProject());
			experience.get().setContent(vo.getContent());
			experience.get().setRole(vo.getRole());
			exrepo.save(experience.get());
		} else {
			exrepo.save(vo);
		}
		return "redirect:/experience";
	}

}

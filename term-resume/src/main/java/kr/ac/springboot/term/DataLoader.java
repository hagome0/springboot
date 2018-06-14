package kr.ac.springboot.term;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import kr.ac.springboot.term.experience.Experience;
import kr.ac.springboot.term.experience.ExperienceRepository;
import kr.ac.springboot.term.reply.Reply;
import kr.ac.springboot.term.reply.ReplyRepository;
import kr.ac.springboot.term.resume.Resume;
import kr.ac.springboot.term.resume.ResumeRepository;

@Component
public class DataLoader implements ApplicationRunner {
	@Autowired
	ResumeRepository rerepo;
	
	@Autowired
	ExperienceRepository exrepo;
	
	@Autowired
	ReplyRepository rprepo;
	
	
    @Override
    public void run(ApplicationArguments args) {
        rerepo.save(new Resume("하상엽" , "2014958128", "경성대학교 소프트웨어학과", "wnem123@gmail.com", "초보개발자"));
        exrepo.save(new Experience("학력", "고등학교", "부산해동고등학교 졸업", "2014-02-03", rerepo.findById((long)1).orElse(null)));
        exrepo.save(new Experience("학력", "대학교", "경성대학교 소프트웨어학과 재학", "2018-06-20", rerepo.findById((long)1).orElse(null)));
        exrepo.save(new Experience("프로젝트", "한이음", "스마트 화분", "2018-05-25", rerepo.findById((long)1).orElse(null)));
        rprepo.save(new Reply("고우십니다", "남천동멋쟁이", rerepo.findById((long)1).orElse(null)));
         
    }

}
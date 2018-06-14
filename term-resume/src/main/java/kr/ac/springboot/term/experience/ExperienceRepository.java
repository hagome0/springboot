package kr.ac.springboot.term.experience;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kr.ac.springboot.term.experience.Experience;
import kr.ac.springboot.term.resume.Resume;

@Repository
public interface ExperienceRepository extends CrudRepository<Experience, Long>{
	List<Experience> findByResume(Resume resume);
	List<Experience> findAll();
}

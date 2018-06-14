package kr.ac.springboot.term.resume;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeRepository extends CrudRepository<Resume, Long> {
	List<Resume> findByName(String name);
}

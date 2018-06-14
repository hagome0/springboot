package kr.ac.springboot.term.reply;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kr.ac.springboot.term.resume.Resume;

@Repository
public interface ReplyRepository extends CrudRepository<Reply, Long>{
	List<Reply> findAllByResumeOrderByUpdatedateDesc(Resume resume);}

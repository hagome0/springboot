package kr.ac.springboot.term.reply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import kr.ac.springboot.term.resume.Resume;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/replies/*")
public class ReplyController {

	@Autowired
	private ReplyRepository replyRepo;

	@GetMapping("/{rno}")
	public ResponseEntity<List<Reply>> getReplies(@PathVariable("rno") Long rno) {

		Resume resume = new Resume();
		resume.setRno(rno);
		return new ResponseEntity<>(getListByresume(resume), HttpStatus.OK);
	}

	@Transactional
	@PostMapping("/{rno}")
	public ResponseEntity<List<Reply>> addReply(@PathVariable("rno") Long rno, @RequestBody Reply reply) {

		Resume resume = new Resume();
		resume.setRno(rno);

		reply.setResume(resume);

		replyRepo.save(reply);

		return new ResponseEntity<>(getListByresume(resume), HttpStatus.CREATED);
	}

	@Transactional
	@DeleteMapping("/{rno}/{rpno}")
	public ResponseEntity<List<Reply>> remove(@PathVariable("rno") Long rno, @PathVariable("rpno") Long rpno) {

		replyRepo.deleteById(rpno);

		Resume resume = new Resume();
		resume.setRno(rno);

		return new ResponseEntity<>(getListByresume(resume), HttpStatus.OK);

	}

	@Transactional
	@PutMapping("/{rno}")
	public ResponseEntity<List<Reply>> modify(@PathVariable("rno") Long rno, @RequestBody Reply reply) {

		replyRepo.findById(reply.getrpno()).ifPresent(origin -> {
			origin.setReplyText(reply.getReplyText());
			origin.setReplyer(reply.getReplyer());
			replyRepo.save(origin);
		});

		Resume resume = new Resume();
		resume.setRno(rno);

		return new ResponseEntity<>(getListByresume(resume), HttpStatus.OK);
	}

	private List<Reply> getListByresume(Resume resume) throws RuntimeException {
		return replyRepo.findAllByResumeOrderByUpdatedateDesc(resume);
	}
}

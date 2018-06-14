package kr.ac.springboot.term.experience;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kr.ac.springboot.term.resume.Resume;

@Entity
public class Experience {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long eno;
	private String role;
	private String project;
	private String content;
	private String date;

	@JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY)
     private Resume resume;//댓글을 달기 위해 프라이머리키를 걸었다.

	
	public Experience() {
		
	}
	
	
	public Experience(String role, String project, String content, String date, Resume resume) {
		this.role = role;
		this.project = project;
		this.content = content;
		this.date = date;
		this.resume = resume;
	}

	public Long getEno() {
		return eno;
	}

	public void setEno(Long eno) {
		this.eno = eno;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	
}

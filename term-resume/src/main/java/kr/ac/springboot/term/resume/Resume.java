package kr.ac.springboot.term.resume;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kr.ac.springboot.term.experience.Experience;
import kr.ac.springboot.term.reply.Reply;

@Entity
public class Resume {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long rno;
	private String name;
	private String sn;
	private String uni_major;
	private String email;
	private String short_pro;

	@JsonIgnore
	@OneToMany(mappedBy = "resume", fetch = FetchType.LAZY)
	private List<Experience> exkey;
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume", fetch = FetchType.LAZY)
	private List<Reply> rekey;

	public Resume() {

	}

	public Resume(String name, String sn, String uni_major, String email, String short_pro) {
		this.name = name;
		this.sn = sn;
		this.uni_major = uni_major;
		this.email = email;
		this.short_pro = short_pro;
	}

	public Long getRno() {
		return rno;
	}

	public void setRno(Long rno) {
		this.rno = rno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getUni_major() {
		return uni_major;
	}

	public void setUni_major(String uni_major) {
		this.uni_major = uni_major;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getShort_pro() {
		return short_pro;
	}

	public void setShort_pro(String short_pro) {
		this.short_pro = short_pro;
	}

	
	
	// @JsonIgnore
	// @OneToMany(mappedBy="board",fetch=FetchType.LAZY)//Lazy로딩이라고 한다. 지연연산을
	// 하기위한것이다.
	// private List<> replie; //댓글 다는 기능 의 프라이머리키를 만들기위해쓰는 코드

}

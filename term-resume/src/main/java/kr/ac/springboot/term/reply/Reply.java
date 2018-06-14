package kr.ac.springboot.term.reply;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kr.ac.springboot.term.resume.Resume;

@Entity
@Table(name = "tbl_Resumereplies")
public class Reply {

    public Reply() {
    }

    public Reply(String replyText, String replyer, Resume resume) {
        this.replyText = replyText;
        this.replyer = replyer;
        this.resume = resume;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long rpno;

    private String replyText;

    private String replyer;

    @CreationTimestamp
    private Timestamp regdate;

    @UpdateTimestamp
    private Timestamp updatedate;

    @JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY)
    private Resume resume;

    public Long getrpno() {
        return rpno;
    }

    public void setrpno(Long rpno) {
        this.rpno = rpno;
    }

    public String getReplyText() {
        return replyText;
    }

    public void setReplyText(String replyText) {
        this.replyText = replyText;
    }

    public String getReplyer() {
        return replyer;
    }

    public void setReplyer(String replyer) {
        this.replyer = replyer;
    }

    public Timestamp getRegdate() {
        return regdate;
    }

    public void setRegdate(Timestamp regdate) {
        this.regdate = regdate;
    }

    public Timestamp getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Timestamp updatedate) {
        this.updatedate = updatedate;
    }

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "rpno=" + rpno +
                ", replyText='" + replyText + '\'' +
                ", replyer='" + replyer + '\'' +
                ", regdate=" + regdate +
                ", updatedate=" + updatedate +
                ", resume=" + resume +
                '}';
    }
}

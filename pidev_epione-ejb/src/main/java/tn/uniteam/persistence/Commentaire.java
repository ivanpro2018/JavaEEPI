package tn.uniteam.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Commentaire
 *
 */
@Entity
@Table(name="Commentaires")

public class Commentaire implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdCommentaire")
	private int IdCommentaire;
	@Column(name="LaCommentaire")
	private String LaCommentaire;	
	@Column(name="DateCommentaire")
	private Date dateCommentaire;
	@ManyToOne
	@JoinColumn(name="Question_IdQuestion")
	private Question Question;
	@OneToOne
	@JoinColumn(name="user_Id")
	private AspNetUser user;
	private static final long serialVersionUID = 1L;

	public Commentaire() {
		super();
	}   
	public int getIdCommentaire() {
		return this.IdCommentaire;
	}

	public void setIdCommentaire(int IdCommentaire) {
		this.IdCommentaire = IdCommentaire;
	}   
	public String getLaCommentaire() {
		return this.LaCommentaire;
	}

	public void setLaCommentaire(String LaCommentaire) {
		this.LaCommentaire = LaCommentaire;
	}   
	public Date getDateCommentaire() {
		return dateCommentaire;
	}
	public void setDateCommentaire(Date dateCommentaire) {
		this.dateCommentaire = dateCommentaire;
	}
	public Question getQuestion_IdQuestion() {
		return this.Question;
	}

	public void setQuestion_IdQuestion(Question Question_IdQuestion) {
		this.Question = Question_IdQuestion;
	}   
	public AspNetUser getUser_Id() {
		return this.user;
	}

	public void setUser_Id(AspNetUser user_Id) {
		this.user = user_Id;
	}
   
}

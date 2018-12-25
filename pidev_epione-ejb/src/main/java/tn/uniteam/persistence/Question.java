package tn.uniteam.persistence;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Questions database table.
 * 
 */
@Entity
@Table(name="Questions")
@NamedQuery(name="Question.findAll", query="SELECT q FROM Question q")
public class Question implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdQuestion")
	private int idQuestion;

	@Column(name="LaQuestion")
	private String laQuestion;

	@Column(name="DateQuestion")
	private Date dateQuestion;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="Patient_Id")
	private AspNetUser aspNetUser;

	//bi-directional many-to-one association to Commentaire
	@OneToMany(mappedBy="Question")
	private List<Commentaire> commentaires;

	public Question() {
	}

	public int getIdQuestion() {
		return this.idQuestion;
	}

	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}

	public String getLaQuestion() {
		return this.laQuestion;
	}

	public void setLaQuestion(String laQuestion) {
		this.laQuestion = laQuestion;
	}

	public Date getDateQuestion() {
		return dateQuestion;
	}

	public void setDateQuestion(Date dateQuestion) {
		this.dateQuestion = dateQuestion;
	}

	public AspNetUser getAspNetUser() {
		return this.aspNetUser;
	}

	public void setAspNetUser(AspNetUser aspNetUser) {
		this.aspNetUser = aspNetUser;
	}

	public List<Commentaire> getCommentaires() {
		return this.commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public Commentaire addCommentaire(Commentaire commentaire) {
		getCommentaires().add(commentaire);
		commentaire.setQuestion_IdQuestion(this);

		return commentaire;
	}

	public Commentaire removeCommentaire(Commentaire commentaire) {
		getCommentaires().remove(commentaire);
		commentaire.setQuestion_IdQuestion(null);

		return commentaire;
	}

}
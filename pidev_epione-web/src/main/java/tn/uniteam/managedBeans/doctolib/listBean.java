package tn.uniteam.managedBeans.doctolib;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.uniteam.persistence.AspNetUser;
import tn.uniteam.services.doctolib.MedecinServicesLocal;

@ManagedBean
@SessionScoped
public class listBean implements Serializable{
	private List<AspNetUser> Listemed;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public listBean() {
		// TODO Auto-generated constructor stub
	}

	@EJB
	private MedecinServicesLocal medecinServiceLocal;
	
	public List<AspNetUser> getListemed() {
		Listemed=medecinServiceLocal.getAllUsers();
	
	return Listemed;
}

public void setListemed(List<AspNetUser> listemed) {
	this.Listemed = listemed;
}
	
	public  void ListMedecin()
	{
		medecinServiceLocal.getAllUsers();
	}
	 
}

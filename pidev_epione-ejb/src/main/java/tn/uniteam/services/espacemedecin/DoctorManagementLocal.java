package tn.uniteam.services.espacemedecin;

import java.util.List;

import javax.ejb.Local;

import tn.uniteam.persistence.AspNetUser;

@Local
public interface DoctorManagementLocal {
	List<AspNetUser> ConsommationGetAllDoc();
}

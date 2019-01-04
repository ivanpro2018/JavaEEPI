package tn.uniteam.services.analytics;

import java.util.List;

import javax.ejb.Local;

import tn.uniteam.persistence.Appointment;
import tn.uniteam.persistence.AspNetUser;

@Local
public interface ConsommationStatistiquesManagementLocal {
	public List<AspNetUser> ConsommationGetTreatedPatientsOfDoctor(String id);
	public List<AspNetUser> ConsommationGetNotTreatedPatientsOfDoctor(String id);
	public List<Appointment> ConsommationGetAppointmentsOfDoctor(String id);
}

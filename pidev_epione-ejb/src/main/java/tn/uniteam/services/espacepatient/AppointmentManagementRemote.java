package tn.uniteam.services.espacepatient;



import java.util.List;

import javax.ejb.Remote;

import tn.uniteam.persistence.Appointment;

@Remote
public interface AppointmentManagementRemote {
	List<Appointment> ConsommationAppointmentsList();
}

package tn.uniteam.services.espacepatient;


import java.util.List;

import javax.ejb.Local;

import tn.uniteam.persistence.Appointment;
import tn.uniteam.persistence.AspNetUser;

@Local
public interface AppointmentManagementLocal {
	List<Appointment> ConsommationAppointmentsList();
}

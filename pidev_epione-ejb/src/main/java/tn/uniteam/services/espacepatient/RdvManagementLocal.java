package tn.uniteam.services.espacepatient;



import java.util.List;

import javax.ejb.Local;

import tn.uniteam.persistence.Appointment;




@Local
public interface RdvManagementLocal {
	public List<Appointment> getAllRDV();
	public Appointment getRDV(int id);
}

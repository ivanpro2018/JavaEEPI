package tn.uniteam.services.espacemedecin;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import tn.uniteam.persistence.Appointment;
import tn.uniteam.persistence.AspNetUser;
import tn.uniteam.persistence.Disponibility;
import tn.uniteam.persistence.Reason;

@Remote
public interface DoctorManagementRemote {
	List<AspNetUser> ConsommationGetAllDoc();
	void addReason(Reason r);
	void updateReason(Reason r);
    void deleteReason(Reason r);
    List<Reason> getAllReasons();
    List<Reason> getReasonsByDoctor(String idDoc);
    AspNetUser getDoctorById(String id);
    Reason getReasonById(int id);
    void addAppointment(Appointment a);
    List<Appointment> getAllApp(String id);
    List<Date> getNbAppByWeek(String id);
    List<Date> getNbDispoByWeek(String id);
}

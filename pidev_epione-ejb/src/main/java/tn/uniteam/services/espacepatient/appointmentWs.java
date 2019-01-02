package tn.uniteam.services.espacepatient;




import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



import tn.uniteam.persistence.Appointment;

public class appointmentWs {

	public static void main(String[] args) throws IOException, JSONException {
		// TODO Auto-generated method stub
            clientPost c = new clientPost();
try {
            JSONArray json = c.readJsonFromUrl("http://localhost:54774/API/AppointmentsList");
            ArrayList<Appointment> ListAppointment = new  ArrayList<>();
            for (int i = 0, count = json.length(); i < count; i++) {
            	Appointment appointment = new  Appointment();           
            JSONObject obj = (JSONObject)json.get(i);
            appointment.setAppointmentState(obj.getInt("AppointmentState"));
            appointment.setDate((Date) obj.get("Date"));
            appointment.setAppointmentId(obj.getInt("AppointmentId"));
            appointment.setLocation(obj.get("Location").toString());
            appointment.setSpecialities(obj.getInt("Specialities"));
            ListAppointment.add(appointment);
         }          

            System.out.println(ListAppointment);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
	}

}

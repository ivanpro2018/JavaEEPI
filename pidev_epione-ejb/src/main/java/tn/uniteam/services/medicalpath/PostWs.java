package tn.uniteam.services.medicalpath;


import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import tn.uniteam.persistence.MedicalPath;




public class PostWs {

	public static void main(String[] args) throws IOException, JSONException {
		// TODO Auto-generated method stub
            clientPost c = new clientPost();
try {
            JSONArray json = c.readJsonFromUrl("http://localhost:54774/Ws/GetMedicalPath/?format=json");
            ArrayList<MedicalPath> List = new  ArrayList<>();
            for (int i = 0, count = json.length(); i < count; i++) {
            	MedicalPath post = new  MedicalPath();
            
//winek lenna ? eyy             
            	
            JSONObject obj = (JSONObject)json.get(i);
            post.setPathId(obj.get("PathId").toString());
            post.setDescription(obj.get("Description").toString());
            post.setJustification(obj.get("Justification").toString());
           post.setRecommendedSpeciality(obj.get("RecommendedSpeciality").toString());
             post.setValidatedSteps((boolean) obj.get("ValidatedSteps"));
           
            List.add(post);
         }        //    

            System.out.println(List);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
	}

}

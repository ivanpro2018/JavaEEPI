package tn.uniteam.managedBeans.analytics;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;

@ManagedBean
@SessionScoped
public class UploadController {
	
	private Part picDisease;

	public void doUpload() {
//		InputStream in = null;
		try {
			InputStream in = picDisease.getInputStream();
			String pathname = "C:\\Users\\ivano\\Desktop\\upload\\";
			File pic = new File(pathname + picDisease.getSubmittedFileName());
			System.out.println(picDisease.getSubmittedFileName());
			pic.createNewFile();
			FileOutputStream picOut = new FileOutputStream(pic);
			byte[] buffer = new byte[1024]; //1073741824 - 3145728
			int length;
			while ((length=in.read(buffer))>0) {
				picOut.write(buffer, 0, length);				
			}
//			report.setImageDisease(picDisease.getSubmittedFileName());
			picOut.close();
			in.close();
			picDisease.write(pathname+picDisease.getSubmittedFileName());
			System.out.println("Okay");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Erreur image : " );
			e.printStackTrace(System.out);
		}
	}

	public Part getPicDisease() {
		return picDisease;
	}

	public void setPicDisease(Part picDisease) {
		this.picDisease = picDisease;
	}

}

package hopital.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import hopital.dao.PatientDao;
import hopital.model.Patient;

public class TestPatient {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		PatientDao patientDao = context.getBean(PatientDao.class);
		
		Patient danh = new Patient("CAO", "Danh", 52000);
		
		patientDao.create(danh);
		
		context.close();
	}

}

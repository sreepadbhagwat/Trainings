package jaxon;
import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

public class JacksonTesterOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JacksonTesterOne tester = new JacksonTesterOne();
		
		try {
			
			Student student = new Student();
			student.setAge(12);
			student.setName("Jason");			
			tester.writeJSON(student);
			
			System.out.println(student);
			
			Student student1 = tester.readJSON();
			
			System.out.println(student1);
			
		 }catch (JsonParseException e){e.printStackTrace();}
	       catch (JsonMappingException e){e.printStackTrace();}
	       catch (IOException e){e.printStackTrace();}

	}
	
	private void writeJSON(Student student) throws JsonGenerationException, JsonMappingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File("Student.json"),student);
		
	}

	private Student readJSON() throws JsonGenerationException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		Student student = mapper.readValue(new File("Student.json"),Student.class);
		return student;
	}
}

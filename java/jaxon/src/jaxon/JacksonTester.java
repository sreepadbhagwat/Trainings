package jaxon;

import java.io.IOException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

public class JacksonTester {

	public static void main(String args[]){
  	  // Create ObjectMapper Object

		ObjectMapper mapper = new ObjectMapper();
	      String jsonString = "{\"name\":\"Mahesh\", \"age\":21}";

	      try {
	    	  //Deserialize JSON object
	    	  Student student = mapper.readValue(jsonString, Student.class);
	    	  System.out.println(student);
	    	  
	    	  // Serialize object to JSON
	    	  mapper.enable(SerializationConfig.Feature.INDENT_OUTPUT);
	          jsonString = mapper.writeValueAsString(student);
	          
	          System.out.println(jsonString);
	    	  
	      }catch (JsonParseException e){e.printStackTrace();}
	       catch (JsonMappingException e){e.printStackTrace();}
	       catch (IOException e){e.printStackTrace();}
		
	}
	
	
}

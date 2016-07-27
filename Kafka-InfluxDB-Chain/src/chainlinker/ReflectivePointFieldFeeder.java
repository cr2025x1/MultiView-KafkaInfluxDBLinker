package chainlinker;
/*
 * This class is for the method to handle org.influxdb.dto.Point.Builder's addField method as
 * the method does not provide reflection.
 * 
 * This class separates non-reflective codes from the main code block.
 */

// TODO: Move this into SnapPluginParser.

public class ReflectivePointFieldFeeder {
	// NOTE:
	// I'm still getting familiar with Java, but if there're anyone knows it better than me,
	// please fix this. I think this part can be better than this.	
		
	// Dummy value objects for class type info 
	private static Long lValue = 0L;
	private static Double lfValue = 0.0;
	private static String sValue = "";
	private static Boolean bValue = false;	
	
	public static void addField(org.influxdb.dto.Point.Builder pointBuilder, @SuppressWarnings("rawtypes") Class dataTypeClass, Object data) throws ClassNotFoundException {
		if (dataTypeClass.equals(lValue.getClass())) {
			pointBuilder.addField("value", (long)data);
		} else if (dataTypeClass.equals(lfValue.getClass())) {
			// For double-precision values, additional touch is required as sometimes integer value may be passed.
			if (lValue.getClass() == data.getClass()) {
				// The reason for this double typecasting:
				// http://stackoverflow.com/questions/32757565/java-lang-long-cannot-be-cast-to-java-lang-double
				// https://docs.oracle.com/javase/specs/jls/se7/html/jls-5.html#jls-5.1.3
				pointBuilder.addField("value", (double)((long)data));
			} else {
				pointBuilder.addField("value", (double)data);
			}
		} else if (dataTypeClass.equals(sValue.getClass())) {
			pointBuilder.addField("value", (String)data);			
		} else if (dataTypeClass.equals(bValue.getClass())) {
			pointBuilder.addField("value", (boolean)data);			
		} else {
			throw new ClassNotFoundException("Unidentifiable value is detected. Is the JSON data value is correct?");
		}
	}
}

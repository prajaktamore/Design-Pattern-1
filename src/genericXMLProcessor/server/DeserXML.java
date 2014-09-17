package genericXMLProcessor.server;

import genericXMLProcessor.util.SerializableObject;
/**
 * @author Prajakta More and Kapil Bijamwar
 * Interface to XML redformat of the object passed as the argument
 */
public interface DeserXML extends SerDeserXML{
	/**
	 * @param fileName
	 * @return SerializableObject
	 */
	public SerializableObject readXML(String fileName);
}

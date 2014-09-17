package genericXMLProcessor.server;

import genericXMLProcessor.util.SerializableObject;

/**
 * @author Prajakta More and Kapil Bijamwar
 * Interface to XML wireformat of the object passed as the argument
 */
public interface SerXML extends SerDeserXML {
	/**
	 * @param myF
	 * @param fileName
	 */
	public void writeXML(SerializableObject myF, String fileName);
}

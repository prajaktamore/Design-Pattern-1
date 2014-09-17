package genericXMLProcessor.xmlSerDeser;

import genericXMLProcessor.server.SerXML;
import genericXMLProcessor.util.MyAllTypesFirst;
import genericXMLProcessor.util.MyAllTypesSecond;
import genericXMLProcessor.util.SerializableObject;
import genericXMLProcessor.utilclasses.CompareTwoClasses;
import genericXMLProcessor.utilclasses.Debug;
import genericXMLProcessor.utilclasses.FileReaderClass;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Prajakta More and Kapil Bijamwar 
 * Serialize class that Serialize data and generate
 *         MyAllTypesCopy.txt
 */
public class Serialize implements SerXML {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Serialize COnstructor
	 */
	public Serialize() {
		if (Debug.getDEBUG_VALUE() == 3) {
			CompareTwoClasses.strbuild.append("\n Constructor is called :: "
					+ this.getClass().getName());
		}
	}

	
	/* (non-Javadoc)
	 * @see genericXMLProcessor.server.SerXML#writeXML(genericXMLProcessor.util.SerializableObject, java.lang.String)
	 */
	public void writeXML(SerializableObject myType, String fileName) {
		try {
			FileWriter file = new FileWriter(fileName);
			PrintWriter pw = new PrintWriter(file);
			try {
				FileReaderClass.setFileReader(new FileReader("MyAllTypes.txt"));
			} catch (FileNotFoundException e) {
				System.err.println("Exception Occured :: " + e.getMessage());
				System.exit(0);
			}
			FileReaderClass.setBr(new BufferedReader(FileReaderClass
					.getFileReader()));
			String fileData = null;
			while ((fileData = FileReaderClass.getBr().readLine()) != null) {
						if (fileData.contains("<DPSerialization>")) {
							pw.println(fileData);
						}
						if (myType instanceof MyAllTypesSecond) {
							MyAllTypesSecond second = (MyAllTypesSecond) myType;
							if (null != second) {
								if (fileData.contains("<complexType xsi:type=\"")) {
									pw.println(fileData.replaceAll("\".*?\"", "\""
											+ second.getClass().getCanonicalName()
											+ "\""));
								}
								if (fileData.contains("<myStringS xsi:type=\"xsd:string\">")) {
									pw.println(fileData.replaceAll(">.*?<", ">"
											+ second.getMyStringS() + "<"));
								} else if (fileData.contains("<myIntS xsi:type=\"xsd:int\">")) {
									pw.println(fileData.replaceAll(">.*?<", ">"
											+ String.valueOf(second.getMyIntS())
											+ "<"));
								} else if (fileData.contains("<myFloatS xsi:type=\"xsd:float\">")) {
									pw.println(fileData.replaceAll(">.*?<", ">"
											+ String.valueOf(second.getMyFloatS())
											+ "<"));
								} else if (fileData.contains("<myShortS xsi:type=\"xsd:short\">")) {
									pw.println(fileData.replaceAll(">.*?<", ">"
											+ String.valueOf(second.getMyShortS())
											+ "<"));
								} else if (fileData.contains("<myCharS xsi:type=\"xsd:char\">")) {
									pw.println(fileData.replaceAll(">.*?<", ">"
											+ String.valueOf(second.getMyCharS())
											+ "<"));
								}
							}
						}else if (myType instanceof MyAllTypesFirst) {
							MyAllTypesFirst first = (MyAllTypesFirst) myType;
							if (null != first) {
								if (fileData.contains("<complexType xsi:type=")) {
									pw.println(fileData.replaceAll("\".*?\"", "\""
											+ first.getClass()
													.getCanonicalName() + "\""));
								}
								if (fileData.contains("<myString xsi:type=\"xsd:string\">")) {
									pw.println(fileData.replaceAll(">.*?<", ">"
											+ first.getMyString() + "<"));
								} else if (fileData.contains("<myInt xsi:type=\"xsd:int\">")) {
									pw.println(fileData.replaceAll(">.*?<", ">"
											+ String.valueOf(first.getMyInt())
											+ "<"));
								} else if (fileData.contains("<myDouble xsi:type=\"xsd:double\">")) {
									pw.println(fileData.replaceAll(">.*?<", ">"
											+ String.valueOf(first.getMyDouble())
											+ "<"));
								} else if (fileData.contains("<myLong xsi:type=\"xsd:long\">")) {
									pw.println(fileData.replaceAll(">.*?<", ">"
											+ String.valueOf(first.getMyLong())
											+ "<"));
								} else if (fileData.contains("<myChar xsi:type=\"xsd:char\">")) {
									pw.println(fileData.replaceAll(">.*?<", ">"
											+ String.valueOf(first.getMyChar())
											+ "<"));
								}
							}
						}
						if (fileData.contains("</complexType>")) {
							pw.println(fileData);
						}
						if (fileData.contains("</DPSerialization>")) {
							pw.println(fileData);
							break;
						}
					}
			pw.close();
			file.close();

		} catch (IOException i) {
			System.err.println("Exception Occured :: " + i.getMessage());
			System.exit(0);
		} catch (Exception e) {
			System.err.println("Exception Occured :: " + e.getMessage());
			System.exit(0);
		} finally {
		}
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		String NEW_LINE = System.getProperty("line.separator");

		result.append("" + NEW_LINE);

		return result.toString();
	}

}

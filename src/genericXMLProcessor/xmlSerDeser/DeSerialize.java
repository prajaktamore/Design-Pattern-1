package genericXMLProcessor.xmlSerDeser;

import genericXMLProcessor.server.DeserXML;
import genericXMLProcessor.util.MyAllTypesFirst;
import genericXMLProcessor.util.MyAllTypesSecond;
import genericXMLProcessor.util.SerializableObject;
import genericXMLProcessor.utilclasses.CompareTwoClasses;
import genericXMLProcessor.utilclasses.Debug;
import genericXMLProcessor.utilclasses.FileReaderClass;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Prajakta More and Kapil Bijamwar
 * DeSerialize class that uses reflection to generate classes
 *         and calls respective methodfrom the parsed data
 */
public class DeSerialize implements DeserXML {
	static Integer finalValue = 0;

	/**
	 * DeSerialize Constructor
	 */
	public DeSerialize() {
		if (Debug.getDEBUG_VALUE() == 3) {
			CompareTwoClasses.strbuild.append("\n Constructor is called :: "
					+ this.getClass().getName());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * reflection.interfaces.IDeSerialize#deSerializeMethod(java.util.HashMap)
	 */
	public SerializableObject deSerializeMethod(HashMap<Integer, String> hashMap) {
		SerializableObject serializableObject = null;
		Class myObjectClass = null;
		try {
			if (null != hashMap.get(0)) {
				myObjectClass = Class.forName(hashMap.get(0));
			}

			Object object = myObjectClass.newInstance();
			if (object instanceof MyAllTypesFirst) {
				@SuppressWarnings("unchecked")
				Method method1 = myObjectClass.getDeclaredMethod("setMyString",
						String.class);
				@SuppressWarnings("unchecked")
				Method method2 = myObjectClass.getDeclaredMethod("setMyInt",
						int.class);
				@SuppressWarnings("unchecked")
				Method method3 = myObjectClass.getDeclaredMethod("setMyDouble",
						double.class);
				@SuppressWarnings("unchecked")
				Method method4 = myObjectClass.getDeclaredMethod("setMyLong",
						long.class);
				@SuppressWarnings("unchecked")
				Method method5 = myObjectClass.getDeclaredMethod("setMyChar",
						char.class);
				if (null != hashMap.get(1)) {
					method1.invoke(object, hashMap.get(1));
				}
				if (null != hashMap.get(2)) {
					method2.invoke(object, Integer.parseInt(hashMap.get(2)));
				}
				if (null != hashMap.get(3)) {
					method3.invoke(object, Double.parseDouble(hashMap.get(3)));
				}
				if (null != hashMap.get(4)) {
					method4.invoke(object, Long.parseLong(hashMap.get(4)));
				}
				if (null != hashMap.get(5)) {
					method5.invoke(object, hashMap.get(5).charAt(0));
				}
				if (null != myObjectClass) {
					Method m10 = object.getClass().getMethod("getMyString",
							new Class[] {});
					Object ret = m10.invoke(object, new Object[] {});
					// myAllTypesFirst.setMyString((String) ret);

					Method m11 = object.getClass().getMethod("getMyInt",
							new Class[] {});
					Object ret1 = m11.invoke(object, new Object[] {});
					// myAllTypesFirst.setMyInt((Integer) ret1);

					Method m12 = object.getClass().getMethod("getMyLong",
							new Class[] {});
					Object ret2 = m12.invoke(object, new Object[] {});
					// myAllTypesFirst.setMyLong((Long) ret2);

					Method m13 = object.getClass().getMethod("getMyChar",
							new Class[] {});
					Object ret3 = m13.invoke(object, new Object[] {});
					// myAllTypesFirst.setMyChar((Character) ret3);

					Method m14 = object.getClass().getMethod("getMyDouble",
							new Class[] {});
					Object ret4 = m14.invoke(object, new Object[] {});
					// myAllTypesFirst.setMyDouble((Double) ret4);
					serializableObject = new MyAllTypesFirst((Integer) ret1,
							(String) ret, (Double) ret4, (Long) ret2,
							(Character) ret3);
				}
			} else if (object instanceof MyAllTypesSecond) {
				@SuppressWarnings("unchecked")
				Method method1 = myObjectClass.getDeclaredMethod(
						"setMyStringS", String.class);
				@SuppressWarnings("unchecked")
				Method method2 = myObjectClass.getDeclaredMethod("setMyIntS",
						int.class);
				@SuppressWarnings("unchecked")
				Method method3 = myObjectClass.getDeclaredMethod("setMyFloatS",
						float.class);
				@SuppressWarnings("unchecked")
				Method method4 = myObjectClass.getDeclaredMethod("setMyShortS",
						short.class);
				@SuppressWarnings("unchecked")
				Method method5 = myObjectClass.getDeclaredMethod("setMyCharS",
						char.class);
				if (null != hashMap.get(1)) {
					method1.invoke(object, hashMap.get(1));
				}
				if (null != hashMap.get(2)) {
					method2.invoke(object, Integer.parseInt(hashMap.get(2)));
				}
				if (null != hashMap.get(3)) {
					method3.invoke(object, Float.parseFloat(hashMap.get(3)));
				}
				if (null != hashMap.get(4)) {
					method4.invoke(object, Short.parseShort(hashMap.get(4)));
				}
				if (null != hashMap.get(5)) {
					method5.invoke(object, hashMap.get(5).charAt(0));
				}
				if (null != myObjectClass) {

					Method m10 = object.getClass().getMethod("getMyStringS",
							new Class[] {});
					Object ret = m10.invoke(object, new Object[] {});
					// myAllTypesSecond.setMyStringS((String) ret);

					Method m11 = object.getClass().getMethod("getMyIntS",
							new Class[] {});
					Object ret1 = m11.invoke(object, new Object[] {});
					// myAllTypesSecond.setMyIntS((Integer) ret1);

					Method m12 = object.getClass().getMethod("getMyShortS",
							new Class[] {});
					Object ret2 = m12.invoke(object, new Object[] {});
					// myAllTypesSecond.setMyShortS((Short) ret2);

					Method m13 = object.getClass().getMethod("getMyCharS",
							new Class[] {});
					Object ret3 = m13.invoke(object, new Object[] {});
					// myAllTypesSecond.setMyCharS((Character) ret3);

					Method m14 = object.getClass().getMethod("getMyFloatS",
							new Class[] {});
					Object ret4 = m14.invoke(object, new Object[] {});
					// myAllTypesSecond.setMyFloatS((Float) ret4);
					serializableObject = new MyAllTypesSecond((Integer) ret1,
							(String) ret, (Float) ret4, (Short) ret2,
							(Character) ret3);
				}
			}
			return serializableObject;
		} catch (ClassNotFoundException e) {
			System.err.println("Exception Occured :: " + e.getMessage());
			e.printStackTrace();
			System.exit(0);
		} catch (NoSuchMethodException nsme) {
			System.err.println("Exception Occured :: " + nsme.getMessage());
			System.exit(0);
		} catch (IllegalAccessException iae) {
			System.err.println("Exception Occured :: " + iae.getMessage());
			iae.printStackTrace();
			System.exit(0);
		} catch (InstantiationException ie) {
			System.err.println("Exception Occured :: " + ie.getMessage());
			ie.printStackTrace();
			System.exit(0);
		} catch (InvocationTargetException ite) {
			System.err.println("Exception Occured :: " + ite.getMessage());
			ite.printStackTrace();
			System.exit(0);
		} finally {

		}
		return null;
	}

	

	

	/* (non-Javadoc)
	 * @see genericXMLProcessor.server.DeserXML#readXML(java.lang.String)
	 */
	public SerializableObject readXML(String fileName) {
		SerializableObject serializableObject = null;
		try {
			
			try {
				FileReaderClass.setFileReader(new FileReader(fileName));
			} catch (FileNotFoundException e) {
				System.err.println("Exception Occured :: " + e.getMessage());
				System.exit(0);
			}
			FileReaderClass.setBr(new BufferedReader(FileReaderClass
					.getFileReader()));

			String fileData = null;
			HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
			while ((fileData = FileReaderClass.getBr().readLine()) != null) {
				if (fileData.trim().length() != 0) {
					if (!(null != fileData && fileData
							.contains("DPSerialization"))) {
						if (null != fileData
								&& fileData.contains("<complexType")) {
							Matcher matcher = Pattern.compile(
									"^.*?" + "<" + "(.*)" + "xsi:type" + ".*$")
									.matcher(fileData);
							if (matcher.matches()) {
								hashMap = new HashMap<Integer, String>();
								Matcher matcher1 = Pattern.compile(
										"^.*?" + "\"" + "(.*)" + "\"" + ".*$")
										.matcher(fileData);
								if (matcher1.matches())
									hashMap.put(0, matcher1.group(1));
							}

						}
						if (!(null != fileData && fileData
								.contains("complexType"))) {
							Pattern tagPattern = Pattern
									.compile("<(\\S+?)(.*?)>(.*?)</\\1>");
							@SuppressWarnings("unused")
							Pattern attValueDoubleQuoteOnly = Pattern
									.compile("(\\w+)=\"(.*?)\"");
							@SuppressWarnings("unused")
							Pattern attValueAll = Pattern
									.compile("([\\w:\\-]+)(\\s*=\\s*(\"(.*?)\"|'(.*?)'|([^ ]*))|(\\s+|\\z))");
							Matcher m = tagPattern.matcher(fileData.trim());
							@SuppressWarnings("unused")
							boolean tagFound = m.find();
							@SuppressWarnings("unused")
							String tagOnly = m.group(0);
							@SuppressWarnings("unused")
							String tagname = m.group(1);
							String attributes = m.group(2);
							@SuppressWarnings("unused")
							String content = m.group(3);
							if (null != attributes && null != tagname) {
								if (null != m.group(3)) {
									if ((tagname.contains("myString") || tagname
											.contains("myStringS"))
											&& attributes
													.contains("xsd:string")) {
										hashMap.put(1, m.group(3).trim());
									} else if ((tagname.contains("myInt") || tagname
											.contains("myIntS"))
											&& attributes.contains("xsd:int")) {
										hashMap.put(2, m.group(3).trim());
									} else if ((tagname.contains("myDouble") && attributes
											.contains("xsd:double"))
											|| ((tagname.contains("myFloatS") && attributes
													.contains("xsd:float")))) {
										hashMap.put(3, m.group(3).trim());
									} else if ((tagname.contains("myLong") && attributes
											.contains("xsd:long"))
											|| ((tagname.contains("myShortS") && attributes
													.contains("xsd:short")))) {
										hashMap.put(4, m.group(3).trim());
									} else if ((tagname.contains("myChar") || tagname
											.contains("myCharS"))
											&& attributes.contains("xsd:char")) {
										hashMap.put(5, m.group(3).trim());
									}
								}
							}
						}
						if (null != fileData
								&& fileData.contains("</complexType")) {
							serializableObject = deSerializeMethod(hashMap);
						}
					}
				}
				
			}
		} catch (Exception e) {
			System.err.println("Exception Occured :: " + e.getMessage());
			System.exit(0);
		} finally {

		}
	
		
		return serializableObject;
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

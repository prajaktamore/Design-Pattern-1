package genericXMLProcessor.driver;

import genericXMLProcessor.interfaces.ICompareTwoClasses;
import genericXMLProcessor.server.DeserXML;//Interface
import genericXMLProcessor.server.SerDeserXML;//tag Interface
import genericXMLProcessor.server.SerXML;//Interface
import genericXMLProcessor.util.MyAllTypesFirst;//extends SerializableObject
import genericXMLProcessor.util.MyAllTypesSecond;//extends SerializableObject
import genericXMLProcessor.util.ProxyCreator;//Creates Proxy
import genericXMLProcessor.util.SerializableObject;//Empty base class
import genericXMLProcessor.utilclasses.CompareTwoClasses;
import genericXMLProcessor.utilclasses.Debug;
import genericXMLProcessor.xmlSerDeser.XMLHandler;//implements InvocationHandler

/**
 * @author Prajakta More and Kapil Bijamwar Driver class that calls Invoke
 *         handler to the createProxy() utility method, also driver class will
 *         call compare method which will compare the returned object with the
 *         one that was serialized for specific Intance
 */
public class Driver {
	public static void main(String[] args) {
		Debug.setDEBUG_VALUE(Integer.parseInt(args[0]), "");
		ICompareTwoClasses compareTwoClasses = new CompareTwoClasses();
		ProxyCreator pc = new ProxyCreator();
		SerDeserXML serDeserRef = (SerDeserXML) pc.createProxy(new Class[] {
				SerXML.class, DeserXML.class }, new XMLHandler());

		SerializableObject myF = new MyAllTypesFirst(19, "Design Patterns",
				315.0, 19, 'P');
		((SerXML) serDeserRef).writeXML(myF, "myAllTypesA.txt");
		if (Debug.getDEBUG_VALUE() == 2) {
			compareTwoClasses.compare(myF,
					(((DeserXML) serDeserRef).readXML("myAllTypesA.txt")));
		}

		Short s1 = 4;
		Float f1 = 3.14f;
		SerializableObject myS = new MyAllTypesSecond(20, "Advance OOP's", f1,
				s1, 'K');
		((SerXML) serDeserRef).writeXML(myS, "myAllTypesB.txt");

		if (Debug.getDEBUG_VALUE() == 2) {
			compareTwoClasses.compare(myS,
					(((DeserXML) serDeserRef).readXML("myAllTypesB.txt")));
		}
		System.out.println(CompareTwoClasses.strbuild.toString());
	}
}

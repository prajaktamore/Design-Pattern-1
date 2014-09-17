package genericXMLProcessor.util;

import genericXMLProcessor.server.SerDeserXML;
import genericXMLProcessor.utilclasses.CompareTwoClasses;
import genericXMLProcessor.utilclasses.Debug;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author Prajakta More and Kapil Bijamwar
 * ProxyCreator utility class to create a dynamic proxy reference
 */
public class ProxyCreator {
	public ProxyCreator() {
		if(Debug.getDEBUG_VALUE() == 3){
		CompareTwoClasses.strbuild.append("\n Constructor is called :: "+ this.getClass().getName());}
	}

	/**
	 * @param interfaceArray
	 * @param handler
	 * @return SerDeserXML
	 */
	public SerDeserXML createProxy(Class<?>[] interfaceArray, InvocationHandler handler){
		SerDeserXML serDeserObj =
            (SerDeserXML)
            Proxy.newProxyInstance(
                                   getClass().getClassLoader(),
                                   interfaceArray,
                                   handler
                                   );
		return serDeserObj;
	}
	@Override
	public String toString() {
	    StringBuilder result = new StringBuilder();
	    String NEW_LINE = System.getProperty("line.separator");

	    result.append(""+ NEW_LINE);
	    
	    return result.toString();
	  }

}

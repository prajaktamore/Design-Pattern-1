package genericXMLProcessor.xmlSerDeser;

import genericXMLProcessor.utilclasses.CompareTwoClasses;
import genericXMLProcessor.utilclasses.Debug;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author @author Prajakta More and Kapil Bijamwar
 * Invocation handler (an instance of XMLHandler) to the createProxy() utility method
 *
 */
public class XMLHandler implements InvocationHandler {
	private Object testImpl;
	public XMLHandler() {
		if(Debug.getDEBUG_VALUE() == 3){
		CompareTwoClasses.strbuild.append("\n Constructor is called :: "+ this.getClass().getName());}
	}

	/* (non-Javadoc)
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 */
	@Override
	public Object invoke(Object proxy, Method m, Object[] args)
			throws Throwable {
		Object result;
		try {
			if(m.getName().equals("writeXML")){
				testImpl = new Serialize();
			}else{
				testImpl = new DeSerialize();
			}
			result = m.invoke(testImpl, args);
		} catch (InvocationTargetException e) {
			throw e.getTargetException();
		} catch (Exception e) {
			throw new RuntimeException("unexpected invocation exception: "
					+ e.getMessage());
		} finally {
			CompareTwoClasses.strbuild.append("\n After method :: " + m.getName());
		}
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
	    StringBuilder result = new StringBuilder();
	    String NEW_LINE = System.getProperty("line.separator");

	    result.append(""+ NEW_LINE);
	    
	    return result.toString();
	  }

}
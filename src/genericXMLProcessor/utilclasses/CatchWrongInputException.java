package genericXMLProcessor.utilclasses;

/**
 * @author Prajakta More and Kapil Bijamwar 
 * User Defined exception class, That
 *         validates input data
 */
public class CatchWrongInputException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param s
	 */
	public CatchWrongInputException(String s) {
		super(s);
	}
	/* (non-Javadoc)
	 * @see java.lang.Throwable#toString()
	 */
	@Override
	public String toString() {
	    StringBuilder result = new StringBuilder();
	    String NEW_LINE = System.getProperty("line.separator");

	    result.append(""+ NEW_LINE);
	    
	    return result.toString();
	  }

}

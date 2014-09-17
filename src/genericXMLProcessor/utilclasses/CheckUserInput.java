package genericXMLProcessor.utilclasses;

import genericXMLProcessor.interfaces.ICheckUserInput;

/**
 * @author Prajakta More and Kapil Bijamwar 
 * Checks the input validity
 */
public class CheckUserInput implements ICheckUserInput {

	/**
	 * CheckUserInput COnstructor
	 */
	public CheckUserInput() {
		if (Debug.getDEBUG_VALUE() == 3) {
			CompareTwoClasses.strbuild.append("\n Constructor is called :: "
					+ this.getClass().getName());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * reflection.interfaces.ICheckUserInput#checkUserInput(java.lang.String,
	 * java.lang.String, int)
	 */
	public void checkUserInput(String inputFile1, String inputFile2, int input)
			throws CatchWrongInputException {
		try {
			if (null == inputFile1 || inputFile1.trim().equals(" ")
					|| inputFile1.length() == 0) {
				throw new CatchWrongInputException("Input String is not valid");
			}
			if (null == inputFile2 || inputFile2.trim().equals(" ")
					|| inputFile2.length() == 0) {
				throw new CatchWrongInputException("Input String is not valid");
			}
			if (input < 1 && input > 3) {
				throw new CatchWrongInputException(
						"DEBUG value is between 1 to 3");
			}

		} catch (CatchWrongInputException e) {
			System.err.println("Exception Occured :: " + e.getMessage());
			System.exit(0);

		} finally {
		}
	}
	@Override
	public String toString() {
	    StringBuilder result = new StringBuilder();
	    String NEW_LINE = System.getProperty("line.separator");

	    result.append(""+ NEW_LINE);
	    
	    return result.toString();
	  }

}

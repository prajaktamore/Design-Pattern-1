package genericXMLProcessor.utilclasses;


/**
 * @author Prajakta More and Kapil Bijamwar
 *  Debugger class that maintains logging information
 */
public class Debug {
	public Debug() {
		if (Debug.getDEBUG_VALUE() == 3) {
			CompareTwoClasses.strbuild.append("\n Constructor is called :: "
					+ this.getClass().getName());
		}
	}

	/**
	 * Integer Variable DEBUG_VALUE used for Logger
	 */
	private static int DEBUG_VALUE;

	// accessor and mutator for DEBUG_VALUE

	/**
	 * @return the dEBUG_VALUE
	 */
	public static int getDEBUG_VALUE() {
		return DEBUG_VALUE;
	}

	/**
	 * @param dEBUG_VALUE
	 *            the dEBUG_VALUE to set
	 */
	public static void setDEBUG_VALUE(int dEBUG_VALUE, String className) {
		DEBUG_VALUE = dEBUG_VALUE;
		if (DEBUG_VALUE == 1) {
			CompareTwoClasses.strbuild
					.append("\n Debug Value Selected is No output printed");
			CompareTwoClasses c = new CompareTwoClasses();
			CompareTwoClasses.strbuild.append("\n"+c.toString());
			System.exit(0);
		}
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		String NEW_LINE = System.getProperty("line.separator");

		result.append("" + NEW_LINE);

		return result.toString();
	}

}
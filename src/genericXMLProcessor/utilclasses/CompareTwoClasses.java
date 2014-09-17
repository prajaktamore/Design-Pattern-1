package genericXMLProcessor.utilclasses;

import genericXMLProcessor.interfaces.ICompareTwoClasses;
import genericXMLProcessor.util.SerializableObject;

/**
 * @author Prajakta More and Kapil Bijamwar 
 * Compares the arraylists to find uniqueInstance
 */
public class CompareTwoClasses implements ICompareTwoClasses {
	public static StringBuilder strbuild = new StringBuilder();

	/**
	 * CompareTwoClasses constructor
	 */
	public CompareTwoClasses() {
		if (Debug.getDEBUG_VALUE() == 3) {
			CompareTwoClasses.strbuild.append("\n Constructor is called :: "
					+ this.getClass().getName());
		}
	}

	/* (non-Javadoc)
	 * @see genericXMLProcessor.interfaces.ICompareTwoClasses#compare(genericXMLProcessor.util.SerializableObject, genericXMLProcessor.util.SerializableObject)
	 */
	public void compare(SerializableObject ser1, SerializableObject ser2) {
		if (ser1.equals(ser2) && ser1.hashCode() == ser2.hashCode()) {
			CompareTwoClasses.strbuild.append("\n Both are Equal");
		} else {
			CompareTwoClasses.strbuild.append("\n Not Equal");
		}

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return strbuild.toString();
	}

}

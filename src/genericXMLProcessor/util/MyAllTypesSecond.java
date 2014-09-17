package genericXMLProcessor.util;

/**
 * @author Prajakta More and Kapil Bijamwar MyAllTypesSecond POJO class
 */
public class MyAllTypesSecond extends SerializableObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1l;
	private int myIntS;
	private String myStringS;
	private float myFloatS;
	private short myShortS;
	private char myCharS;

	public MyAllTypesSecond() {
	}
	
	public MyAllTypesSecond(int inMyIntS, String inMyStringS, float inMyFloatS,
			short inMyShortS, char inMyCharS) {
		this.myIntS = inMyIntS;
		this.myStringS = inMyStringS;
		this.myFloatS = inMyFloatS;
		this.myShortS = inMyShortS;
		this.myCharS = inMyCharS;
	}

	/**
	 * @return the myIntS
	 */
	public int getMyIntS() {

		return myIntS;
	}

	/**
	 * @param myIntS
	 *            the myIntS to set
	 */
	public void setMyIntS(int myIntS) {
		this.myIntS = myIntS;
	}

	/**
	 * @return the myStringS
	 */
	public String getMyStringS() {
		return myStringS;
	}

	/**
	 * @param myStringS
	 *            the myStringS to set
	 */
	public void setMyStringS(String myStringS) {
		this.myStringS = myStringS;
	}

	/**
	 * @return the myFloatS
	 */
	public float getMyFloatS() {
		return myFloatS;
	}

	/**
	 * @param myFloatS
	 *            the myFloatS to set
	 */
	public void setMyFloatS(float myFloatS) {
		this.myFloatS = myFloatS;
	}

	/**
	 * @return the myShortS
	 */
	public short getMyShortS() {
		return myShortS;
	}

	/**
	 * @param myShortS
	 *            the myShortS to set
	 */
	public void setMyShortS(short myShortS) {
		this.myShortS = myShortS;
	}

	/**
	 * @return the myCharS
	 */
	public char getMyCharS() {
		return myCharS;
	}

	/**
	 * @param myCharS
	 *            the myCharS to set
	 */
	public void setMyCharS(char myCharS) {
		this.myCharS = myCharS;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + myCharS;
		result = prime * result + Float.floatToIntBits(myFloatS);
		result = prime * result + myIntS;
		result = prime * result + myShortS;
		result = prime * result
				+ ((myStringS == null) ? 0 : myStringS.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyAllTypesSecond other = (MyAllTypesSecond) obj;
		if (myCharS != other.myCharS)
			return false;
		if (Float.floatToIntBits(myFloatS) != Float
				.floatToIntBits(other.myFloatS))
			return false;
		if (myIntS != other.myIntS)
			return false;
		if (myShortS != other.myShortS)
			return false;
		if (myStringS == null) {
			if (other.myStringS != null)
				return false;
		} else if (!myStringS.equals(other.myStringS))
			return false;
		return true;
	}
	@Override
	public String toString() {
	    StringBuilder result = new StringBuilder();
	    String NEW_LINE = System.getProperty("line.separator");

	    result.append(""+ NEW_LINE);
	    
	    return result.toString();
	  }

}

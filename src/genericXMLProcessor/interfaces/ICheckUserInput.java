package genericXMLProcessor.interfaces;

import genericXMLProcessor.utilclasses.CatchWrongInputException;


/**
 * @author Prajakta More and Kapil Bijamwar
 * Interface that checks the input validity
 */
public interface ICheckUserInput {
	/**
	 * @param inputFile
	 * @param outputFile
	 * @param input
	 * @throws CatchWrongInputException
	 */
	public void checkUserInput(String inputFile, String outputFile, int input)
			throws CatchWrongInputException;

}

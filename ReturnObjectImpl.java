/**
 * A wrapper containing either an object (the result of an operation
 * on a data structure) or an error value.
 *
 * @author PiJ
 */
public class ReturnObjectImpl implements ReturnObject{
	private ErrorMessage theErrorMessage;
	private Object returnObject;
	
	
	/**
	 * Gets the error message
	 * @return the error message
	 */
	public ErrorMessage getErrorM() {
		return theErrorMessage;
	}
	/**
	 * Sets the error message
	 * @param theErrorMessage
	 */
	public void setErrorM(ErrorMessage theErrorMessage) {
		this.theErrorMessage = theErrorMessage;
	}
	/**
	 * Gets the object
	 * @return the object
	 */
	public Object getObject() {
		return returnObject;
	}
	/**
	 * Sets the object
	 * @param returnObject
	 */
	public void setObject(Object returnObject) {
		this.returnObject = returnObject;
	}

	/**
	 * Checks whether there has been an error
	 * @return true if there has been an error, otherwise false.
	 */
	public boolean hasError(){
		if(this.theErrorMessage == ErrorMessage.NO_ERROR || this.theErrorMessage == null){
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Returns the error message. 
	 * 
	 * This method must return NO_ERROR if and only if
	 * {@hasError} returns false.
	 * 
	 * @return the error message
	 */
	public ErrorMessage getError(){
		if (this.hasError() == false){
			return ErrorMessage.NO_ERROR;
		} else {
			return this.theErrorMessage;
		}
	}

	/**
	 * Returns the object wrapped in this ReturnObject, i.e. the
	 * result of the operation if it was successful, or null if
	 * there has been error.
	 * 
	 * Note that the output of this method must be null if {@see
	 * hasError} returns true, but the opposite is not true: if
	 * {@see hasError} returns false, this method may or may not
	 * return null.
	 * 
	 * @return the return value from the method or null if there has been an
	 *         error
	 */
	public Object getReturnValue(){
		if (this.hasError() == true){
			return null;
		}
		return this.returnObject;  //DOUBLE CHECK THIS 
	}
}
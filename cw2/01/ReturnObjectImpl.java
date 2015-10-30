/**
 * A wrapper containing either an object (the result of an operation
 * on a data structure) or an error value.
 *
 * @author PiJ
 */
public class ReturnObjectImpl implements ReturnObject{

	/**
	 * Returns whether there has been an error
	 * @return whether there has been an error
	 */
	public boolean hasError(){
		if(this.equals(null)){ //For example if object is null there has been an error
			return true;
		} else {
			return false;
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
		if (!this.hasError()){
			return NO_ERROR; // returns NO_ERROR if hasError() returns false
		} else {
			return this; // returns the error message
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
		if (!this.getError().equals(this)){
			return this; // returns the value from the method 
		} else if (this.hasError()){
			return null; // returns null as there has been an error
		} 
		return false;
	}
}
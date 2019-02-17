/**
 * 
 */
package com.esnagofer.lib;


/**
 * The Class Validate.
 */
public class Validate {

	/**
	 * Checks if is empty string.
	 *
	 * @param value the value
	 * @return true, if is empty string
	 */
	public static boolean isEmptyString(String value){
		return (value == null || "".equals(value));
	}
	
	/**
	 * Checks if is null.
	 *
	 * @param value the value
	 * @return true, if is null
	 */
	public static boolean isNull(Object value){
		return (value == null);
	}

	/**
	 * That is not empty.
	 *
	 * @param msg the msg
	 * @param value the value
	 */
	public static void thatIsNotEmpty(String msg, String value){
		if (isEmptyString(value)) throw new IllegalStateException(msg);
	}

	/**
	 * That is not null.
	 *
	 * @param msg the msg
	 * @param value the value
	 */
	public static void thatIsNotNull(String msg, Object value){
		if (isNull(value)) throw new IllegalStateException(msg);
	}

	/**
	 * Custom.
	 *
	 * @param msg the msg
	 * @param value the value
	 * @param validator the validator
	 */
	public static void custom(String msg, Object value, Validator validator){
		if (!validator.isValid(value)) throw new IllegalStateException(String.format(msg, value));
	}

	/**
	 * The Interface Validator.
	 */
	public interface Validator {

		/**
		 * Checks if is valid.
		 *
		 * @param value the value
		 * @return true, if is valid
		 */
		public boolean isValid(Object value);
		
	}
	
}

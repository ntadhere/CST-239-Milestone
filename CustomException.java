/**
 * Truong Anh Dao Nguyen
 * CST-239
 * 11/12/2023
 * This is Custom Exception
 * This is my own work
 */

package exception;

/**
 * Custom Checked Exception
 */
public class CustomException extends Exception
{
	private static final long serialVersionUID = 1L;
	
	/**
	 * Default constructor for customException class
	 * @param msg is custom exception message
	 */
	public CustomException(String msg)
	{
		super(msg);
	}
	
	/**
	 * Non-default constructor to support Exception wrapping (to avoid losing some of the Stack Trace)
	 * @param e Source of the exception
	 * @param msg Custom error message for the exception
	 */
	public CustomException(Throwable e, String msg)
	{
		super(msg, e);
	}

	public void getMessage(String string)
	{
		// TODO Auto-generated method stub
		
	}
}

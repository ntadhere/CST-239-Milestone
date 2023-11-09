package exception;

/*
 * Example Custom Checked Exception
 * @author dao
 */
public class CustomException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
}

package exception;

public class AlreadyInTheListException extends Exception{
	
	private String type;
	
		public AlreadyInTheListException(String type)
		{
			this.type = type;
		}
	
		public String getMessage()
		{
			return "The "+ type + " is already in the list.";
		}
	
}

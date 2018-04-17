package csp;

public class Value<T>
{

	private static int hashcodecounter = 0;
	private T value;
	private int hashcode;
	
	
	
	public T value()
	{
		return value;
	}
		
	
	
	public Value(T value)
	{
		this.value = value;
		hashcode = hashcodecounter++;
	}
	
	
	@Override
	public boolean equals(Object obj)
	{
		if ( obj == null )
			return false;
		
		return value == ((Value<T>)obj).value;
	}
	
		
	
	/******************************************************************************************
	 * 	COLLECTIONS FRAMEWORK COMPATIBILITY
	 *****************************************************************************************/
	
	public int hashCode()
	{
		return hashcode;
	}
	
}

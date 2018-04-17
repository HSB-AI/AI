package csp;

public class Arc<T>
{

	public static <T> Arc<T> get(Variable<T> var1, Variable<T> var2)
	{
		return new Arc<T>(var1, var2);
	}
	
	
	
	/******************************************************************************************
	 * 	MEMEBERS
	 *****************************************************************************************/
	
	private Variable<T> var1;
	private Variable<T> var2;	
	
	
	
	/******************************************************************************************
	 * 	CONSTRUCTOR
	 *****************************************************************************************/
	
	public Arc(Variable<T> var1, Variable<T> var2)
	{
		this.var1 = var1;
		this.var2 = var2;
	}
	
	
	
	/******************************************************************************************
	 * 	METHODS
	 *****************************************************************************************/
	
	public Variable<T> var1()
	{
		return var1;
	}
	
	
	public Variable<T> var2()
	{
		return var2;
	}
	
	
	public Variable<T> otherEnd(Variable<T> var)
	{
		if ( var.equals(var1) )
			return var2;
		else if ( var.equals(var2) )
			return var1;
		
		return null;
	}
	
	
	public boolean contains(Variable<T> var)
	{
		return var.equals(var1) || var.equals(var2);
	}
	
	
	
	/******************************************************************************************
	 * 	OVERRIDES
	 *****************************************************************************************/
	
	@Override
	public int hashCode()
	{
		return var1.hashCode() ^ var2.hashCode();
	}
	
}

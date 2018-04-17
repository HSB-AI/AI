package csp.entities;

import java.util.HashSet;
import java.util.Set;

public class Variable<T>
{
	
	/******************************************************************************************
	 * 	MEMEBERS
	 *****************************************************************************************/
	
	private String name;
	private Set<T> possibleValues;
	private T assignedValue;
	
	
	
	/******************************************************************************************
	 * 	Constructor
	 *****************************************************************************************/
	
	public Variable(String name, Set<T> domain)
	{
		this.name = name;
		possibleValues = new HashSet<>();
		possibleValues.addAll(domain);
		assignedValue = null;
	}
	
	
	
	/******************************************************************************************
	 * 	METHODS
	 *****************************************************************************************/
	
	public String name()
	{
		return name;
	}
	
	
	public Set<T> possibleValues()
	{
		return possibleValues;
	}
	
	
	public T assignedValue()
	{
		return assignedValue;
	}
	
	
	public void assign(T assignedValue)
	{
		this.assignedValue = assignedValue;
	}
	
	
	public void unassign()
	{
		assignedValue = null;
	}
	
	
	public boolean assigned()
	{
		return assignedValue != null;
	}
	
	
	public boolean unassigned()
	{
		return assignedValue == null;
	}
	
	
	
	/******************************************************************************************
	 * 	OVERRIDES
	 *****************************************************************************************/
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj)
	{
		if ( obj == null )
			return false;
		
		if ( obj == this )
			return true;
		
		if ( !(obj instanceof Variable<?>) )
			return false;
		else			
			return ((Variable<T>)obj).name == name;
	}
	
	
	@Override
	public int hashCode()
	{
		return name.hashCode();
	}
	
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(name + ": ");
		sb.append(assignedValue == null ? "-" : assignedValue.toString());
		
		if ( unassigned() )
		{
			sb.append(" {");
			
			for ( T val : possibleValues )
				sb.append(val.toString() + " ");
			
			sb.append("}");
		}
		
		return sb.toString();
	}
}

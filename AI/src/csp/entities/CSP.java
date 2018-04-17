package csp.entities;

import java.util.Set;

public class CSP<T>
{
	
	/******************************************************************************************
	 * 	MEMEBERS
	 *****************************************************************************************/
	
	private Set<Variable<T>> vars;
	private Set<Arc<T>> arcs;
	private IConstraint constr;
	
	
	
	/******************************************************************************************
	 * 	GETTER
	 *****************************************************************************************/
	
	public Set<Variable<T>> vars()
	{
		return vars;
	}
	
	public Set<Arc<T>> arcs()
	{
		return arcs;
	}
	
	public IConstraint constraint()
	{
		return constr;
	}
	
	
	
	/******************************************************************************************
	 * 	CONSTRUCTOR
	 *****************************************************************************************/
	
	public CSP(Set<Variable<T>> vars, Set<Arc<T>> arcs, IConstraint constr)
	{
		this.vars = vars;
		this.arcs = arcs;
		this.constr = constr;
	}
	
	
	
	/******************************************************************************************
	 * 	OVERRIDES
	 *****************************************************************************************/
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		for ( Variable<T> var : vars )
			sb.append(var + System.lineSeparator());
		return sb.toString();
	}
}

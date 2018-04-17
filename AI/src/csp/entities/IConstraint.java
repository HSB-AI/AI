package csp.entities;

public interface IConstraint
{
	public abstract <T> boolean isApplied(Variable<T> var1, Variable<T> var2);
}

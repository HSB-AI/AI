package csp.entities;

public class NotEqualConstraint implements IConstraint
{

	@Override
	public <T> boolean isApplied(Variable<T> var1, Variable<T> var2)
	{		
		if (
			var1.assigned() &&
			var2.assigned() &&
			var1.assignedValue().equals(var2.assignedValue())
		)
			return false;
		
		return true;
	}

}

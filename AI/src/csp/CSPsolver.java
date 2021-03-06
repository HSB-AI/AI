package csp;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

import csp.entities.Arc;
import csp.entities.CSP;
import csp.entities.IConstraint;
import csp.entities.Variable;

public class CSPsolver<T>
{
	
	public boolean backtrackSearch(CSP<T> problem)
	{
		if (
			problem.vars() == null || problem.vars().size() == 0 ||
			problem.arcs() == null || problem.arcs().size() == 0 ||
			problem.constraint() == null
		)
			return false;
		
		return backtrackSearch(problem.vars(), problem.arcs(), problem.constraint(), 0, 0);
	}
	
	
	
	private boolean backtrackSearch(Set<Variable<T>> vars, Set<Arc<T>> arcs, IConstraint constr, int assigned, int depth)
	{
		System.out.println("depth: "+depth+", assigned: "+assigned);
		printAssignments(vars);
		
		if ( assigned == vars.size() )
		{
			return true;
		}
		
		Variable<T> selected = nextVar(vars, true);				
		boolean backtrackResultOk = false;
		Set<Variable<T>> filteredVars;
		
		if ( selected != null )
		{
			if ( selected.possibleValues().size() == 0 )
				return false;
			
			for ( T val : selected.possibleValues() )
			{
				selected.assign(val);
				
				if ( constraintsSatisfied(arcs, constr) )
				{				
					filteredVars = forwardChecking(arcs, selected);
					
					backtrackResultOk = backtrackSearch(vars, arcs, constr, ++assigned, ++depth);
					
					if ( !backtrackResultOk )
					{
						undoForwardChecking(filteredVars, selected.assignedValue());
						selected.unassign();
					}
					else
					{
						return true;
					}
				}
				else
				{
					selected.unassign();
				}
			}
		}
				
		return false;
//		throw new NoSuchElementException("No solution found :(");
	}
	
	
	
	private boolean constraintsSatisfied(Set<Arc<T>> arcs, IConstraint constr)
	{		
		for ( Arc<T> arc : arcs )
		{
			if ( !constr.isApplied(arc.var1(), arc.var2()) )
				return false;
		}
		
		return true;
	}
	
	
	
	/******************************************************************************************
	 * 	ORDERING
	 *****************************************************************************************/
	
	private Variable<T> nextVar(Set<Variable<T>> vars, boolean mrv)
	{
		Variable<T> selected = null;
		int minSize = Integer.MAX_VALUE;
		int size;
		
		for ( Variable<T> var : vars )
		{
			if ( var.unassigned() )
			{
				if ( mrv )
				{
					size = var.possibleValues().size();
					if ( size < minSize )
					{
						selected = var;
						minSize = size;
					}
				}
				else
				{
					selected = var;
					break;
				}
			}
		}
		
		return selected;
	}
	
	
	
	/******************************************************************************************
	 * 	FILTERING
	 *****************************************************************************************/	
	
	private void enforceArcConsistency(Set<Arc<T>> arcs, IConstraint constr)
	{
		Set<Arc<T>> queue = new HashSet<>(arcs);
		Arc<T> currentArc;
		
		while ( !queue.isEmpty() )
		{
			queue.iterator().next();
		}
	}
	
	
	
	//enforces the given arc to be bidirectional consistent (that is X -> Y & Y -> X)
	private boolean makeArcConsistent(Arc<T> arc, IConstraint constr)
	{
		boolean changed = false;
		
		Variable<T> var1 = arc.var1();
		Variable<T> var2 = arc.var2();
		
		if (removeValue(var1, var2, constr) )
			changed = true;
		
		if (removeValue(var2, var1, constr) )
			changed = true;
		
		if ( var1.emptyDomain() || var2.emptyDomain() )
			throw new NoSuchElementException("There is no solution to the problem using the given constraints!");
		
		return changed;
	}
	
	
	
	// X -> Y: for every x in the tail X there is some y in the head Y which satisfies the constraint
	private boolean removeValue(Variable<T> head, Variable<T> tail, IConstraint constr)
	{
		boolean satisfactoryCombinationFound = false;
		Set<T> toBeRemoved = new HashSet<>();
		
		for ( T x : tail.possibleValues() )
		{
			satisfactoryCombinationFound = false;
			
			tail.assign(x);
			
			for ( T y : head.possibleValues() )
			{
				head.assign(y);
				
				if ( constr.isApplied(head, tail) )
				{
					satisfactoryCombinationFound = true;
					break;
				}
			}
			
			if ( !satisfactoryCombinationFound )
			{
				toBeRemoved.add(x);
			}			
		}
		
		return tail.possibleValues().removeAll(toBeRemoved);
	}
	
	
	// only checks assigned variable and its neighbors!
	private Set<Variable<T>> forwardChecking(Set<Arc<T>> arcs, Variable<T> assigned)
	{
		boolean filtered;
		Variable<T> filterTarget = null;
		Set<Variable<T>> filteredVars = new HashSet<>();
		
		for ( Arc<T> arc : arcs )
		{
			filterTarget = arc.otherEnd(assigned);
			
			if ( filterTarget != null )
			{
				filtered = filterTarget.possibleValues().remove(assigned.assignedValue());
				
				if ( filtered )
				{
					filteredVars.add(filterTarget);
				}
			}
		}
		
		return filteredVars;
	}
	
	
	
	private void undoForwardChecking(Set<Variable<T>> filteredVars, T filteredValue)
	{
		if ( filteredVars == null )
			return;
		
		for ( Variable<T> var : filteredVars )
			var.possibleValues().add(filteredValue);
	}
	
	
	
	private void printAssignments(Set<Variable<T>> vars)
	{
		System.out.println("--------------------");
		for ( Variable<T> var : vars )
			System.out.println(var);
	}
	
}

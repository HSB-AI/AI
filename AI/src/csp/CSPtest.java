package csp;

import java.util.HashSet;
import java.util.Set;

import csp.entities.Arc;
import csp.entities.CSP;
import csp.entities.IConstraint;
import csp.entities.NotEqualConstraint;
import csp.entities.Variable;

public class CSPtest<T>
{

	public static void main(String args[])
	{				
		CSPsolver<String> solver = new CSPsolver<>();
		
		CSP<String> problem = australiaMapColoringProblem();
		solver.backtrackSearch(problem);
		System.out.println(problem);
	}
	
	public static CSP<String> australiaMapColoringProblem()
	{
		Set<String> domain = new HashSet<>();
		domain.add("red");
		domain.add("green");
		domain.add("blue");
		
		Variable<String> wa = new Variable<>("WA", domain);		
		Variable<String> nt = new Variable<>("NT", domain);
		Variable<String> q = new Variable<>("Q", domain);
		Variable<String> nsw = new Variable<>("NSW", domain);
		Variable<String> v = new Variable<>("V", domain);
		Variable<String> sa = new Variable<>("SA", domain);
		Variable<String> t = new Variable<>("T", domain);
		
		Set<Variable<String>> vars = new HashSet<>();
		vars.add(wa);
		vars.add(nt);
		vars.add(q);
		vars.add(nsw);
		vars.add(v);
		vars.add(sa);
		vars.add(wa);
		vars.add(t);
								
		Set<Arc<String>> arcs = new HashSet<>();
		
		arcs.add(Arc.get(wa, nt));
		arcs.add(Arc.get(wa, sa));
		arcs.add(Arc.get(q, nt));
		arcs.add(Arc.get(q, sa));
		arcs.add(Arc.get(sa, nt));
		
		arcs.add(Arc.get(nsw, q));
		arcs.add(Arc.get(nsw, sa));
		arcs.add(Arc.get(v, sa));
		arcs.add(Arc.get(v, nsw));
		
		IConstraint neq = new NotEqualConstraint();
		
		return new CSP<>(vars, arcs, neq);
	}
	
}

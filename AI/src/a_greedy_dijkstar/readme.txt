The "AGreedyDjikstar" Framework offers solutions to problems.
The problem must be expressed as a tree or graph.
A "Graph" object is always required though, because a tree is just a graph without cycles

Available solving methods use the formula

f = g + h, where
g is the weighed edge cost (summed along the path so far),
h is the heuristic (an approximation of how close the current node is to the goal node),
f is the composed cost

How the formula is used varies as follows:
- Greedy Search:	g = 0,				f = h		-> edge weights not considered
- Dijkstra Search:	h = 0, 				f = g		-> heuristics not considered
- A* Search:		g != 0, h != 0,		f = g + h	-> both, edge weights & heuristics, are considered





	// G: g(n) is the SUM of all costs along the path to n!
	
	// A:	f(n) 	= 	g(n) 	+	h(n)
	// B:	f(n-1)	= 	g(n-1) 	+	h(n-1)
	
	// C:	g(n-1)	= 	f(n-1)	-	h(n-1)
	
	// D:	f(n) 	= 	g(n-1)					+	cost(n-1, n)	+	h(n)
	// E:	f(n) 	= 	f(n-1)	-	h(n-1)		+	cost(n-1, n)	+	h(n)
	
	// adjacentNode	= n					-> what we want to know: its f(n)
	// currentNode	= n-1				=> so we know B	which implies we also know C	
	// adjacentCost = cost(n-1, n)		=> knowing G we know D which evaluates to E
	
	// Depending on the algorithm used E may be simplified because we know which algorithm considers which value

	// A*:			f(n) 	= 	f(n-1)	-	h(n-1)		+	cost(n-1, n)	+	h(n)
	// Dijkstra 	f(n) 	= 	f(n-1)					+	cost(n-1, n)
	// Greedy		f(n) 	= 													h(n)
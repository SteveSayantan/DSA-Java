# Graph Basics

#### Terminologies

1. `Simple Graph` : A graph having no parallel edges and no self-loops is called a simple graph.

1. `Regular Graph`: A graph in which all vertices are of same degree is known as a regular graph.

1. `Null Graph`: If every vertex of a graph is an isolated vertex i.e. no edge is present, then it is a null graph.
    - In a graph the edge set may be empty but the vertex set must be non-empty

1. `Complete Graph`: A simple graph in which there exists an edge between every pair of vertices is said to be a complete graph. 
    - In a complete graph of *n* vertices the degree of every vertex is *n-1* and the number of edges is *<sup>n</sup>C<sub>2</sub> = n(n-1)/2*
    - A complete graph is always a regular graph.

1. `Sub-Graph`: A graph *g* is called a sub-graph of graph *G* if all the vertices and all the edges of *g* are in *G* and each edge of *g* has the same end vertices in *g* as in *G* . 
    - A graph G is a sub-graph of itself.
    - A single vertex of a graph G is a sub-graph of G.
    - A single edge together with its end vertices of a graph G is a sub-graph of G.

1. `Isomorphic Graphs`: Two graphs G and G' are isomorphic if they have
    - same number of vertices
    - same number of edges
    - the corresponding vertices have the same degree
    - the incidence relationships between vertices and edges are preserved

1. `Fundamental Numbers`: For a graph *G*, the number of vertices *n*, the number of edges *e* and the number of components *k* of *G* are called fundamental numbers of *G*.
    - If *k*=1, then *G* is connected.
    - Since each component of a graph must have at least one vertex, *n*>=*k*.
    - Since, the minimum number of edges in a connected graph with *n* vertices is *n-1*, therefore *e*>=*n-1* and also *e*>=*n-k* (By theorem 6)

    - The rank and nullity of graph G is denoted as *r=n-k* and *u=e-n+k* respectively.
        - *r=n-k>=0* , *u= e-n+k>=0*

1. `Walk`: An finite alternating sequence of vertices and edges beginning and ending with vertices such that each edge is incident to preceding and following vertices.

    - The origin and termius of walk may be the same.

    - A vertex may appear twice or more in a walk.

    - A self loop can be included in a walk.

    - The number of edges in a walk is called the length of the walk.

    - If a walk begins and ends at the same vertex then walk is called closed walk.

    - A walk beginning and ending at different vertices is called a simple walk.
    
    - A simple walk in which no vertex appears twice or more is called a path.

    - A simple walk in which all the edges are distinct is called a path.

    - A closed walk in which no edge appears more than once is called a circuit.

    - A closed walk in which no edges and no vertices except the two terminal vertices repeat is called a cycle.

      - A graph contains a cycle if there is a way to take a closed walk (starting from any vertex) without repeating any vertices (except the terminal ones). 

    - Every cycle is a circuit but every circuit may not be a cycle.

1. `Distance between vertices` : The length of the shortest path between two vertices.

1. `Diameter of a Graph` : The maximum **distance** between any two vertices.

1. `Connected Graph`: To be continued...

#### Important Theorems

1. The sum of the degrees of all vertices in a graph G is twice the sum of edges in the graph G.

1. The number of vertices of odd degree in a graph is always even.

1. Degree of any vertex in a simple graph with *n* vertices can not exceed *n-1*.

1. The number of edges in a simple graph with *n* vertices cannot exceed *n(n-1)/2*

1. The minimum number of edges in a connected graph with *n* vertices is *n-1*.

1. The minimum number of edges in a graph with *n* vertices is *n-k*, where *k* is the number of connected components of the graph.

1. To be continued from Tree theorems


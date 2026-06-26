Question 2.A: The Arbitrary Pointer
Consider a specialized variation of a singly linked list where every discrete node contains a standard structural
next pointer along with an additional random pointer (which can reference any arbitrary node resident within the
topology, or evaluate to null). Formalize an algorithm to construct an independent deep copy of this list. The
procedure must strictly execute in a single-pass or constant-pass runtime bounded by O(n) time complexity,
utilizing exactly O(1) auxiliary space (excluding the target heap allocations explicitly required for the cloned
destination list). Document the phase mutations of the structural pointers.
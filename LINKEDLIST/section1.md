# Copy List with Random Pointer

## Question
Given a linked list where each node has:
- `next` pointer
- `random` pointer

Create a **deep copy** of the entire list.

## Idea
Use a **HashMap** to store the mapping from each original node to its copied node. This allows us to rebuild both `next` and `random` links correctly [web:104][web:115].

## Algorithm
### Step 1: Create copied nodes
Traverse the original list and create a new node for each original node. Store the mapping:
- `original node -> copied node`

### Step 2: Connect pointers
Traverse the original list again and assign:
- `copy.next = map.get(original.next)`
- `copy.random = map.get(original.random)`

### Step 3: Return cloned head
The copied list head is `map.get(head)`.

## Pseudocode
```text
COPY_RANDOM_LIST(head):
    if head is null:
        return null

    map = empty hashmap
    curr = head

    // Step 1: store copies of all nodes
    while curr is not null:
        map[curr] = new Node(curr.val)
        curr = curr.next

    // Step 2: assign next and random pointers
    curr = head
    while curr is not null:
        map[curr].next = map.get(curr.next)
        map[curr].random = map.get(curr.random)
        curr = curr.next

    return map[head]
```

## Java Code
```java
import java.util.HashMap;

class Node {
    int val;
    Node next;
    Node random;

    Node(int val) {
        this.val = val;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        HashMap<Node, Node> map = new HashMap<>();
        Node curr = head;

        // Step 1: Create copies of all nodes
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        // Step 2: Connect next and random pointers
        curr = head;
        while (curr != null) {
            Node copy = map.get(curr);
            copy.next = map.get(curr.next);
            copy.random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }
}
```

## Pointer Mutation Phases
- **Before:** `A -> B -> C`
- **After Step 1:** map contains `A'`, `B'`, `C'`
- **After Step 2:** copied nodes have correct `next` and `random` links
- **After Step 3:** return the cloned head `A'`

## Complexity
- **Time:** O(n)
- **Space:** O(n) for the HashMap

## Note
This solution is simpler and easier to understand, but it does **not** satisfy the O(1) auxiliary space requirement. If the problem specifically asks for O(1) space, the interleaving method should be used instead [web:104][web:108][web:119].
# Queue Using Two Stacks

## Question
Implement a FIFO Queue using exactly two LIFO Stacks. Also prove that dequeue has O(1) amortized time complexity.

## Algorithm
Use two stacks: `S_in` and `S_out`.

### enqueue(x)
- Push `x` into `S_in`.

### dequeue()
- If `S_out` is not empty, pop from `S_out`.
- Otherwise, move all elements from `S_in` to `S_out`, then pop from `S_out`.

## Pseudocode
```text
BEGIN

CREATE stack S_in
CREATE stack S_out

FUNCTION ENQUEUE(x)
    PUSH x INTO S_in
END FUNCTION

FUNCTION DEQUEUE()
    IF S_out IS EMPTY THEN
        WHILE S_in IS NOT EMPTY DO
            PUSH POP(S_in) INTO S_out
        END WHILE
    END IF

    IF S_out IS EMPTY THEN
        RETURN "Queue is empty"
    END IF

    RETURN POP(S_out)
END FUNCTION

END
```

## Proof of Amortized O(1)
- Each element is pushed once into `S_in`.
- Each element is moved from `S_in` to `S_out` at most once.
- Each element is popped once from `S_out`.

So every element is processed only a constant number of times. Therefore, although one dequeue may take O(n) in the worst case, the amortized time complexity of dequeue is O(1).

## Time Complexity
- Enqueue: O(1)
- Dequeue: O(1) amortized, O(n) worst case
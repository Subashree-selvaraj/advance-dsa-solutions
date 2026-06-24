# Question 1.A — The In-Place Shuffle  
## Part i

### Question

**Design a fully deterministic, optimal algorithm to shuffle a linear array of n elements completely at random such that every possible permutation from the sample space is generated with strictly equal probability. Your response must ensure the solution runs in O(n) time complexity while maintaining a rigorous O(1) auxiliary spatial footprint.**

---

## Solution Overview

The correct solution for this problem is the **Fisher–Yates Shuffle**.

It is the standard in-place shuffling algorithm used to generate a **uniform random permutation** of an array. This means every possible arrangement of the array appears with exactly equal probability.

It satisfies all required conditions:

- **Uniform randomness**
- **O(n)** time complexity
- **O(1)** auxiliary space
- **In-place execution**

---

## idea

The algorithm works by processing the array from **right to left**.

At each step:

- choose one random index from the unshuffled portion
- swap that element into the current position
- fix that position permanently
- continue leftward

This ensures that each position is finalized exactly once.



## Key takeaway

### One-line summary

```text
Backward traversal + shrinking random range = uniform in-place shuffle
```

---

### Fisher–Yates EXAMPLE Notes

<img width="717" height="1280" alt="WhatsApp Image 2026-06-22 at 11 54 26 PM" src="https://github.com/user-attachments/assets/b578d562-7bf6-4ca6-bb5c-73e8b9f9c7a8" />



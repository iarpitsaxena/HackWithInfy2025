## Approach and Intuition for Fractional Knapsack

### Intuition

The Fractional Knapsack problem is a classic example of a greedy algorithm. Unlike the 0/1 Knapsack, where you must take an item entirely or leave it, here you can take any fraction of an item. The main idea is to maximize the total value in the knapsack by always choosing the item (or fraction of it) that offers the highest value per unit weight. This ensures that every unit of capacity is used in the most valuable way possible.

### Approach

1. **Calculate Value-to-Weight Ratio:**  
    For each item, compute its value-to-weight ratio:  
    \[
    \text{ratio}_i = \frac{\text{value}_i}{\text{weight}_i}
    \]
    This ratio represents how much value you get for each unit of weight.

2. **Sort Items by Ratio:**  
    Arrange all items in descending order based on their value-to-weight ratio. Items with a higher ratio should be considered first, as they provide more value per unit weight.

3. **Iterate and Select Items Greedily:**  
    - Initialize `totalValue = 0` and set `remainingCapacity` to the knapsack's total capacity.
    - For each item in the sorted list:
      - **If the item fits completely:**  
         - Add its full value to `totalValue`.
         - Subtract its weight from `remainingCapacity`.
      - **If only part of the item fits:**  
         - Take the fraction that fits:  
            \[
            \text{fraction} = \frac{\text{remainingCapacity}}{\text{weight}_i}
            \]
         - Add the proportional value to `totalValue`:  
            \[
            \text{totalValue} += \text{value}_i \times \text{fraction}
            \]
         - The knapsack is now full; break out of the loop.

4. **Stop When Full:**  
    The process continues until the knapsack is full or all items have been considered.

### Why the Greedy Approach is Optimal

The greedy strategy works for the fractional knapsack because taking the item with the highest value-to-weight ratio at each step always leads to the optimal solution. Since you can take fractions, you never "waste" capacity on a less valuable item when a more valuable one is available. This property does not hold for the 0/1 knapsack, which is why that problem requires dynamic programming.

### Example

Suppose you have a knapsack with capacity 50 and three items:

| Item | Value | Weight | Value/Weight |
|------|-------|--------|--------------|
| 1    | 60    | 10     | 6.0          |
| 2    | 100   | 20     | 5.0          |
| 3    | 120   | 30     | 4.0          |

- Sort items by value/weight: Item 1, Item 2, Item 3.
- Take all of Item 1 (weight 10), remaining capacity = 40.
- Take all of Item 2 (weight 20), remaining capacity = 20.
- Take 20/30 = 2/3 of Item 3, value added = 120 × (2/3) = 80.
- **Total value = 60 + 100 + 80 = 240.**


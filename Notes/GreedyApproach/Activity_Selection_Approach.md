# Activity Selection Problem

The Activity Selection Problem is a classic example of a greedy algorithm. The objective is to select the maximum number of non-overlapping activities from a given list, where each activity has a start and end time.

## Problem Statement

Given `n` activities with their start and finish times, select the maximum number of activities that can be performed by a single person, assuming that a person can only work on a single activity at a time.

Each activity `i` has:
- Start time: `start[i]`
- End time: `end[i]`

## Intuition

The main intuition behind the greedy approach is to always pick the activity that finishes earliest. By doing so, we leave the maximum possible time for the remaining activities, increasing the chances of fitting more activities into the schedule.

### Why pick the earliest finishing activity?

- If we pick an activity that ends later, it may overlap with more activities, reducing the total number we can select.
- By picking the earliest finishing activity, we ensure that we have the largest window for subsequent activities.

## Detailed Steps

1. **Sort Activities:**  
    Sort all activities in increasing order of their end times.

2. **Select the First Activity:**  
    Always select the first activity in the sorted list (the one that ends earliest).

3. **Iterate Through Remaining Activities:**  
    For each subsequent activity, check if its start time is greater than or equal to the end time of the last selected activity.
    - If yes, select this activity.
    - If not, skip it.

4. **Repeat:**  
    Continue this process until all activities have been considered.

### Example

Suppose we have the following activities:

| Activity | Start | End |
|----------|-------|-----|
|    1     |   1   |  4  |
|    2     |   3   |  5  |
|    3     |   0   |  6  |
|    4     |   5   |  7  |
|    5     |   8   |  9  |
|    6     |   5   |  9  |

**Step 1:** Sort by end time:

| Activity | Start | End |
|----------|-------|-----|
|    1     |   1   |  4  |
|    2     |   3   |  5  |
|    3     |   0   |  6  |
|    4     |   5   |  7  |
|    5     |   8   |  9  |
|    6     |   5   |  9  |

**Step 2:** Select Activity 1 (ends at 4).

**Step 3:**  
- Activity 2 starts at 3 (< 4), skip.
- Activity 3 starts at 0 (< 4), skip.
- Activity 4 starts at 5 (>= 4), select.
- Activity 5 starts at 8 (>= 7), select.
- Activity 6 starts at 5 (< 9), skip.

**Selected Activities:** 1, 4, 5

## Why Greedy Works

The greedy choice of picking the earliest finishing activity always leads to an optimal solution because:
- It leaves the most room for future activities.
- Any other choice would either reduce the number of activities or not improve the solution.

## Time Complexity

- Sorting activities: O(n log n)
- Selecting activities: O(n)

**Total:** O(n log n)

## Summary

The Activity Selection Problem demonstrates how a simple greedy strategy—always picking the next activity that finishes earliest—can yield an optimal solution for scheduling non-overlapping activities.
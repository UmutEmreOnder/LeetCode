Details: 

Runtime: 0 ms, faster than 100.00% of Java online submissions for Find First and Last Position of Element in Sorted Array.

Memory Usage: 45.3 MB, less than 95.58% of Java online submissions for Find First and Last Position of Element in Sorted Array.

My algorithm first finds which index the searched target is in with BS algorithm (if it can't find it, it returns -1 as a result because the index defines it as -1 at the beginning). Then, because there are elements with the same value in the array, using try-catch (could also be done by checking whether the indexes exceed the range of the array) I increment and decrement indexRight and indexLeft as long as they have the same value of target. Finally, I put them in an array and return them.
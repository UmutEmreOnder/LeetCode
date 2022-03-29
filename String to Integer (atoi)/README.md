Details:

Runtime: 2 ms, faster than 85.91% of Java online submissions for String to Integer (atoi).

Memory Usage: 42.8 MB, less than 61.63% of Java online submissions for String to Integer (atoi).

This problem contains too many control elements.

Things to check in order:

1- If there is a space at the beginning of the string, it will be skipped

2- If there is a letter or other character at the beginning of the string, before any number or -/+ sign appears, 0 will be returned.

The first while loop in the solution checks this part. Inside the while, there is a special control for the '.' because there can be a letter, number, period, or space character in the input.

When we skip the beginning of the string, there are situations that we need to check again in the numerical part.

1- If there is no digit in the index and a sign or numeric character came before, the current result should be returned. (E.g. +42- -> should return 42, 45a01 -> should return 45)

The first if inside the 2nd loop provides control of this state.

2- If the result exceeds the integer limits, then the bounds must be returned.

To achieve this, I defined the number data as long type, and thus I could easily check whether it exceeded the integer limit.
# Quicksort Implementation with Hoare Partitioning #

Overview

This repository contains a Java implementation of the Quicksort algorithm using the Hoare partitioning scheme. It features random pivot selection to enhance performance, particularly on sorted or nearly sorted arrays.

-> Written by Ankita Patra

Features
- Random Pivot Selection: Mitigates worst-case performance on sorted inputs.
- Hoare Partitioning: Efficiently handles equal values to avoid performance degradation.
- Flexible Input Handling: Accepts command-line arguments for sorting specific subranges.
- Vertical Output: Prints sorted numbers in a vertical format for improved readability.

Usage

Input

The program reads integers from standard input (stdin).

Command-Line Arguments
- Zero Arguments: Sorts the entire array.
- Two Arguments: Sorts the array in the range `[a, b)` (1-based indexing).

Example Commands ;

- To sort all numbers:
  ```bash
  java quicksort < input.txt
  java quicksort 0 2[range] < input.txt 

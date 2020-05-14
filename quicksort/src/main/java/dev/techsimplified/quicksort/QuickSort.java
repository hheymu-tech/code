package dev.techsimplified.quicksort;

/**
 * Implementation of Quick Sort algorithm.
 *
 * @author Harshad Shrishrimal
 */
public final class QuickSort {
  // private Constructor.
  private QuickSort() {}

  /**
   * Sort the given array. Elements in array should implement {@code Comparable}
   *
   * @param input array to sort
   * @param <T> generic object that implements/extends {@code Comparable}
   */
  public static <T extends Comparable<T>> void sort(T[] input) {
    // sort the entire array
    sort(input, 0, input.length - 1);
  }

  /**
   * Recursively, Quick sort the sub-array
   *
   * @param input array to sort
   * @param lo indicates the start index
   * @param hi indicates the end index
   * @param <T> generic object that implements/extends {@code Comparable}
   */
  private static <T extends Comparable<T>> void sort(T[] input, int lo, int hi) {
    // exit condition for recursion
    if (lo >= hi) return;

    // partition the array
    int indexOfPartitionedElement = PartitionUtilities.partition(input, lo, hi);

    // recursively sort the left and right side, excluding partitioned element
    // the partitioned element is in its correct sorted position
    sort(input, lo, indexOfPartitionedElement - 1);
    sort(input, indexOfPartitionedElement + 1, hi);
  }
}

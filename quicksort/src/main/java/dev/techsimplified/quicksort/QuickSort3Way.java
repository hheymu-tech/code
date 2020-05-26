package dev.techsimplified.quicksort;

/**
 * Implementation of Quick Sort 3 Way algorithm.
 *
 * @author Harshad Shrishrimal
 */
public final class QuickSort3Way {
  // private Constructor.
  private QuickSort3Way() {}

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
   * Recursively, Quick sort 3 Way the sub-array
   *
   * @param input array to sort
   * @param lo indicates the start index
   * @param hi indicates the end index
   * @param <T> generic object that implements/extends {@code Comparable}
   */
  private static <T extends Comparable<T>> void sort(T[] input, int lo, int hi) {
    // exit condition for recursion
    if (lo >= hi) return;

    // partition the array, and get the indices where the partitioned elements are equal
    int[] indices = PartitionUtilities.partition3Way(input, lo, hi);

    // recursively sort the left and right side, excluding partitioned elements
    sort(input, lo, indices[0] - 1);
    sort(input, indices[1] + 1, hi);
  }
}

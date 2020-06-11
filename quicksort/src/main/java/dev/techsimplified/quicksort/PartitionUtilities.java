package dev.techsimplified.quicksort;

/**
 * Utility class, exposing various partition methods to partition a collection
 *
 * @author Harshad Shrishrimal
 */
final class PartitionUtilities {

  // private Constructor.
  private PartitionUtilities() {}

  /**
   * Pick the first entry (between lo .. hi) and re-shuffle the array such that, elements less than
   * the chosen one are to the left, greater are to the right. In other words, following should hold
   * input[lo ... rightIndex - 1] < input[rightIndex] <= input[rightIndex .. hi]
   *
   * @param input array to partition
   * @param lo start index
   * @param hi end index
   * @param <T> generic object that implements/extends {@code Comparable}
   * @return index of the chosen element (rightIndex).
   */
  public static <T extends Comparable<T>> int partition(T[] input, int lo, int hi) {
    int leftIndex = lo;
    int rightIndex = hi + 1;

    while (true) {

      // keep incrementing leftIndex till we find a position
      // where the element is greater than input[lo] / pivot.
      // break if we are reaching the end of array
      while (less(input, ++leftIndex, lo)) if (leftIndex == hi) break;

      // keep decrementing rightIndex till we find a position
      // where the element is less than input[lo] / pivot.
      // break if we are reaching the start of array
      while (less(input, lo, --rightIndex)) if (rightIndex == lo) break;

      // exit condition for the outer loop
      // break, if the index cross
      if (leftIndex >= rightIndex) break;

      // for the given pivot elements at position leftIndex & rightIndex
      // are out of order; swap them
      exchange(input, leftIndex, rightIndex);
    }

    // put the partitioning element in it's correct position
    exchange(input, lo, rightIndex);

    // return the index of the partitioned element.
    return rightIndex;
  }

  /**
   * partition the collection such that input[lo ... lt-1] < input[lt .. gt] < input[gt+1 .. hi].
   * all elements between lt and gt are equal
   *
   * @param input array to partition
   * @param lo start index
   * @param hi end index
   * @param <T> generic object that implements/extends {@code Comparable}
   * @return indices (lt & gt) where all elements are equal
   */
  public static <T extends Comparable<T>> int[] partition3Way(T[] input, int lo, int hi) {
    int lt = lo;
    int gt = hi;

    T v = input[lo]; // the element that we will be comparing against
    for (int i = lo; i <= gt; ) {
      int cmp = input[i].compareTo(v);
      // elements less than v (pivot), needs to be moved to the left
      // move it to the left and increment the indices
      if (cmp < 0) exchange(input, i++, lt++);
      // elements greater than v (pivot), needs to be moved to the right
      // move it to the right and decrement the indices
      if (cmp > 0) exchange(input, i, gt--);
      // comparing element is equal to pivot.
      // do nothing
      if (cmp == 0) i++;
    }
    return new int[] {lt, gt}; // all entries between lt .. gt are equal.
  }

  public static <T extends Comparable<T>> int[] partition3WayDualPivot(T[] input, int lo, int hi) {

    // exchange if left pivot is less than right pivot
    if (less(input[hi], input[lo])) exchange(input, lo, hi);

    int lt = lo + 1;
    int gt = hi - 1;

    for (int i = lo + 1; i <= gt; ) {
      if (less(input[i], input[lo])) exchange(input, i++, lt++); // input less than left pivt
      else if (less(input[hi], input[i])) exchange(input, i, gt--); // input greater then right pivt
      else i++;
    }

    // put the partitioning pivots in place
    exchange(input, lo, --lt);
    exchange(input, hi, ++gt);

    return new int[] {lt, gt};
  }

  /**
   * Swap 2 elements
   *
   * @param input array in which elements will be swapped
   * @param idx1 index of first element
   * @param idx2 index of second element
   * @param <T> any generic object
   */
  private static <T> void exchange(T[] input, int idx1, int idx2) {
    T temp = input[idx1];
    input[idx1] = input[idx2];
    input[idx2] = temp;
  }

  /**
   * Compare 2 elements
   *
   * @param input array of which 2 will be compared
   * @param idx1 index of first element
   * @param idx2 index of second element
   * @param <T> generic object that implements/extends {@code Comparable}
   * @return {@code true} if element represented by {@code idx1} is less than {@code idx2}; {@code
   *     false} otherwise.
   */
  private static <T extends Comparable<T>> boolean less(T[] input, int idx1, int idx2) {
    return less(input[idx1], input[idx2]);
  }

  /**
   * Compare 2 elements
   *
   * @param t1 first element
   * @param t2 second element
   * @param <T> eneric object that implements/extends {@code Comparable}
   * @return {@code true} if element {@code t1} is less than {@code t2}; {@code * false} otherwise.
   */
  private static <T extends Comparable<T>> boolean less(T t1, T t2) {
    return t1.compareTo(t2) < 0;
  }
}

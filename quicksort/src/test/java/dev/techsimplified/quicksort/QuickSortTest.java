package dev.techsimplified.quicksort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ArgumentsSources;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
class QuickSortTest {

  /**
   * Test implementation of Quick Sort Algorithm
   *
   * @param arguments test data
   */
  @DisplayName("QuickSort Test")
  @ParameterizedTest(name = "Running permutation {index}")
  @ArgumentsSources({
    @ArgumentsSource(SortDataDuplicateProvider.class),
    @ArgumentsSource(SortDataOddProvider.class),
    @ArgumentsSource(SortDataEvenProvider.class)
  })
  void quickSortTest(TestData arguments) {
    Integer[] input = arguments.getInput();
    QuickSort.sort(input);
    Assertions.assertArrayEquals(arguments.getExpectedOutput(), input);
  }
}

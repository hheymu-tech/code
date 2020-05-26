package dev.techsimplified.quicksort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ArgumentsSources;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
class QuickSort3WayTest {

  /**
   * Test implementation of Quick Sort Algorithm
   *
   * @param arguments test data
   */
  @DisplayName("QuickSort3Way Test")
  @ParameterizedTest(name = "Running permutation {index}")
  @ArgumentsSources({
    @ArgumentsSource(SortDataDuplicateProvider.class),
    @ArgumentsSource(SortDataOddProvider.class),
    @ArgumentsSource(SortDataEvenProvider.class)
  })
  void quickSort3WayTest(TestData arguments) {
    Integer[] input = arguments.getInput();
    QuickSort3Way.sort(input);
    Assertions.assertArrayEquals(arguments.getExpectedOutput(), input);
  }
}

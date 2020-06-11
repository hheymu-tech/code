package dev.techsimplified.quicksort;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ArgumentsSources;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
class QuickSortDualPartitionTest {

  /**
   * Test implementation of QuickSort with dual partition Algorithm
   *
   * @param arguments test data
   */
  @DisplayName("QuickSort with dual partitioning")
  @ParameterizedTest(name = "Running permutation {index}")
  @ArgumentsSources({
    @ArgumentsSource(SortDataDuplicateProvider.class),
    @ArgumentsSource(SortDataOddProvider.class),
    @ArgumentsSource(SortDataEvenProvider.class)
  })
  void quickSortDualPartitionTest(TestData arguments) {
    Integer[] input = arguments.getInput();
    QuickSortDualPartition.sort(input);
    Assertions.assertArrayEquals(arguments.getExpectedOutput(), input);
  }
}

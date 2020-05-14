package dev.techsimplified.quicksort;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
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
    @ArgumentsSource(SortInputEvenProvider.class),
    @ArgumentsSource(SortInputOddProvider.class),
    @ArgumentsSource(SortInputDuplicateProvider.class)
  })
  void quickSortTest(TestData arguments) {
    Integer[] input = arguments.getInput();
    QuickSort.sort(input);
    Assertions.assertArrayEquals(arguments.getExpectedOutput(), input);
  }

  private static class SortInputDuplicateProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
      return TestDataCreator.getData_SortTest_DuplicateElements().stream().map(Arguments::of);
    }
  }

  private static class SortInputEvenProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
      return TestDataCreator.getData_SortTest_EvenElements().stream().map(Arguments::of);
    }
  }

  private static class SortInputOddProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
      return TestDataCreator.getData_SortTest_OddElements().stream().map(Arguments::of);
    }
  }
}

package dev.techsimplified.quicksort;

import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

final class SortDataDuplicateProvider implements ArgumentsProvider {

  @Override
  public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
    return TestDataCreator.getData_SortTest_DuplicateElements().stream().map(Arguments::of);
  }
}

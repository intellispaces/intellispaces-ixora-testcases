package tech.intellispaces.ixora.testcases.helloworld;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.LoggerFactory;

import tech.intellispaces.reflections.Jaquarius;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for Hello World samples.
 */
public class HelloWorldTest {

  @BeforeAll
  public static void disableLogging() {
    var lc = (LoggerContext) LoggerFactory.getILoggerFactory();
    lc.getLogger("ROOT").setLevel(Level.ERROR);
  }

  @ParameterizedTest
  @ValueSource(classes = {
      HelloWorldTestcase1.class,
      HelloWorldTestcase2.class,
      HelloWorldTestcase3.class,
      HelloWorldTestcase4.class,
      HelloWorldTestcase5.class,
      HelloWorldTestcase6.class
  })
  void testOutput(Class<?> moduleClass) {
    // Given
    var os = new ByteArrayOutputStream();
    var ps = new PrintStream(os, true, StandardCharsets.UTF_8);
    System.setOut(ps);

    // When
    Jaquarius.createStartAndStopModule(moduleClass);

    // Then
    String output = os.toString(StandardCharsets.UTF_8);
    assertThat(output).isEqualTo("Hello, world!" + System.lineSeparator());
  }
}

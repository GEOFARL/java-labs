package task;

import org.junit.Test;

import point.Point;
import point.PointGenerator;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.concurrent.atomic.AtomicLong;

public class MonteCarloTaskTest {

  @Test
  public void testRunWithMockedPoints() {
    AtomicLong counter = new AtomicLong(0);

    PointGenerator mockGenerator = mock(PointGenerator.class);
    when(mockGenerator.generatePoint())
        .thenReturn(new Point(0.5, 0.5))
        .thenReturn(new Point(1.5, 1.5));

    MonteCarloTask task = new MonteCarloTask(counter, 2, mockGenerator);
    task.run();

    assertEquals(1, counter.get());
  }
}
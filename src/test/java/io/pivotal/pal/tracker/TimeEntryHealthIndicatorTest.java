package io.pivotal.pal.tracker;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;

import static org.junit.Assert.*;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TimeEntryHealthIndicatorTest {
    TimeEntryRepository timeEntryRepo;
    TimeEntryHealthIndicator timeEntryHealthIndicator;

    @Before
    public void setup() {
        timeEntryRepo = mock(TimeEntryRepository.class, RETURNS_DEEP_STUBS);
        timeEntryHealthIndicator = new TimeEntryHealthIndicator(timeEntryRepo);
    }
    @Test
    public void healthUp() {
        when(timeEntryRepo.list().size()).thenReturn(4);
        Health health = timeEntryHealthIndicator.health();
        assertEquals(health.getStatus(), Status.UP);
    }

    @Test
    public void healthDown() {
        when(timeEntryRepo.list().size()).thenReturn(5);
        Health health = timeEntryHealthIndicator.health();
        assertEquals(health.getStatus(), Status.DOWN);
    }
}
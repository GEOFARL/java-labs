package geofarl;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import person.Person;

public class PersonEqualsTest {
  @Test
  public void testEqualsAndHashCode() {
    EqualsVerifier.forClass(Person.class)
        .usingGetClass()
        .suppress(Warning.NONFINAL_FIELDS)
        .verify();
  }
}

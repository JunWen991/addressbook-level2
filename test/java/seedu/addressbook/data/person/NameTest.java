package seedu.addressbook.data.person;

import static org.junit.Assert.*;

import org.junit.*;

import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {
    
    private Name name;

    @Before
    public void setup() throws IllegalValueException {
        name = new Name("John K Smith");
    }
    
    @Test
    public void testIsSimilar_returnTrue() throws IllegalValueException {
        assertFalse(name.isSimilar(null));
    }
    
}
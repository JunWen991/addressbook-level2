package seedu.addressbook.common;

import org.junit.Test;

import seedu.addressbook.data.person.*;

import static org.junit.Assert.*;

import java.util.*;

public class UtilsTest {
    
    @Test
    public void testIsAnyNull() {
        assertTrue(Utils.isAnyNull(Name.EXAMPLE,Phone.EXAMPLE,
                Email.EXAMPLE,Address.EXAMPLE,null));
    
        assertFalse(Utils.isAnyNull(Name.EXAMPLE,Phone.EXAMPLE,
                Email.EXAMPLE,Address.EXAMPLE));
    }
    
    final List<String> list1 = Arrays.asList("key1", "key2", "key3");
    final List<String> list2 = Arrays.asList("key1", "key2", "key2");
        
    @Test
    public void testElementsAreUnique() {
        
        assertTrue(Utils.elementsAreUnique(list1));
        
        assertFalse(Utils.elementsAreUnique(list2));
        
    }    
}

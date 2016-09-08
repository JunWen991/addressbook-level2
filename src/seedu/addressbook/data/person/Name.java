package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

import java.util.Arrays;
import java.util.List;

/**
 * Represents a Person's name in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidName(String)}
 */
public class Name {

    public static final String EXAMPLE = "John Doe";

    public final String fullName;

    /**
     * Validates given name.
     */
    public Name(String name) {
        this.fullName = name.trim();
    }

    /**
     * Retrieves a listing of every word in the name, in order.
     */
    public List<String> getWordsInName() {
        return Arrays.asList(fullName.split(",|\\s+"));
    }

    @Override
    public String toString() {
        return fullName;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Name // instanceof handles nulls
                && this.fullName.equals(((Name) other).fullName)); // state check
    }

    @Override
    public int hashCode() {
        return fullName.hashCode();
    }
    
    public boolean isSimilar(Name other) {
        if (isNull(other)) {
            return false;
        }
        else {
            return isSimilarAllCases(other) || isSimilarAllOrders(other);
        }
    }
    
    private boolean isNull(Name other) {
        if (other == null) {
            return true;
        }
        else {
            return false;
        }
    }
    
    private boolean isSimilarAllCases(Name other) {
        return fullName.equalsIgnoreCase(other.toString());
    }
    
    private boolean isSimilarAllOrders(Name other) {
        List<String> splitOther = other.getWordsInName();
        for (String splittedOther : splitOther) {
            if (fullName.contains(splittedOther)) {
                return true;
            }
        }
        return false;
    }
}

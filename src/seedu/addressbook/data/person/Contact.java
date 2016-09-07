package seedu.addressbook.data.person;

/**
 * A parental class that contains information of child classes: Address, Email, Phone.
 */
public class Contact {

	public String value;
    protected boolean isPrivate;

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
    
    @Override
    public String toString() {
        return value;
    }
}

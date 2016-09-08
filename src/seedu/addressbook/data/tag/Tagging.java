package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

/**
 * Adding or Removing tags to a person in the address book.
 */

public class Tagging {

    private Person person;
    private Tag tag;
    private char tagSymbol;
    
    public Tagging(Person person, Tag tag, char tagSymbol) {
        this.person = person;
        this.tag = tag;
        this.tagSymbol = tagSymbol;
    }
    
    @Override
    public String toString() {
        return (tagSymbol + " " + person.getName() + " [" + tag.tagName + "]");
    }
}

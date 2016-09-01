package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "a/123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in a/BLOCK, STREET, UNIT, POSTAL_CODE format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    public final String value;
    private boolean isPrivate;
    public Block block;
    public Street street;
    public Unit unit;
    public PortalCode portalCode;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        if (!isValidAddress(address)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        
        int i = 0;
        for(String subAddress : address.split(",")){
        	if(i == 0){
        		block = new Block(subAddress);
        	}
        	else if(i == 1){
        		street = new Street(subAddress);
        	}
        	else if(i == 2){
        		unit = new Unit(subAddress);
        	}
        	else if(i == 3){
        		portalCode = new PortalCode(subAddress);
        	}
            i++;
        }
        
        this.value = block.getBlock() + ", " + street.getStreet() + ", " + unit.getUnit() + ", " + portalCode.getPortalCode();
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}

class Block{
	
	private String block;
	
	public Block(String block){
		this.block = block.trim();
	}
	
	public String getBlock(){
		return this.block;
	}
}

class Street{
	
	private String street;
	
	public Street(String street){
		this.street = street.trim();
	}
	
	public String getStreet(){
		return this.street;
	}
}

class Unit{
	
	private String unit;
	
	public Unit(String unit){
		this.unit = unit.trim();
	}
	
	public String getUnit(){
		return this.unit;
	}
}

class PortalCode{
	
	private String portalCode;
	
	public PortalCode(String portalCode){
		this.portalCode = portalCode.trim();
	}
	
	public String getPortalCode(){
		return this.portalCode;
	}
}
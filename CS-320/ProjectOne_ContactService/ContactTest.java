package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Test
    void canCreateValidContact() {
        Contact contact = new Contact("1234567890",
                "John", "Doe", "0123456789", "123 Main Street");
        assertEquals("1234567890", contact.getContactID());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("0123456789", contact.getPhone());
        assertEquals("123 Main Street", contact.getAddress());
    }

    @Test
    void throwsWhenContactIdTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345678901",
                        "John", "Doe", "0123456789", "123 Main Street"));
    }

    @Test
    void throwsWhenFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1234567890",
                        "FirstnameTooLong", "Doe", "0123456789", "123 Main Street"));
    }

    @Test
    void throwsWhenLastNameTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1234567890",
                        "John", "LastnameTooLong", "0123456789", "123 Main Street"));
    }

    @Test
    void throwsWhenAddressTooLong() {
        String longAddress = "This address is definitely longer than thirty characters";
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1234567890",
                        "John", "Doe", "0123456789", longAddress));
    }

    @Test
    void throwsWhenPhoneNotTenDigits() {
        // too short
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1234567890",
                        "John", "Doe", "12345", "123 Main Street"));
    }

    @Test
    void throwsWhenPhoneTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1234567890",
                        "John", "Doe", "01234567890", "123 Main Street"));
    }

    @Test
    void throwsWhenPhoneHasLetters() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1234567890",
                        "John", "Doe", "012345678a", "123 Main Street"));
    }

    @Test
    void throwsWhenContactIdIsNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(null, "John", "Doe", "0123456789", "123 Main Street"));
    }

    @Test
    void throwsWhenFirstNameIsNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1234567890", null, "Doe", "0123456789", "123 Main Street"));
    }

    @Test
    void throwsWhenLastNameIsNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1234567890", "John", null, "0123456789", "123 Main Street"));
    }

    @Test
    void throwsWhenPhoneIsNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1234567890", "John", "Doe", null, "123 Main Street"));
    }

    @Test
    void throwsWhenAddressIsNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("1234567890", "John", "Doe", "0123456789", null));
    }

    @Test
    void contactIdCannotBeChanged() {
        Contact contact = new Contact("1234567890",
                "John", "Doe", "0123456789", "123 Main Street");
        contact.setFirstName("Jane");
        contact.setLastName("Smith");
        contact.setPhone("1234567890");
        contact.setAddress("456 Oak Street");
        // id should still be the same
        assertEquals("1234567890", contact.getContactID());
    }

    @Test
    void setFirstNameWorksAndRejectsBadValues() {
        Contact contact = new Contact("1234567890",
                "John", "Doe", "0123456789", "123 Main Street");

        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());

        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("FirstnameTooLong"));
    }

    @Test
    void setLastNameWorksAndRejectsBadValues() {
        Contact contact = new Contact("1234567890",
                "John", "Doe", "0123456789", "123 Main Street");

        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());

        assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName("LastnameTooLong"));
    }

    @Test
    void setPhoneWorksAndRejectsBadValues() {
        Contact contact = new Contact("1234567890",
                "John", "Doe", "0123456789", "123 Main Street");

        contact.setPhone("1234567890");
        assertEquals("1234567890", contact.getPhone());

        assertThrows(IllegalArgumentException.class, () -> contact.setPhone(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("12345"));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("01234567890"));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("abcdefghij"));
    }

    @Test
    void setAddressWorksAndRejectsBadValues() {
        Contact contact = new Contact("1234567890",
                "John", "Doe", "0123456789", "123 Main Street");

        contact.setAddress("456 Oak Street");
        assertEquals("456 Oak Street", contact.getAddress());

        assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
        String longAddress = "This address is definitely longer than thirty characters";
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress(longAddress));
    }
}

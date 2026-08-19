package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    // so I don't keep retyping the constructor
    private Contact createSampleContact(String id) {
        return new Contact(id, "John", "Doe", "0123456789", "123 Main Street");
    }

    @Test
    void canAddSingleContact() {
        ContactService service = new ContactService();
        Contact contact = createSampleContact("1");

        service.addContact(contact);

        assertEquals(contact, service.getContact("1"));
    }

    @Test
    void canAddMultipleContacts() {
        ContactService service = new ContactService();
        Contact c1 = createSampleContact("1");
        Contact c2 = createSampleContact("2");

        service.addContact(c1);
        service.addContact(c2);

        assertEquals(c1, service.getContact("1"));
        assertEquals(c2, service.getContact("2"));
    }

    @Test
    void throwsWhenAddingDuplicateId() {
        ContactService service = new ContactService();
        Contact c1 = createSampleContact("1");
        Contact c2 = createSampleContact("1");

        service.addContact(c1);
        assertThrows(IllegalArgumentException.class, () -> service.addContact(c2));
    }

    @Test
    void canAddAndGetContact() {
        ContactService service = new ContactService();
        Contact contact = createSampleContact("1");

        service.addContact(contact);
        Contact fromService = service.getContact("1");

        assertNotNull(fromService);
        assertEquals("1", fromService.getContactID());
    }

    @Test
    void canUpdateContact() {
        ContactService service = new ContactService();
        Contact contact = createSampleContact("1");
        service.addContact(contact);

        service.updateContact("1", "Jane", "Smith", "1234567890", "456 Oak Street");

        Contact updated = service.getContact("1");
        assertEquals("Jane", updated.getFirstName());
        assertEquals("Smith", updated.getLastName());
        assertEquals("1234567890", updated.getPhone());
        assertEquals("456 Oak Street", updated.getAddress());
    }

    @Test
    void canDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = createSampleContact("1");
        service.addContact(contact);

        service.deleteContact("1");

        assertNull(service.getContact("1"));
    }

    @Test
    void throwsWhenAddingNullContact() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> service.addContact(null));
    }

    @Test
    void throwsWhenDeletingContactThatDoesNotExist() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("999"));
    }

    @Test
    void throwsWhenUpdatingContactThatDoesNotExist() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () ->
                service.updateContact("999", "Jane", "Smith", "1234567890", "456 Oak Street"));
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("999", "Jane"));
        assertThrows(IllegalArgumentException.class, () -> service.updateLastName("999", "Smith"));
        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("999", "1234567890"));
        assertThrows(IllegalArgumentException.class, () -> service.updateAddress("999", "456 Oak Street"));
    }

    @Test
    void throwsWhenUpdateValueIsInvalid() {
        ContactService service = new ContactService();
        service.addContact(createSampleContact("1"));

        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("1", null));
        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("1", "123"));
        assertThrows(IllegalArgumentException.class, () ->
                service.updateAddress("1", "This address is definitely longer than thirty characters"));
    }

    @Test
    void canUpdateFirstNameOnly() {
        ContactService service = new ContactService();
        service.addContact(createSampleContact("1"));

        service.updateFirstName("1", "Jane");

        Contact updated = service.getContact("1");
        assertEquals("Jane", updated.getFirstName());
        // other fields should still be the same
        assertEquals("Doe", updated.getLastName());
        assertEquals("0123456789", updated.getPhone());
        assertEquals("123 Main Street", updated.getAddress());
    }

    @Test
    void canUpdateLastNameOnly() {
        ContactService service = new ContactService();
        service.addContact(createSampleContact("1"));

        service.updateLastName("1", "Smith");

        assertEquals("Smith", service.getContact("1").getLastName());
        assertEquals("John", service.getContact("1").getFirstName());
    }

    @Test
    void canUpdatePhoneOnly() {
        ContactService service = new ContactService();
        service.addContact(createSampleContact("1"));

        service.updatePhone("1", "1234567890");

        assertEquals("1234567890", service.getContact("1").getPhone());
    }

    @Test
    void canUpdateAddressOnly() {
        ContactService service = new ContactService();
        service.addContact(createSampleContact("1"));

        service.updateAddress("1", "456 Oak Street");

        assertEquals("456 Oak Street", service.getContact("1").getAddress());
    }
}

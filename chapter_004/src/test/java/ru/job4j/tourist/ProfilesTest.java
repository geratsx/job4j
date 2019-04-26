package ru.job4j.tourist;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {

    Profiles profiles = new Profiles();
    Address address1 = new Address("Moscow", "Leninskaya", 5, 110);
    Address address2 = new Address("Moscow", "Leninskaya", 5, 110);
    Address address3 = new Address("Kazan", "Lermontovskaya", 123, 56);
    List<Profile> clientProfiles = Arrays.asList(new Profile(address1), new Profile(address2), new Profile(address3));

    @Test
    public void whenHaveListOfProfilesThenGetListOfAdresses() {
        List<Address> expect = Arrays.asList(address1, address2, address3);
        List<Address> result = profiles.collect(clientProfiles);
        assertThat(expect, is(result));
    }

    @Test
    public void whenHaveListOfProfilesThenGetSortedByCityListOfAdresses() {
        List<Address> expect = Arrays.asList(address3, address2);
        List<Address> result = profiles.getSortedByCityUniqueAddressList(clientProfiles);
        assertThat(expect, is(result));
    }
}

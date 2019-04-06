package ru.job4j.tourist;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {

    @Test
    public void whenHaveListOfProfilesThenGetListOfAdresses() {
        Profiles profiles = new Profiles();
        Address address1 = new Address("Moscow", "Leninskaya", 110, 14);
        Address address2 = new Address("Moscow", "Leninskaya", 310, 145);
        Address address3 = new Address("Piter", "Leninskaya", 11, 94);
        List<Profile> clientProfiles = Arrays.asList(new Profile(address1), new Profile(address2), new Profile(address3));
        List<Address> expect = Arrays.asList(address1, address2, address3);
        List<Address> result = profiles.collect(clientProfiles);
        assertThat(expect, is(result));
    }
}

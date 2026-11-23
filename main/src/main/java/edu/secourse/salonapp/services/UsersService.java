package edu.secourse.salonapp.services;

import edu.secourse.salonapp.models.Customer;
import edu.secourse.salonapp.models.Stylist;
import edu.secourse.salonapp.models.User;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class UsersService {
    private final Map<Integer, User> users = new LinkedHashMap<>();
    private int nextId = 1;

    public Customer createCustomer(String name, String email, String phone){
        validate(name, email);
        Customer c = new Customer(nextId++, name, email, phone);
        users.put(c.getId(), c);
        return c;
    }

    public Stylist createStylist(String name, String email, String phone, String specialty){
        validate(name, email);
        Stylist s = new Stylist(nextId++, name, email, phone, specialty);
        users.put(s.getId(), s);
        return s;
    }

    public User getUser(int id){
        User u = users.get(id);
        if(u == null) throw new IllegalArgumentException("No users with id:" + id);
        return u;
    }

    public List<User> getAllUsers(){
        return new ArrayList<>(users.values());
    }

    //update users Details. any null values are left alone.
    public User updateUser(int id, String name, String email, String phone){
        User u = getUser(id);
        if (!isBlank(name)) u.getName();
        if (!isBlank(email)) u.getEmail();
        if (!isBlank(phone)) u.getPhone();
        return u;
    }

    //remove a user
    public void removeUser(int id){
        if (users.remove(id) == null) throw new IllegalArgumentException("No users with Id:" + id);
    }

    private void validate(String name, String email){
        if(isBlank(name)) throw new IllegalArgumentException("Name is require");
        if(isBlank(email)) throw new IllegalArgumentException("Email is required");
    }

    private static boolean isBlank(String s) {
        return s == null || s.isBlank();
    }
}

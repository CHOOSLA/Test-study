package org.example;

import java.util.HashMap;
import java.util.Map;

public class MySQLUserRepository implements UserRepository{
    private final Map<Integer, String> userTable = new HashMap<>();
    private int nextId = 1;

    @Override
    public String findUserId(int id) {
        return userTable.getOrDefault(id, null);
    }

    @Override
    public void saveUser(String user) {
        userTable
                .put(nextId++, user);
    }

    @Override
    public int countUsers() {
        return userTable.size();
    }
}

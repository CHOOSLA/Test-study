package org.example;

public interface UserRepository {
    String findUserId(int id);
    void saveUser(String user);
    int countUsers();
}

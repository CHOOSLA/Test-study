package org.example;

import java.beans.JavaBean;

public interface UserRepository {
    String findUserId(int id);
    void saveUser(String user);
    int countUsers();
}

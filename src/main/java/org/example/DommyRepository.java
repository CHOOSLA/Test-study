package org.example;

public class DommyRepository implements UserRepository{
    @Override
    public String findUserId(int id) {
//        return "";
        throw new UnsupportedOperationException("Dummy: Not implemented");
    }

    @Override
    public void saveUser(String user) {
        throw new UnsupportedOperationException("Dummy: Not implemented");
    }

    @Override
    public int countUsers() {
        throw new UnsupportedOperationException("Dummy: Not implemented");
    }
}

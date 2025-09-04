package org.example;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public String getUserId(int id){
        return userRepository.findUserId(id);
    }

    public void saveUser(String user){
        userRepository.saveUser(user);
    }

    public int getUserCount(){
        return userRepository.countUsers();
    }
    public String notUseUserRepository(){
        return "NotUseUserRepository";
    }

    public String returnUserServiceGreeting(){
        return "저는 UserService에요. UserRepository를 호출하지 않아요. 더미 테스트용입니다.";
    }
}

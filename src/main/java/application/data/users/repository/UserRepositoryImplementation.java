package application.data.users.repository;

import application.data.users.User;
import application.data.users.security.UserCredentialsCryptTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImplementation {
    private final UserRepository userRepository;

    @Autowired
    UserRepositoryImplementation(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public User saveUser(User user)
    {
        user.setPassword(UserCredentialsCryptTool.encodeCredentials(user.getPassword()));
        return userRepository.save(user);
    }

    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }

    public User getUserByMail(String mail) {
        return userRepository.getUserByMail(mail);
    }

    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }

    public void deleteUser(User user) {
        userRepository.deleteUser(user.getMail());
    }
}
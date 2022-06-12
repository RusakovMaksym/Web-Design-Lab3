package application.data.users.service;

import application.data.users.User;
import application.data.users.repository.UserRepositoryImplementation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {
    private final UserRepositoryImplementation userRepository;

    @Autowired
    UserService(UserRepositoryImplementation userRepositoryImplementation) {
        this.userRepository = userRepositoryImplementation;
    }

    public User saveUser(User user) {
        return userRepository.saveUser(user);
    }

    public List<User> getAllUsers()
    {
        return userRepository.getAllUsers();
    }

    public User getUserByMail(String mail) {
        return userRepository.getUserByMail(mail);
    }

    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }

    public void deleteUser(User user) {
        userRepository.deleteUser(user);
    }

    public User checkAuthentication() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            return getUserByMail(authentication.getName());
        }
        return null;
    }
}
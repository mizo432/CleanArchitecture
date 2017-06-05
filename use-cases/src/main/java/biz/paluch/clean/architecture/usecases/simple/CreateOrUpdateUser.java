package biz.paluch.clean.architecture.usecases.simple;

import biz.paluch.clean.architecture.applicationmodel.User;
import biz.paluch.clean.architecture.contracts.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author <a href="mailto:mpaluch@paluch.biz">Mark Paluch</a>
 * @since 02.08.13 07:34
 */
@Component
public class CreateOrUpdateUser {

    private UserRepository userRepository;

    @Autowired
    public CreateOrUpdateUser(UserRepository anUserRepository){
        userRepository = anUserRepository;

    }

    public void createOrUpdateUser(String userName) {

        User user = userRepository.find(userName);
        if (user == null) {
            user = new User(userName);
            userRepository.store(user);
        }
    }

}

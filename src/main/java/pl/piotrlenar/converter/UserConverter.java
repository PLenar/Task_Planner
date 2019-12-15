package pl.piotrlenar.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.piotrlenar.entities.User;
import pl.piotrlenar.repositories.UserRepository;

public class UserConverter implements Converter<String, User> {

    @Autowired
    UserRepository userRepository;

    @Override
    public User convert(String s) {
        return userRepository.findOne(Long.parseLong(s));
    }
}
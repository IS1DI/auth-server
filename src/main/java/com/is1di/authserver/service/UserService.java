package com.is1di.authserver.service;

import com.is1di.authserver.entity.users.User;
import com.is1di.authserver.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService implements UserDetailsService {
    private final UserMapper userMapper;
    private final MongoOperations mongoOperations;
    private final TypeService typeService;
    private final PasswordEncoder encoder;

    public void createUser(User user) {
        mongoOperations.save(user);
    }

    /*    public void updateUser(ObjectId id, User user) {
     *//*mongoOperations.update(User.class)
                .matching(Query.query(Criteria.where("_id").is(id)))
                .apply(new Update().set(""))*//* //TODO
    }

    public void deleteUser(String username) {
        Optional.ofNullable(mongoOperations.update(User.class)
                .matching(Query.query(Criteria.where("username").is(username)))
                .apply(new Update().set("enabled",false))
                .findAndModifyValue())
                .orElseThrow(() -> new UsernameNotFoundException("user with username %s not found".formatted(username)));
    }

    public void changePassword(String oldPassword, String newPassword) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = findUserByUserName(username);
        if(encoder.matches(user.getPassword(),oldPassword)) {
            user.setPassword(encoder.encode(newPassword));
        } else throw new CredentialsException("password is incorrect");
    }

    public boolean userExists(String username) {
        return mongoOperations.exists(Query.query(Criteria.where("username").is(username)),User.class);
    }*/

    public User findUserByUserName(String username) throws UsernameNotFoundException {
        User user = Optional.ofNullable(mongoOperations.findOne(Query.query(Criteria.where("username").is(username)), User.class))
                .orElseThrow(() -> new UsernameNotFoundException("user with username %s not found".formatted(username)));
        return user;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userMapper.toDetails(findUserByUserName(username));
    }
}

package com.is1di.authserver.mapper;

import com.is1di.authserver.entity.extend.Employee;
import com.is1di.authserver.entity.extend.Supervisor;
import com.is1di.authserver.entity.users.Enrollee;
import com.is1di.authserver.entity.users.Student;
import com.is1di.authserver.entity.users.User;
import com.is1di.authserver.model.JwtUser;
import com.is1di.authserver.model.UserDetailsImpl;
import org.bson.types.ObjectId;
import org.mapstruct.Mapper;
import org.springframework.security.core.GrantedAuthority;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    public ObjectId toId(String id) {
        return new ObjectId(id);
    }

    public String toStr(ObjectId id) {
        if (id != null)
            return id.toString();
        return null;
    }

    public UserDetailsImpl toDetails(User user) {
        return new UserDetailsImpl(user);
    }

    public String map(GrantedAuthority au) {
        return au.getAuthority();
    }

    public JwtUser toJwt(User user) {
        JwtUser.Builder builder = JwtUser.builder()
                .sub(user.getId().toString())
                .fullName(user.getFullName())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .authorities(collectStr(user.getRole()))
                .imgUrl(user.getImgUrl());
        if (user instanceof Student st) {
            if (st.getStudGroup() != null)
                builder.group(st.getStudGroup());
            if (st.getDirection() != null)
                builder.direction(st.getDirection());
        }
        if (user instanceof Supervisor s) {
            if (s.getDepartment() != null)
                builder.department(s.getDepartment());
            if (s.getPosition()!= null)
                builder.position(s.getPosition());
        }
        if (user instanceof Employee e) {
            if (e.getDepartment() != null)
                builder.department(e.getDepartment());
            if(e.getPosition() != null)
                builder.position(e.getPosition());
        }
        if (user instanceof Enrollee e) {
            if(e.getDirection() != null)
                builder.direction(e.getDirection());
        }
        return builder.build();
    }

    private HashSet<String> collectStr(String... strings) {
        return Arrays.stream(strings).collect(Collectors.toCollection(HashSet::new));
    }
}

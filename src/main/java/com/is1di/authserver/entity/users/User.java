package com.is1di.authserver.entity.users;

import com.is1di.authserver.utils.EntityClassName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "users")
@TypeAlias(EntityClassName.USER)
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private ObjectId id;

    private String username;
    private String password;

    private String fullName;

    private String email;

    private String phoneNumber;
    private String imgUrl;

    private boolean enabled;

    private String role;
}

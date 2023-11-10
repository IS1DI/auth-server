package com.is1di.authserver.entity.users;

import com.is1di.authserver.utils.EntityClassName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Data
@Document(collection = "users")
@TypeAlias(EntityClassName.ENROLLEE)
public class Enrollee extends User {
    private String direction;
}

package com.is1di.authserver.entity.users;

import com.is1di.authserver.utils.EntityClassName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Student and curator
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Document(collection = "users")
@TypeAlias(EntityClassName.STUDENT)
@NoArgsConstructor
public class Student extends User {
    private String direction;
    private String studGroup;
}

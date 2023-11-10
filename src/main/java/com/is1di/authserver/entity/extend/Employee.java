package com.is1di.authserver.entity.extend;

import com.is1di.authserver.entity.users.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Document(collection = "users")
@TypeAlias("employee")
@NoArgsConstructor
public class Employee extends User {
    private String department;
    private Set<WorkExperience> workExperiences;
    private String position;
}

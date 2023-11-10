package com.is1di.authserver.entity.extend;

import com.is1di.authserver.entity.users.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Data
@Document(collection = "users")
@TypeAlias("supervisor")
@NoArgsConstructor
public class Supervisor extends User {
    private String department;
    private String position;
}

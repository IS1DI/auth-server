package com.is1di.authserver.entity.direction;

import com.is1di.authserver.entity.users.Student;
import com.is1di.authserver.utils.EntityClassName;
import lombok.Data;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.HashSet;
import java.util.Set;


@Data
@TypeAlias("group")
public class Group {
    private String studGroup;
    @DocumentReference(lookup = "{'studGroup' : ?#{#self.studGroup}, '_class' : ?#{#self.studentType}}")
    private Set<Student> students = new HashSet<>();
    private String studentType = EntityClassName.STUDENT;
}


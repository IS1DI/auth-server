package com.is1di.authserver.entity.extend;

import com.is1di.authserver.utils.EntityClassName;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.Set;

@Document(collection = "department")
@Data
@TypeAlias(EntityClassName.DEPARTMENT)
public class Department {
    private ObjectId id;
    private String title;
    @DocumentReference(lookup = "{'department' : ?#{#self.title} , '_class' : ?#{#self.supervisorType} }")
    private Supervisor supervisor;
    @DocumentReference(lookup = "{'department' : ?#{#self.title} , '_class' : ?#{#self.employeeType}}")
    private Set<Employee> employees;
    private String supervisorType = EntityClassName.SUPERVISOR;
    private String employeeType = EntityClassName.EMPLOYEE;
}

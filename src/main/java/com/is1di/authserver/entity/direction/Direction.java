package com.is1di.authserver.entity.direction;

import com.is1di.authserver.entity.users.Curator;
import com.is1di.authserver.entity.users.Enrollee;
import com.is1di.authserver.utils.EntityClassName;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Document(collection = "direction")
@TypeAlias(EntityClassName.DIRECTION)
public class Direction {
    @Id
    private ObjectId id;
    @Indexed
    private String title;
    private LocalDateTime startAt;
    private LocalDateTime endsAt;
    private Set<Group> groups = new HashSet<>();
    @DocumentReference(lookup = "{'direction':?#{#self.title} , '_class' : ?#{#self.curatorType}}")
    private Curator curator;
    @DocumentReference(lookup = "{'direction':?#{#self.title} , '_class' : ?#{#self.enrolleeType}}")
    private Set<Enrollee> enrollees;
    private Set<Discipline> disciplines = new HashSet<>();
    private String curatorType = EntityClassName.CURATOR;
    private String enrolleeType = EntityClassName.ENROLLEE;

    //TODO files
}

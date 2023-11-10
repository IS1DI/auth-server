package com.is1di.authserver.entity.direction;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.TypeAlias;

@Data
@TypeAlias("discipline")
public class Discipline {
    private String title;
    private String description;
    private ObjectId teacherId;
    private String courseId;
    private String academicSubjectId;
    //TODO files
}

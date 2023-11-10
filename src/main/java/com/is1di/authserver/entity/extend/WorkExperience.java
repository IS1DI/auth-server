package com.is1di.authserver.entity.extend;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WorkExperience {
    public LocalDateTime startDate;
    public LocalDateTime endDate;
    public String departmentName;
}

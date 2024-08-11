package com.pranav.ProjectManagement.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String fullName;

    private String email;

    private String password;

    private int projectSize;

    /*
    @JsonIgnore will tell jackson to ignore the Json serialisation and deserialization,
    meaning this field will not be included in the JSON representation of the entity.

    @OneToMany mapping means a user can have multiple Issue objects assigned to him. And the Issue entity will have
    ManyToOne relationship

    Cascade means if some persistence operation is applied to User entity then it will also be applied to the Issue entity
    present in the assignedIssues list. CascadeType.All means all the operations are linked.

    mappedBy = "assignee" means the assignee column of Issue entity will hold the relationship with the User entity
     */
    @JsonIgnore
    @OneToMany (mappedBy = "assignee", cascade = CascadeType.ALL)
    private List<Issue> assignedIssues = new ArrayList<>();
}

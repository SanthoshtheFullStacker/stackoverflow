package com.example.backend.models.others;

import com.example.backend.models.Enumnerations.Reactionenum;
import com.example.backend.models.universal.Timestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table
public class Reactions extends Timestamp {
    private long id;
    private Reactionenum type;

}

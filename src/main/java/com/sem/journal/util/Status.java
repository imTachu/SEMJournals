package com.sem.journal.util;

import com.sem.journal.util.enums.EStatusType;

public class Status {
    private EStatusType type;
    private String description;

    public Status(EStatusType type, String description) {
        this.type = type;
        this.description = description;
    }

    public EStatusType getType() {
        return type;
    }

    public void setType(EStatusType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

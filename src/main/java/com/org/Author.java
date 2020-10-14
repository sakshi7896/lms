package com.org;

import java.util.Date;
import java.util.Objects;

public class Author {

    private int id; //should be autoincremented
    private String fName;
    private String lName;
    private Date lastUpdatedTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public Date getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(Date lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id == author.id &&
                lastUpdatedTime == author.lastUpdatedTime &&
                fName.equals(author.fName) &&
                lName.equals(author.lName);
    }

    public Author(){

    }


}

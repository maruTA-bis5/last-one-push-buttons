package net.bis5.tools.lastone.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Item {
    @Id
    @GeneratedValue
    private long id;
    @Version
    private long version;
    private String name;
    private String description;

    public void setId(long id) {
        this.id = id;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public long getVersion() {
        return version;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
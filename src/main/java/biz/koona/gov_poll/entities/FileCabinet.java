package biz.koona.gov_poll.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "file_cabinet")
public class FileCabinet {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", nullable = false, length = 45)
    private String id;

    @Column(name = "file_name", length = 45)
    private String fileName;

    @Column(name = "file_type", length = 45)
    private String fileType;

    @Column(name = "data")
    @Lob
    private byte[] data;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @OneToMany(mappedBy = "picture")
    private Set<Personality> personalities = new LinkedHashSet<>();

    @OneToMany(mappedBy = "picture")
    private Set<User> users = new LinkedHashSet<>();

    public FileCabinet() {
    }

    public FileCabinet(String fileName, String fileType, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Personality> getPersonalities() {
        return personalities;
    }

    public void setPersonalities(Set<Personality> personalities) {
        this.personalities = personalities;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
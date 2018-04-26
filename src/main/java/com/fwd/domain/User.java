package com.fwd.domain;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Transient;

@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = {"username"}))
public class User implements Serializable {

    @Column(name = "id_user", table = "user", unique = false, updatable = true, insertable = true, nullable = false, length = 255, scale = 0, precision = 0)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUser;

    @Column(name = "password", table = "user", unique = false, updatable = true, insertable = true, nullable = false, length = 65535, scale = 0, precision = 0)
    @Lob
    @Basic
    private String password;

    @Column(name = "role", table = "user", unique = false, updatable = true, insertable = true, nullable = false, length = 65535, scale = 0, precision = 0)
    @Lob
    @Basic
    private String role;

    @Column(name = "avatar_path", table = "user", unique = false, updatable = true, insertable = true, nullable = false, length = 65535, scale = 0, precision = 0)
    @Lob
    @Basic
    private String avatarPath;

    @Column(name = "username", table = "user", unique = false, updatable = true, insertable = true, nullable = false, length = 50, scale = 0, precision = 0)
    @Basic
    private String username;

    @Column(name = "fullname", table = "user", unique = false, updatable = true, insertable = true, nullable = false, length = 100, scale = 0, precision = 0)
    @Basic
    private String fullname;

    @Column(name = "active", table = "user", unique = false, updatable = true, insertable = true, nullable = false, length = 255, scale = 0, precision = 0)
    @Basic
    private boolean active;
    
    @Transient
    private boolean avatarChanged = false;

    public User() {

    }

    public Long getIdUser() {
        return this.idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAvatarPath() {
        return this.avatarPath;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public boolean isAvatarChanged() {
        return avatarChanged;
    }

    public void setAvatarChanged(boolean avatarChanged) {
        this.avatarChanged = avatarChanged;
    }

}

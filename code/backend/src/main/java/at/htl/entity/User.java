package at.htl.entity;

import javax.persistence.*;
import java.util.Objects;

@NamedQueries({
        @NamedQuery(
                name = "User.findAll",
                query = "select u from User u"
        ),
        @NamedQuery(
                name = "User.findByUserName",
                query = "select u from User u where u.username like :NAME"
        ),
        @NamedQuery(
                name = "User.findByEmail",
                query = "select u from User u where u.email like :EMAIL"
        )
})
@Entity
@Table(name = "PLATFORM_USER")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="USER_ID")
    private long id;

    @Column(name = "USER_NAME")
    private String username;

    @Column(name = "USER_DESC")
    private String desc;

    @Column(name = "USER_GENDER")
    private String gender;

    @Column(name = "USER_PICTURE_PATH")
    private String profilePicturePath;
    //TODO: date

    @Column(name = "USER_EMAIL")
    private String email;

    @Column(name = "USER_PASSWORD")
    private String passwordHashValue;

    @Column(name = "USER_DELETED")
    private int isDeleted;

    public User(long id, String username, String desc, String gender, String profilePicturePath, String email, String passwordHashValue, int isDeleted) {
        this.id = id;
        this.username = username;
        this.desc = desc;
        this.gender = gender;
        this.profilePicturePath = profilePicturePath;
        this.email = email;
        this.passwordHashValue = passwordHashValue;
        this.isDeleted = isDeleted;
    }

    public User() {

    }

    //<editor-fold desc="Getter and Setter">
    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getDesc() {
        return desc;
    }

    public String getGender() {
        return gender;
    }

    public String getProfilePicturePath() {
        return profilePicturePath;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHashValue() {
        return passwordHashValue;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setProfilePicturePath(String profilePicturePath) {
        this.profilePicturePath = profilePicturePath;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPasswordHashValue(String passwordHashValue) {
        this.passwordHashValue = passwordHashValue;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }
    //</editor-fold>

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", desc='" + desc + '\'' +
                ", gender='" + gender + '\'' +
                ", profilePicturePath='" + profilePicturePath + '\'' +
                ", email='" + email + '\'' +
                ", isDeleted=" + isDeleted +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

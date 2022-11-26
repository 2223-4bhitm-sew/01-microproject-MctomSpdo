package at.htl.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties
public class UserDTO {
    private long id;

    private String username;

    private String desc;

    private String gender;

    private String profilePicturePath;

    public UserDTO() {
    }

    public UserDTO(long id, String username, String desc, String gender, String profilePicturePath) {
        this.id = id;
        this.username = username;
        this.desc = desc;
        this.gender = gender;
        this.profilePicturePath = profilePicturePath;
    }

    //region Getter and Setter
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProfilePicturePath() {
        return profilePicturePath;
    }

    public void setProfilePicturePath(String profilePicturePath) {
        this.profilePicturePath = profilePicturePath;
    }
    //endregion

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", desc='" + desc + '\'' +
                ", profilePicturePath='" + profilePicturePath + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

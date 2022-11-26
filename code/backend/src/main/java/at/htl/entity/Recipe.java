package at.htl.entity;

import javax.persistence.*;
import java.util.Date;

@NamedQueries({
        @NamedQuery(
                name = "Recipe.findAll",
                query =  "select r from Recipe r inner join User"
        )
})
@Entity
@Table(name = "RECIPE")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RECIPE_ID")
    private long id;

    @Column(name = "RECIPE_IMGPATH")
    private String imagePath;

    @Column(name = "RECIPE_TITLE")
    private String title;

    @Column(name = "RECIPE_DESC")
    private String desc;

    @Column(name = "RECIPE_CREATED")
    @Temporal(TemporalType.DATE)
    private Date created;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User from;

    @Column(name = "RECIPE_DELETED")
    private boolean isDeleted;

    public Recipe(long id, String imagePath, String title, String desc, Date created, User from, boolean isDeleted) {
        this.id = id;
        this.imagePath = imagePath;
        this.title = title;
        this.desc = desc;
        this.created = created;
        this.from = from;
        this.isDeleted = isDeleted;
    }

    public Recipe() {
    }

    //region Getter and Setter
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public User getFrom() {
        return from;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
    //endregion
}

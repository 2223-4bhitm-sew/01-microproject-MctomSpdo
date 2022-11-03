package at.htl.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "RECIPE")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RECIPE_ID")
    private long id;

    @Column(name = "RECIPE_TITLE")
    private String title;

    @Column(name = "RECIPE_DESC")
    private String desc;

    @Column(name = "RECIPE_IMGPATH")
    private String imgPath;

    @Column(name = "RECIPE_POSTEDON")
    private LocalDate postedOn;

    /*@Column(name = "RECIPE_AUTHOR")
    private User author; */

    @Column(name = "RECIPE_VISIBILITY")
    private boolean visibility;
}

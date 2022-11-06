package at.htl.entity;

import javax.persistence.*;

@Entity
@Table(name = "RECIPE_INGREDIENTS")
public class RecipeIngredients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "RECIPE")
    @PrimaryKeyJoinColumn
    @OneToOne
    private Recipe recipe;


    @Column(name = "INGREDIENT")
    @PrimaryKeyJoinColumn
    @OneToOne
    private Ingredient ingredient;
}

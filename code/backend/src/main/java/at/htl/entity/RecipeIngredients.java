package at.htl.entity;

import javax.persistence.*;

@Entity
@Table(name = "RECIPE_INGREDIENTS")
public class RecipeIngredients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @PrimaryKeyJoinColumn
    @OneToOne
    private Recipe recipe;

    @PrimaryKeyJoinColumn
    @OneToOne
    private Ingredient ingredient;
}

package at.htl.entity;

import javax.persistence.*;

@Entity
@Table(name = "INGREDIENT")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INGREDIENT_ID")
    private long id;

    @Column(name = "INGREDIENT_NAME")
    private String name;
}

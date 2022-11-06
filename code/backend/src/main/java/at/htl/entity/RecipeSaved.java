package at.htl.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "RECIPESAVED")
public class RecipeSaved {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @PrimaryKeyJoinColumn
    @OneToOne
    private User owner;

    @PrimaryKeyJoinColumn
    @OneToOne
    private Recipe saves;

    public RecipeSaved() {
    }

    public RecipeSaved(long id, User owner, Recipe saves) {
        this.id = id;
        this.owner = owner;
        this.saves = saves;
    }

    //<editor-fold desc="Getter and Setter">
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Recipe getSaves() {
        return saves;
    }

    public void setSaves(Recipe saves) {
        this.saves = saves;
    }
    //</editor-fold>

    @Override
    public String toString() {
        return "RecipeSaved{" +
                "id=" + id +
                ", owner=" + owner +
                ", saves=" + saves +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeSaved that = (RecipeSaved) o;
        return id == that.id && Objects.equals(owner, that.owner) && Objects.equals(saves, that.saves);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, owner, saves);
    }
}

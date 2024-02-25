package net.escoz.dndapi.Model.Monsters;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.escoz.dndapi.Model.Alignment;
import net.escoz.dndapi.Model.Feature;
import net.escoz.dndapi.Model.Language;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "monsters")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Monster {

    /* Características generales */
    @Id
    private String name;
    private Integer armorClass;
    private Integer hitPoints;
    private Double challenge;
    private String image;
    private String manual;

    @Column(length = 3000)
    private String description;

    /* Velocidades */
    private Integer speed;
    private Integer speedFlaying;
    private Integer speedSwimming;
    private Integer speedClimbing;
    private Integer speedBurrowing;

    /* Atributos */
    private Integer strength;
    private Integer dexterity;
    private Integer constitution;
    private Integer intelligence;
    private Integer wisdom;
    private Integer charisma;

    /* Relaciones muchos a uno */

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "size_id", nullable = false)
    private Size size;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "type_id", nullable = false)
    private Type type;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "alignment_id", nullable = false)
    private Alignment alignment;

    /* Relaciones muchos a muchos */

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "monsters_mn_skills",
            joinColumns = @JoinColumn(name = "monster_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private Set<Skill> skills;

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "monsters_mn_languages",
            joinColumns = @JoinColumn(name = "monster_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id")
    )
    private Set<Language> languages;

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "monsters_nm_senses",
            joinColumns = @JoinColumn(name = "monster_id"),
            inverseJoinColumns = @JoinColumn(name = "sense_id")
    )
    private Set<Sense> senses;

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "monsters_mn_actions",
            joinColumns = @JoinColumn(name = "monster_id"),
            inverseJoinColumns = @JoinColumn(name = "action_id")
    )
    private Set<Action> actions;


    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "monsters_mn_features",
            joinColumns = @JoinColumn(name = "monster_id"),
            inverseJoinColumns = @JoinColumn(name = "features_id")
    )
    private Set<Feature> features;

    /**
     * Ñapa para evitar los nulos del ModelMapper
     */
    public void initLists() {
        skills = new HashSet<>();
        languages = new HashSet<>();
        senses = new HashSet<>();
    }

}
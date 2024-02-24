package net.escoz.dndapi.DTOs.Reponses;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import net.escoz.dndapi.Model.Feature;
import net.escoz.dndapi.Model.Monsters.Action;

import java.util.List;
import java.util.Set;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MonsterDTO {

    private String name;
    private String alignment;
    private Integer armorClass;
    private Integer hitPoints;
    private Double challenge;
    private String description;
    private Integer speed;
    private Integer speedFlaying;
    private Integer speedSwimming;
    private Integer speedClimbing;
    private Integer speedBurrowing;
    private Integer strength;
    private Integer dexterity;
    private Integer constitution;
    private Integer intelligence;
    private Integer wisdom;
    private Integer charisma;
    private String size;
    private String type;
    private List<String> skills;
    private List<String> languages;
    private List<String> senses;

    private Set<Action> actions;
    private Set<Feature> features;
}

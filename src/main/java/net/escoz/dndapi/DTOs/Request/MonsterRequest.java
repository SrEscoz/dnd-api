package net.escoz.dndapi.DTOs.Request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import net.escoz.dndapi.DTOs.MonsterSizeDTO;
import net.escoz.dndapi.DTOs.MonsterTypeDTO;
import net.escoz.dndapi.Model.Feature;
import net.escoz.dndapi.Model.Monsters.Action;

import java.util.List;
import java.util.Set;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MonsterRequest {

    /* Características generales */
    private String name;
    private String alignment;
    private Integer armorClass;
    private Integer hitPoints;
    private Double challenge;
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
    private String size;
    private String type;

    /* Relaciones muchos a muchos */
    private List<String> skills;
    private List<String> languages;
    private List<String> senses;
    private Set<Action> actions;
    private Set<Feature> features;
}

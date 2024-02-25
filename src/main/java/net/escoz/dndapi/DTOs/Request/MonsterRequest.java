package net.escoz.dndapi.DTOs.Request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import net.escoz.dndapi.DTOs.MonsterActionDTO;
import net.escoz.dndapi.DTOs.MonsterFeatureDTO;
import net.escoz.dndapi.DTOs.MonsterLegendaryActionDTO;

import java.util.List;

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
    private String image;
    private String manual;

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
    private List<MonsterActionDTO> actions;
    private List<MonsterLegendaryActionDTO> legendaryActions;
    private List<MonsterFeatureDTO> features;
}

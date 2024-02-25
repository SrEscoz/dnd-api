package net.escoz.dndapi.DTOs.Reponses;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import net.escoz.dndapi.DTOs.MonsterActionDTO;
import net.escoz.dndapi.DTOs.MonsterFeatureDTO;

import java.util.List;

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
    private List<MonsterActionDTO> actions;
    private List<MonsterFeatureDTO> features;
    private String imagen;
    private String manual;
}

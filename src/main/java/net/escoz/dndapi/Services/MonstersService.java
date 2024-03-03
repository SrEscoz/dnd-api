package net.escoz.dndapi.Services;

import net.escoz.dndapi.DTOs.MonsterSizeDTO;
import net.escoz.dndapi.DTOs.MonsterTypeDTO;
import net.escoz.dndapi.DTOs.Reponses.BasicResponse;
import net.escoz.dndapi.DTOs.Reponses.MonsterDTO;
import net.escoz.dndapi.DTOs.Request.MonsterRequest;
import net.escoz.dndapi.Exceptions.BadRequestException;
import net.escoz.dndapi.Model.Alignment;
import net.escoz.dndapi.Model.Feature;
import net.escoz.dndapi.Model.Language;
import net.escoz.dndapi.Model.Monsters.*;
import net.escoz.dndapi.Repositories.AlignmentsRepository;
import net.escoz.dndapi.Repositories.MonsterRepository;
import net.escoz.dndapi.Repositories.MonsterSizeRepository;
import net.escoz.dndapi.Repositories.MonsterTypeRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonstersService implements IMonstersService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MonstersService.class);

    @Autowired
    private MonsterRepository monsterRepository;

    @Autowired
    private MonsterSizeRepository sizeRepository;

    @Autowired
    private MonsterTypeRepository typesRepository;

    @Autowired
    private AlignmentsRepository alignmentsRepository;

    @Autowired
    private ModelMapper modelMapper;

    /* ==============================
            Métodos de obtención
     ============================== */

    @Override
    public List<MonsterDTO> getMonsters() {
        List<Monster> monsters = monsterRepository.findAll();
        List<MonsterDTO> response = monsters
                .stream()
                .map(monster -> {
                    MonsterDTO monsterDTO = modelMapper.map(monster, MonsterDTO.class);
                    monsterDTO.setSize(monster.getSize().getName());
                    monsterDTO.setType(monster.getType().getName());
                    monsterDTO.setAlignment(monster.getAlignment().getName());
                    monsterDTO.setSkills(monster.getSkills().stream().map(Skill::getName).toList());
                    monsterDTO.setLanguages(monster.getLanguages().stream().map(Language::getName).toList());
                    monsterDTO.setSenses(monster.getSenses().stream().map(Sense::getName).toList());
                    monsterDTO.setSavingThrows(monster.getSavingThrows().stream().map(SavingThrow::getName).toList());

                    return monsterDTO;
                })
                .toList();

        LOGGER.info("[MonstersService] getMonsters Obtenidos -> {}", monsters.size());
        return response;
    }

    @Override
    public List<MonsterTypeDTO> getMonsterTypes() {
        List<Type> types = typesRepository.findAll();
        List<MonsterTypeDTO> response = types
                .stream()
                .map(type -> modelMapper.map(type, MonsterTypeDTO.class))
                .toList();

        LOGGER.info("[MonstersService] getMonsterTypes Obtenidos -> {}", types.size());
        return response;
    }

    @Override
    public List<MonsterSizeDTO> getMonsterSizes() {
        List<Size> sizes = sizeRepository.findAll();
        List<MonsterSizeDTO> response = sizes
                .stream()
                .map(type -> modelMapper.map(type, MonsterSizeDTO.class))
                .toList();

        LOGGER.info("[MonstersService] getMonsterSizes Obtenidos -> {}", sizes.size());
        return response;
    }

    /* ==============================
            Métodos de creación
     ============================== */

    @Override
    public BasicResponse createMonster(MonsterRequest monsterRequest) {

        /* Comprobamos que sea válido */
        if (monsterRepository.existsById(monsterRequest.getName())) {
            LOGGER.error("[MonstersService] createMonster Monstruo duplicado -> {}", monsterRequest.getName());
            throw new BadRequestException("El monstruo ya existe");
        }

        if (!sizeRepository.existsById(monsterRequest.getSize())) {
            LOGGER.error("[MonstersService] createMonster No existe el tamaño -> {}", monsterRequest.getSize());
            throw new BadRequestException("No existe el tamaño");
        }

        if (!typesRepository.existsById(monsterRequest.getType())) {
            LOGGER.error("[MonstersService] createMonster No existe el tipo -> {}", monsterRequest.getType());
            throw new BadRequestException("No existe el tipo");
        }

        if (!alignmentsRepository.existsById(monsterRequest.getAlignment())) {
            LOGGER.error("[MonstersService] createMonster No existe el alineamiento -> {}", monsterRequest.getAlignment());
            throw new BadRequestException("No existe el alineamiento");
        }

        /* Mapeamos la entrada a una entidad de la bb dd */
        Monster monster = modelMapper.map(monsterRequest, Monster.class);
        monster.initLists();

        monster.setSize(new Size(monsterRequest.getSize()));
        monster.setType(new Type(monsterRequest.getType()));
        monster.setAlignment(new Alignment(monsterRequest.getAlignment()));

        /* Solo creamos a mano las habilidades, idiomas y sentidos el resto lo mapea bien */
        monsterRequest.getSkills()
                .forEach(s -> monster.getSkills().add(new Skill(s)));

        monsterRequest.getLanguages()
                .forEach(l -> monster.getLanguages().add(new Language(l)));

        monsterRequest.getSenses()
                .forEach(s -> monster.getSenses().add(new Sense(s)));

        monsterRequest.getSavingThrows()
                .forEach(s -> monster.getSavingThrows().add(new SavingThrow(s)));

        monsterRepository.save(monster);
        LOGGER.info("[MonstersService] createMonster Monstruo creado -> {}", monster.getName());

        return new BasicResponse(HttpStatus.CREATED, "Monstruo creado");
    }

    @Override
    public BasicResponse createMonsterType(MonsterTypeDTO monsterTypeDTO) {
        /* Mapeamos la entrada a una entidad de la bb dd */
        Type type = modelMapper.map(monsterTypeDTO, Type.class);

        /* Comprobamos que sea válido */
        if (typesRepository.existsById(type.getName())) {
            LOGGER.error("[MonstersService] createMonsterType Tipo duplicado -> {}", type.getName());
            throw new BadRequestException("El tipo ya existe");
        }

        typesRepository.save(type);
        LOGGER.info("[MonstersService] createMonsterType Tipo creado -> {}", type.getName());

        return new BasicResponse(HttpStatus.CREATED, "Tipo de monstruo creado");
    }

    @Override
    public BasicResponse createMonsterSize(MonsterSizeDTO monsterSizeDTO) {
        /* Mapeamos la entrada a una entidad de la bb dd */
        Size size = modelMapper.map(monsterSizeDTO, Size.class);

        /* Comprobamos que sea válido */
        if (sizeRepository.existsById(size.getName())) {
            LOGGER.error("[MonstersService] createMonsterSize Tamaño duplicado -> {}", size.getName());
            throw new BadRequestException("El tamaño ya existe");
        }

        sizeRepository.save(size);
        LOGGER.info("[MonstersService] createMonsterSize Tamaño creado -> {}", size.getName());

        return new BasicResponse(HttpStatus.CREATED, "Tamaño de monstruo creado");
    }

    @Override
    public BasicResponse updateMonsterLists(MonsterDTO monsterRequest) {

        Monster monster = monsterRepository.findByNameIgnoreCase(monsterRequest.getName());

        /* Comprobamos que sea válido */
        if (monster == null) {
            LOGGER.error("[MonstersService] updateMonsterLists No existe el monstruo -> {}", monsterRequest.getName());
            throw new BadRequestException("El monstruo no existe");
        }

        /* Añadimos sus nuevas características */
        monsterRequest.getSkills()
                .forEach(s -> monster.getSkills().add(new Skill(s)));

        monsterRequest.getLanguages()
                .forEach(l -> monster.getLanguages().add(new Language(l)));

        monsterRequest.getSenses()
                .forEach(s -> monster.getSenses().add(new Sense(s)));

        monsterRequest.getSavingThrows()
                .forEach(s -> monster.getSavingThrows().add(new SavingThrow(s)));

        monsterRequest.getFeatures()
                .forEach(f -> monster.getFeatures().add(new Feature(f.getName(), f.getDescription())));

        monsterRequest.getActions()
                .forEach(a -> monster.getActions().add(new Action(a.getName(), a.getDescription())));

        monsterRequest.getLegendaryActions()
                .forEach(a -> monster.getLegendaryActions().add(new LegendaryAction(a.getName(), a.getDescription())));


        /* Actualizamos el monstruo */
        monsterRepository.save(monster);
        LOGGER.info("[MonstersService] updateMonsterLists Monstruo actualizado -> {}", monster.getName());

        return new BasicResponse(HttpStatus.OK, "Monstruo actualizado");
    }

}

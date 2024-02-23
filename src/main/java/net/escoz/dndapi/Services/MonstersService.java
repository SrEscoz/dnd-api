package net.escoz.dndapi.Services;

import net.escoz.dndapi.DTOs.MonsterDTO;
import net.escoz.dndapi.DTOs.MonsterTypeDTO;
import net.escoz.dndapi.DTOs.Reponses.BasicResponse;
import net.escoz.dndapi.DTOs.Request.PostSensesRequest;
import net.escoz.dndapi.Exceptions.BadRequestException;
import net.escoz.dndapi.Model.Language;
import net.escoz.dndapi.Model.Monsters.Monster;
import net.escoz.dndapi.Model.Monsters.Sense;
import net.escoz.dndapi.Model.Monsters.Skill;
import net.escoz.dndapi.Model.Monsters.Type;
import net.escoz.dndapi.Repositories.MonsterRepository;
import net.escoz.dndapi.Repositories.MonsterSensesRepository;
import net.escoz.dndapi.Repositories.MonsterSizeRepository;
import net.escoz.dndapi.Repositories.MonsterTypeRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
    private MonsterSensesRepository sensesRepository;

    @Autowired
    private ModelMapper modelMapper;

    /* ==============================
            Métodos de creación
     ============================== */

    @Override
    public BasicResponse createMonster(MonsterDTO monsterDTO) {
        /* Mapeamos la entrada a una entidad de la bb dd */
        Monster monster = modelMapper.map(monsterDTO, Monster.class);

        monsterDTO.getSkills()
                .forEach(skill -> monster.addSkill(new Skill(skill, null)));

        monsterDTO.getLanguages()
                .forEach(language -> monster.addLanguage(new Language(language, null)));

        monsterDTO.getSenses()
                .forEach(sense -> monster.addSense(new Sense(sense, null)));
        monster.removeNulls();

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
    public BasicResponse createMonsterSenses(PostSensesRequest postSensesRequest) {
        List<String> sensesDTO = postSensesRequest.getSenses();

        /* Comprobación de validez de la entrada */
        if (CollectionUtils.isEmpty(sensesDTO)) {
            LOGGER.error("[MonstersService] createMonsterSenses -> Lista vacía");
            throw new BadRequestException("Lista de sentidos vacía");
        }

        for (String senseDTO : sensesDTO) {
            if (sensesRepository.existsById(senseDTO)) {
                LOGGER.error("[MonstersService] createMonsterSenses Tipo duplicado -> {}", senseDTO);
                throw new BadRequestException("El sentido '" + senseDTO + "' ya existe");
            }
        }

        /* Mapeamos la entrada a una entidad de la bb dd */
        List<Sense> senses = sensesDTO
                .stream()
                .map(sense -> new Sense(sense, null))
                .toList();

        sensesRepository.saveAll(senses);
        LOGGER.info("[MonstersService] createMonsterSenses Sentidos creados creado -> {}", sensesDTO);

        return new BasicResponse(HttpStatus.CREATED, "Sentido(s) creado(s)");
    }
}

package net.escoz.dndapi.Services;

import net.escoz.dndapi.DTOs.MonsterTypeDTO;
import net.escoz.dndapi.DTOs.Reponses.BasicResponse;
import net.escoz.dndapi.Exceptions.BadRequestException;
import net.escoz.dndapi.Model.Monsters.Type;
import net.escoz.dndapi.Repositories.MonsterTypesRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class MonstersService implements IMonstersService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MonstersService.class);

    @Autowired
    private MonsterTypesRepository monsterTypesRepository;

    @Autowired
    private ModelMapper modelMapper;

    /* ==============================
            Métodos de creación
     ============================== */

    @Override
    public BasicResponse createMonsterType(MonsterTypeDTO monsterTypeDTO) {
        /* Mapeamos la entrada a una entidad de la bb dd */
        Type type = modelMapper.map(monsterTypeDTO, Type.class);

        if (monsterTypesRepository.existsById(type.getName())) {
            LOGGER.error("[MonstersService] createMonsterType Tipo duplicado -> {}", type.getName());
            throw new BadRequestException("El tipo ya existe");
        }

        monsterTypesRepository.save(type);
        LOGGER.info("[MonstersService] createMonsterType Tipo creado -> {}", type.getName());

        return new BasicResponse(HttpStatus.CREATED, "Tipo de monstruo creado");
    }
}

package net.escoz.dndapi.Services;

import net.escoz.dndapi.DTOs.MonsterSizeDTO;
import net.escoz.dndapi.DTOs.MonsterTypeDTO;
import net.escoz.dndapi.DTOs.Reponses.BasicResponse;
import net.escoz.dndapi.DTOs.Reponses.MonsterDTO;
import net.escoz.dndapi.DTOs.Request.MonsterRequest;

import java.util.List;

public interface IMonstersService {

    List<MonsterDTO> getMonsters();

    List<MonsterTypeDTO> getMonsterTypes();

    List<MonsterSizeDTO> getMonsterSizes();

    BasicResponse createMonster(MonsterRequest monsterRequest);

    BasicResponse createMonsterType(MonsterTypeDTO monsterTypeDTO);

    BasicResponse createMonsterSize(MonsterSizeDTO monsterSizeDTO);

}

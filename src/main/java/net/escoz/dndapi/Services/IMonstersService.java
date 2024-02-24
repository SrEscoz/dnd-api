package net.escoz.dndapi.Services;

import net.escoz.dndapi.DTOs.MonsterSizeDTO;
import net.escoz.dndapi.DTOs.Request.MonsterRequest;
import net.escoz.dndapi.DTOs.MonsterTypeDTO;
import net.escoz.dndapi.DTOs.Reponses.BasicResponse;
import net.escoz.dndapi.DTOs.Reponses.MonsterDTO;
import net.escoz.dndapi.DTOs.Request.SensesRequest;

import java.util.List;

public interface IMonstersService {

    List<MonsterDTO> getMonsters();

    BasicResponse createMonster(MonsterRequest monsterRequest);

    BasicResponse createMonsterType(MonsterTypeDTO monsterTypeDTO);

    BasicResponse createMonsterSize(MonsterSizeDTO monsterSizeDTO);

    BasicResponse createMonsterSenses(SensesRequest sensesRequest);
}

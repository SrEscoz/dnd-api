package net.escoz.dndapi.Services;

import net.escoz.dndapi.DTOs.MonsterDTO;
import net.escoz.dndapi.DTOs.MonsterTypeDTO;
import net.escoz.dndapi.DTOs.Reponses.BasicResponse;
import net.escoz.dndapi.DTOs.Request.PostSensesRequest;

public interface IMonstersService {

    BasicResponse createMonster(MonsterDTO monsterDTO);

    BasicResponse createMonsterType(MonsterTypeDTO monsterTypeDTO);

    BasicResponse createMonsterSenses(PostSensesRequest postSensesRequest);
}

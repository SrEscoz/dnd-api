package net.escoz.dndapi.Services;

import net.escoz.dndapi.DTOs.MonsterTypeDTO;
import net.escoz.dndapi.DTOs.Reponses.BasicResponse;

public interface IMonstersService {

    BasicResponse createMonsterType(MonsterTypeDTO monsterTypeDTO);
}

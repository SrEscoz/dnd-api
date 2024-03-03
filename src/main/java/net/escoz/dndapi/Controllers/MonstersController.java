package net.escoz.dndapi.Controllers;

import net.escoz.dndapi.DTOs.MonsterSizeDTO;
import net.escoz.dndapi.DTOs.MonsterTypeDTO;
import net.escoz.dndapi.DTOs.Reponses.BasicResponse;
import net.escoz.dndapi.DTOs.Reponses.MonsterDTO;
import net.escoz.dndapi.DTOs.Request.MonsterRequest;
import net.escoz.dndapi.Services.MonstersService;
import net.escoz.dndapi.Utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/monsters")
public class MonstersController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MonstersController.class);

    @Autowired
    private MonstersService monstersService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BasicResponse postMonster(@RequestBody MonsterRequest request) {
        LOGGER.info("[MonstersController] postMonster -> {}", Utils.objectToJson(request));
        return monstersService.createMonster(request);
    }

    @PutMapping("lists/{monster}")
    public BasicResponse putMonsterLists(@PathVariable("monster") String monster, @RequestBody MonsterDTO monsterDTO) {
        LOGGER.info("[MonstersController] putMonsterLists {} -> {}", monster, monsterDTO);
        monsterDTO.setName(monster);
        return monstersService.updateMonsterLists(monsterDTO);
    }

    @PostMapping("/types")
    @ResponseStatus(HttpStatus.CREATED)
    public BasicResponse postType(@RequestBody MonsterTypeDTO request) {
        LOGGER.info("[MonstersController] postTypes -> {}", Utils.objectToJson(request));
        return monstersService.createMonsterType(request);
    }

    @PostMapping("/sizes")
    @ResponseStatus(HttpStatus.CREATED)
    public BasicResponse postSize(@RequestBody MonsterSizeDTO request) {
        LOGGER.info("[MonstersController] postSize -> {}", Utils.objectToJson(request));
        return monstersService.createMonsterSize(request);
    }
}

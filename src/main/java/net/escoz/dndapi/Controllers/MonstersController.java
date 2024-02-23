package net.escoz.dndapi.Controllers;

import net.escoz.dndapi.DTOs.MonsterDTO;
import net.escoz.dndapi.DTOs.MonsterTypeDTO;
import net.escoz.dndapi.DTOs.Reponses.BasicResponse;
import net.escoz.dndapi.DTOs.Request.PostSensesRequest;
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

    @GetMapping
    public String getMonsters() {
        return "Monstruo";
    }

    /* ==============================
            Métodos de creación
     ============================== */

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BasicResponse postMonster(@RequestBody MonsterDTO request) {
        LOGGER.info("[MonstersController] postMonster -> {}", Utils.objectToJson(request));
        return monstersService.createMonster(request);
    }

    @PostMapping("/types")
    @ResponseStatus(HttpStatus.CREATED)
    public BasicResponse postType(@RequestBody MonsterTypeDTO request) {
        LOGGER.info("[MonstersController] postTypes -> {}", Utils.objectToJson(request));
        return monstersService.createMonsterType(request);
    }

    @PostMapping("/senses")
    @ResponseStatus(HttpStatus.CREATED)
    public BasicResponse postSenses(@RequestBody PostSensesRequest request) {
        LOGGER.info("[MonstersController] postSenses -> {}", Utils.objectToJson(request));
        return monstersService.createMonsterSenses(request);
    }
}
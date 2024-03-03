package net.escoz.dndapi.Controllers.Public;

import net.escoz.dndapi.Controllers.MonstersController;
import net.escoz.dndapi.DTOs.MonsterSizeDTO;
import net.escoz.dndapi.DTOs.MonsterTypeDTO;
import net.escoz.dndapi.DTOs.Reponses.MonsterDTO;
import net.escoz.dndapi.Services.MonstersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pub/monsters")
public class MonstersPublicController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MonstersController.class);

    @Autowired
    private MonstersService monstersService;

    @GetMapping
    public List<MonsterDTO> getMonsters() {
        LOGGER.info("[MonstersController] getMonsters");
        return monstersService.getMonsters();
    }

    @GetMapping("/types")
    public List<MonsterTypeDTO> getTypes() {
        LOGGER.info("[MonstersController] getTypes");
        return monstersService.getMonsterTypes();
    }

    @GetMapping("/sizes")
    public List<MonsterSizeDTO> getSizes() {
        LOGGER.info("[MonstersController] getSizes");
        return monstersService.getMonsterSizes();
    }
}

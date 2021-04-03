/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comps368.tma03;

import comps368.tma03.model.Items;
import comps368.tma03.repo.ItemRepository;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api")
public class ApiController {
    
    @Resource
    private ItemRepository itemRepo;

    @RequestMapping(value={"","index"}, method=RequestMethod.GET)
    public List<Items> index(ModelMap m){
        return itemRepo.findAll();
    }
}

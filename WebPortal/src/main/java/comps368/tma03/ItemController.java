/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comps368.tma03;

import comps368.tma03.model.ItemViewModel;
import comps368.tma03.model.Items;
import comps368.tma03.repo.ItemRepository;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value={"","/items"})
public class ItemController {
    
    @Resource
    private ItemRepository itemRepo;
    
    @Autowired
    private ItemValidator validator;
    
    @RequestMapping(value={"","index"}, method=RequestMethod.GET)
    public String index(ModelMap m){
        //Retrieve all the Item records from ItemRepository
        List<Items> items = itemRepo.findAll();
        
        //Put the List of items into Model Map
        m.addAttribute("items", items);
        
        return "items/index";
    }
    
    @RequestMapping(value="index/{keyword}", method=RequestMethod.GET)
    public String search(@PathVariable("keyword") String keyword, ModelMap m){
        //Call the SearchItemByCodeOrName() in the ItemRepository
        List<Items> items = itemRepo.SearchItemByCodeOrName(keyword);
        
        //Put the List of items into Model Map
        m.addAttribute("items", items);
        
        return "items/index";
    }    
    
    //An action for DISPLAY create page
    @RequestMapping(value="create", method=RequestMethod.GET)
    public String viewCreate(ModelMap m){
        //Put a new Items object into the Model Map
        m.addAttribute("newItem", new ItemViewModel());
        return "items/create";
    }    
    
    //An action for HANDLE create form send from client
    @RequestMapping(value="create", method=RequestMethod.POST)
    public String create(ModelMap m, @ModelAttribute("newItem") @Valid ItemViewModel _item, BindingResult result){
        //Valid by the ItemValidtor
        validator.validate(_item, result);
        
        //check whether there are errors, if yes, return to the create page
        if (result.hasErrors()) {
            m.addAttribute("newItem", _item);
            return "items/create";
        }
        
        //Create the new Items object ans copy from view model
        Items newItem = new Items();
        _item.copyValue(newItem);
        
        //if no error, then save by repository
        itemRepo.save(newItem);
        
        //redirect to index page
        return "redirect:../index";
    }       
    
    //An action for DISPLAY edit page
    @RequestMapping(value="edit/{itemId}", method=RequestMethod.GET)
    public String viewEdit(@PathVariable("itemId") Integer itemId, ModelMap m){
        //Retrieve Item by id from repo
        Items _item = itemRepo.findById(itemId).get();
        
        //Put the items into Model Map
        m.addAttribute("editItem", _item);
        
        return "items/edit";
    }      
    
    //An action for HANDLE edit form send from client
    @RequestMapping(value="edit/{itemId}", method=RequestMethod.POST)
    public String edit(ModelMap m, @PathVariable("itemId") Integer itemId, @ModelAttribute("editItem") @Valid ItemViewModel _item, BindingResult result){
        //Valid by the ItemValidtor
        validator.validate(_item, result);
        
        //check whether there are errors, if yes, return to the create page
        if (result.hasErrors()) {
            m.addAttribute("editItem", _item);
            return "items/edit";
        }
        
        //Retrieve the Items from DB and update the value
        Items existingItem = itemRepo.findById(itemId).get();
        _item.copyValue(existingItem);
        
        //if no error, then save by repository
        itemRepo.save(existingItem);
        
        //redirect to index page
        return "redirect:../index";
    }           
    
    //An action for HANDLE delete form send from client
    @RequestMapping(value="delete/{itemId}", method=RequestMethod.GET)
    public String delete(@PathVariable("itemId") Integer itemId){
        //Delete the Items by itemId by using ItemRepo
        itemRepo.deleteById(itemId);
        
        //redirect to index page
        return "redirect:../index";
    }      
    
    //A custom error page
    @RequestMapping(value="/error", method=RequestMethod.GET)
    public String error(){
        return "error";
    }
}

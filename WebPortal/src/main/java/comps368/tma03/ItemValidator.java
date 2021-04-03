/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comps368.tma03;

import comps368.tma03.model.ItemViewModel;
import comps368.tma03.repo.ItemRepository;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Cyrus Cheng
 */
@Component
public class ItemValidator implements Validator {

    @Resource
    private ItemRepository itemRepo;
    
    @Override
    public boolean supports(Class<?> type) {
        return ItemViewModel.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ItemViewModel _i = (ItemViewModel)o;
        
        //check the item code is null or empty
        String itemCode = _i.getItemCode();
        if(itemCode == null || itemCode.isEmpty()){
            errors.rejectValue("itemCode", "", "Item Code must be provided!");
        }     
        
        //check the item code is used before
        if(_i.getItemId() == null && !itemRepo.readItemsByItemCode(itemCode).isEmpty()){
            errors.rejectValue("itemCode", "", "Item Code already used!");
        }             
        
        //check the price is positive and smaller than 999.99
        if(_i.getItemPrice() < 0 || _i.getItemPrice() > 999.99){
            errors.rejectValue("itemPrice", "", "Price must between 0 and 999.99 inclusively!");
        }
    }
    
}

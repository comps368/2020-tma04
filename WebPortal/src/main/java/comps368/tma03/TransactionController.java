package comps368.tma03;

import comps368.tma03.model.TransactionDetails;
import comps368.tma03.model.Transactions;
import comps368.tma03.repo.TransactionRepository;
import java.util.List;
import java.util.Optional;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/transactions")
public class TransactionController {
    
    @Resource
    private TransactionRepository repo;
    
    @RequestMapping(value={"","index"}, method=RequestMethod.GET)
    public String index(ModelMap m){
        //Retrieve all the transaction records from TransactionRepository
        List<Transactions> trans = repo.findAll();
        
        //Put the List of items into Model Map
        m.addAttribute("trans", trans);
        
        return "transactions/index";
    }
    
    @RequestMapping(value="details/{transId}", method=RequestMethod.GET)
    public String details(ModelMap m, @PathVariable("transId") Long transId){
        //Retrieve all the transaction records from TransactionRepository
        Optional<Transactions> trans = repo.findById(transId);
        if(trans.isPresent()){
            List<TransactionDetails> details = trans.get().getTransactiondetailsList();
        
            //Put the List of items into Model Map
            m.addAttribute("details", details);
        } else {
            return "/error";
        }
        
        return "transactions/details";
    }    
}

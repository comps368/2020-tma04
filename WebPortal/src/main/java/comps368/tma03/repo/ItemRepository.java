/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comps368.tma03.repo;

import comps368.tma03.model.Items;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Cyrus Cheng
 */
public interface ItemRepository extends JpaRepository<Items, Integer> {
    
    List<Items> readItemsByItemCode(String itemCode);
    
    @Query("select i from Items i where i.itemCode like %:keyword or i.itemName like %:keyword")
    List<Items> SearchItemByCodeOrName(@Param("keyword") String keyword);
}

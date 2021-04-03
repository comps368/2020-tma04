/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comps368.tma03.repo;

import comps368.tma03.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Cyrus Cheng
 */
public interface TransactionRepository extends JpaRepository<Transactions, Long> {
    
}

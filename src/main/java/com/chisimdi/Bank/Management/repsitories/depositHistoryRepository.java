package com.chisimdi.Bank.Management.repsitories;
import com.chisimdi.Bank.Management.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface depositHistoryRepository extends JpaRepository<depositHistory,Integer> {
}

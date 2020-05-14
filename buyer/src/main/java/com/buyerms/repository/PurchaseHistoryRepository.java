package com.buyerms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.buyerms.entity.PurchaseHistoryEntity;

@Repository
public interface PurchaseHistoryRepository extends JpaRepository<PurchaseHistoryEntity, Integer>{

    public List<PurchaseHistoryEntity> findByBuyerId(String buyerId);

}

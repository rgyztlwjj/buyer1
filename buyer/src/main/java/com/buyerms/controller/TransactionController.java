package com.buyerms.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buyerms.models.TransactionModel;
import com.buyerms.service.TransactionService;

@RestController
@RequestMapping(value = "/transaction")
public class TransactionController {
	
	@Autowired
    private TransactionService service;
    
    /**
     * Checkout
     * @param models TransactionModel[]
     * @return true:checkout sucessful, false:checkout failure
     */
    @PostMapping
    public ResponseEntity<Boolean> checkout(@RequestBody TransactionModel[] models) {
//        return ResponseEntity.ok(service.checkout(models));
    	return ResponseEntity.ok(true);
    }

    /**
     * Get discount
     * @param code
     * @return discount percent, if not found or expired then return null.
     */
    @GetMapping("/discount/{code}")
    public ResponseEntity<BigDecimal> getDiscount(@PathVariable String code) {
        BigDecimal discount = service.getDiscount(code);

        if (discount == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.ok(discount);
    }

}
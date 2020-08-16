package com.akiraz.eventsourcingspringboot.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akiraz.eventsourcingspringboot.services.queries.AccountQueryService;

@RestController
@RequestMapping(value = "/accounts")
public class QueryController {

    private final AccountQueryService accountQueryService;

    public QueryController(AccountQueryService accountQueryService) {
        this.accountQueryService = accountQueryService;
    }

    @GetMapping("/events/{accountNumber}")
    public List<Object> listEventsForAccount(@PathVariable(value = "accountNumber") String accountNumber){
        return accountQueryService.listEventsForAccount(accountNumber);
    }
}

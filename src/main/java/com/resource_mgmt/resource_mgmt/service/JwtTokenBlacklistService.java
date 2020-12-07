package com.resource_mgmt.resource_mgmt.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class JwtTokenBlacklistService {
    
    private static Set<String> blacklist = new HashSet<>();
     
    public void add(String input) {
        blacklist.add(input);
    }

    public boolean check(String input) {
        return !blacklist.contains(input);
    }
}

package com.xenos.rental.service;

import com.xenos.rental.repository.auth.XenosAccountRepository;
import org.springframework.security.core.userdetails.*;
import reactor.core.publisher.Mono;


public class XenosAccountService implements ReactiveUserDetailsService {

    private XenosAccountRepository accountRepository;

    public XenosAccountService(XenosAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Mono<UserDetails> findByUsername(String username) {
        return accountRepository.findByUsername(username).cast(UserDetails.class);
    }
}

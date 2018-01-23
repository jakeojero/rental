package com.xenos.rental.repository.auth;

import com.xenos.rental.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface XenosAccountRepository extends ReactiveMongoRepository<User, String> {

    Mono<User> findByUsername(final String username);

}

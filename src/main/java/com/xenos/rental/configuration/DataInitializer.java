package com.xenos.rental.configuration;

import com.xenos.rental.model.User;
import com.xenos.rental.repository.auth.XenosAccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class DataInitializer {

    private final XenosAccountRepository xenosAccountRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(XenosAccountRepository xenosAccountRepository, PasswordEncoder passwordEncoder) {
        this.xenosAccountRepository = xenosAccountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @EventListener(ContextRefreshedEvent.class)
    public void init() {
        initUsers();
    }

    private void initUsers() {
        log.info("start users initialization...");
        this.xenosAccountRepository
                .deleteAll()
                .thenMany(
                        Flux
                                .just("user", "admin")
                                .flatMap(
                                        username -> {
                                            List<String> roles = "user".equals(username)
                                                    ? Arrays.asList("ROLE_USER")
                                                    : Arrays.asList("ROLE_USER", "ROLE_ADMIN");

                                            User user = User.builder()
                                                    .roles(roles)
                                                    .username(username)
                                                    .password(passwordEncoder.encode("password"))
                                                    .email(username + "@example.com")
                                                    .build();
                                            return this.xenosAccountRepository.save(user);
                                        }
                                )
                )
                .log()
                .subscribe(
                        null,
                        null,
                        () -> log.info("done users initialization...")
                );
    }
}

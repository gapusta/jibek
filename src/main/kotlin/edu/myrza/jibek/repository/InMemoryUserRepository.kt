package edu.myrza.jibek.repository

import edu.myrza.jibek.model.User
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux

@Component
class InMemoryUserRepository : UserRepository {

    override fun findAll(): Flux<User> = Flux.empty()

}

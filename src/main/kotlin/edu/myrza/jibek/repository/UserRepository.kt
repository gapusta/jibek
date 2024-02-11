package edu.myrza.jibek.repository

import edu.myrza.jibek.model.User
import reactor.core.publisher.Flux

//import org.springframework.data.repository.reactive.ReactiveCrudRepository
//import org.springframework.stereotype.Repository

//@Repository
//interface UserRepository : ReactiveCrudRepository<User, String>
interface UserRepository {

    fun findAll(): Flux<User>

}

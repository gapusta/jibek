package edu.myrza.jibek.controller

import edu.myrza.jibek.model.User
import edu.myrza.jibek.repository.UserRepository
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/user")
class UserController(private val repository: UserRepository) {

    @GetMapping(produces = [ MediaType.APPLICATION_NDJSON_VALUE ])
    fun getAllUsers(): Flux<User> = repository.findAll()

}

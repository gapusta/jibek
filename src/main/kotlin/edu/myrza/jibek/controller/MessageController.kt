package edu.myrza.jibek.controller

import edu.myrza.jibek.model.Message
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Sinks

@RestController
class MessageController {

    private val sink = Sinks.many()
            .multicast() // broadcast signals to multiple Subscribers
            .onBackpressureBuffer<Message>()

    @PostMapping("/send")
    fun send(@RequestBody message: Message) {
        val result = sink.tryEmitNext(message)

        if (result.isFailure) {
            println("Failed to send message : $message")
        }
    }

    // Server sent events source
    @GetMapping(value = [ "/messages" ], produces = [ MediaType.TEXT_EVENT_STREAM_VALUE ])
    fun messages(): Flux<Message> {
        return sink.asFlux()
    }

}

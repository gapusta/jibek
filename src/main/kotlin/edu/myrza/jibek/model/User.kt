package edu.myrza.jibek.model

//import org.springframework.data.annotation.Id
//import org.springframework.data.relational.core.mapping.Table

//@Table("usr")
data class User(
//    @Id
    val username: String,
    val password: String
)

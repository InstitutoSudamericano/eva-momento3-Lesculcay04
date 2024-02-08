package com.example.evam3.entity

import jakarta.persistence.*
import java.util.*

@Entity
@Table (name="film")
class Film {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var title: String? = null
    var director: String? = null
    var duration: Long? = null
    var country: String? = null
    @Column(name="ticket_office")
    var ticketOffice: Double? = null
    var presale: Long? = null
    var puntuation: Double? = null
    var gender: String? = null
    var year: Date? = null
    var writer: String? = null
    var investment: Long? = null
    var synopsis: String? = null
}
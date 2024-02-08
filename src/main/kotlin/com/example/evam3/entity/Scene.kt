package com.example.evam3.entity

import jakarta.persistence.*
import java.util.*

@Entity
@Table (name="scene")
class Scene {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var description: String? = null
    var budget: Double? = null
    @Column(name="special_effects")
    var special_effects: Boolean? = null
    @Column(name="cost_of_the_suit")
    var costOfTheSuit: Double? = null
    @Column(name="makeup_cost")
    var makeupCost: Double? = null
    @Column(name="number_of_films")
    var numberOfFilms: Long? = null
    @Column(name="film_id")
    var filmId: Long? = null
    var minutes: Long? = null
}
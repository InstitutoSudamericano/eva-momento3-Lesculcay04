package com.example.evam3.entity

import jakarta.persistence.*

@Entity
@Table(name="character")
class Character {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var name: String? = null
    var age: Long? = null
    var description: String? = null
    @Column(name="actor_name")
    var actorName: String? = null
    var cost: Double? = null
    var gender: String? = null
    var punctuation: Long? = null
    @Column(name="scene_id")
    var sceneId: Long? = null
}
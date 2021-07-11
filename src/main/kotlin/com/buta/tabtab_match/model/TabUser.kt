package com.buta.tabtab_match.model

import javax.persistence.*

@Entity
@Table(name = "tab_user")
data class TabUser(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "user_name")
    val name: String,

    @Column(name = "email")
    var email: String

    ) : AbstractTimestampEntity()
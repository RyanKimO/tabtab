package com.buta.tabtab_match.model

import com.fasterxml.jackson.annotation.JsonIgnore
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
    var email: String,
    @Column(name = "phone")
    var phone: String? = null,
    @Column(name = "secret")
    var secret: String? = null,

    @OneToOne(cascade = [CascadeType.ALL], mappedBy = "tabUser")
    @MapKey(name = "user_id")
    @JsonIgnore
    var details: TabUserDetails? = null

) : AbstractTimestampEntity() {

    override fun toString(): String {
        return "TabUser(id=$id, name='$name', email='$email', phone=$phone, secret=$secret)"
    }
}
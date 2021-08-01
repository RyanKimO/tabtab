package com.buta.tabtab_match.model

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "tab_user_details")
data class TabUserDetails(

    @Id
    @Column(name = "user_id")
    var userId: Long? = null,
    @Column(name = "display_name")
    var displayName: String?,
    @Column(name = "display_phone")
    var displayPhone: String?,
    @Column(name = "age_range")
    var ageRange: Int?,
    @Column(name = "skill_level")
    var skillLevel: Int?,
    @Column(name = "team_ids")
    var teamIds: String?,
    @Column(name = "profile_img_url")
    var profileImgUrl: String?,
    @Column(name = "introduction")
    var introduction: String?,

    @MapsId("user_id")
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    var tabUser: TabUser,

    ) : AbstractTimestampEntity(), Serializable
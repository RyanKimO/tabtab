package com.buta.tabtab_match.model

import javax.persistence.*

@Entity
@Table(name = "tab_team")
data class TabTeam(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @Column(name = "team_name")
    val name: String,
    @Column(name = "display_phone")
    var phone: String? = null,

    @Column(name = "age_range_start")
    var ageRangeStart: Int? = null,
    @Column(name = "age_range_end")
    var ageRangeEnd: Int? = null,
    @Column(name = "skill_level")
    var level: Int? = null,

    @Column(name = "profile_img_url")
    var profileImgUrl: String? = null,
    @Column(name = "intro")
    var intro: String? = null,
    @Column(name = "uniform_top")
    var uniformTop: String? = null,
    @Column(name = "uniform_bottom")
    var uniformBottom: String? = null,

    @Column(name = "master_id")
    var masterId: Long,

    ) : AbstractTimestampEntity() {

    override fun toString(): String {
        return "TabTeam(id=$id, name='$name', phone=$phone, ageRangeStart=$ageRangeStart, ageRangeEnd=$ageRangeEnd, level=$level, profileImgUrl=$profileImgUrl, intro=$intro, uniformTop=$uniformTop, uniformBottom=$uniformBottom, masterId=$masterId)"
    }
}

package com.buta.tabtab_match.model

import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "match_post")
data class MatchPost(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @Column(name = "user_id")
    val userId: Long,
    @Column(name = "match_datetime")
    val matchDatetime: LocalDateTime? = null,
    @Column(name = "location_title")
    var locationTitle: String? = null,
    @Column(name = "location_full")
    var locationFull: String? = null,
    @Column(name = "location_x")
    var locationX: BigDecimal? = null, // 경도 longitude
    @Column(name = "location_y")
    var locationY: BigDecimal? = null, // 위도 lat
    @Column(name = "player_cnt")
    var playerCnt: Int? = null,
    @Column(name = "player_gender")
    var playerGender: String? = null,
    @Column(name = "shoes_type")
    var shoesType: String? = null,
    @Column(name = "play_fee")
    var playFee: Int? = null,
    @Column(name = "uniform_top")
    var uniformTop: String? = null,
    @Column(name = "uniform_bottom")
    var uniformBottom: String? = null,
    @Column(name = "team_name")
    var teamName: String? = null,
    @Column(name = "phone")
    var phone: String? = null,
    @Column(name = "age_range_start")
    var ageRangeStart: Int? = null,
    @Column(name = "age_range_end")
    var ageRangeEnd: Int? = null,
    @Column(name = "skill_level")
    var skillLevel: Int? = null,
    @Column(name = "description")
    var description: String? = null,
) : AbstractTimestampEntity() {

    @Column(name = "match_year_month")
    val matchYearMonth: Int? = matchDatetime?.let { it.year * 100 + it.month.value }
}
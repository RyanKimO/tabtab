package com.buta.tabtab_match.model

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MatchPostRepository : JpaRepository<MatchPost, Long> {
    fun findByMatchYearMonth(matchYearMonth: Int): List<MatchPost>

    fun findByUserId(userId: Long): List<MatchPost>
}

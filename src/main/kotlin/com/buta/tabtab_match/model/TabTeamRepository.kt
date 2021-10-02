package com.buta.tabtab_match.model

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TabTeamRepository : JpaRepository<TabTeam, Long> {
    fun findByMasterId(masterId: Long): List<TabTeam>
    fun findByName(name: String): TabTeam?
}

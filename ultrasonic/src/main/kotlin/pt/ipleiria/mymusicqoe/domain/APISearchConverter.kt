// Converts SearchResult entities from [org.moire.ultrasonic.api.subsonic.SubsonicAPIClient]
// to app domain entities.
@file:JvmName("APISearchConverter")
package pt.ipleiria.mymusicqoe.domain

import org.moire.ultrasonic.api.subsonic.models.SearchThreeResult
import org.moire.ultrasonic.api.subsonic.models.SearchTwoResult
import org.moire.ultrasonic.domain.SearchResult
import org.moire.ultrasonic.api.subsonic.models.SearchResult as APISearchResult

fun APISearchResult.toDomainEntity(): SearchResult = SearchResult(emptyList(), emptyList(),
        this.matchList.map { it.toDomainEntity() })

fun SearchTwoResult.toDomainEntity(): SearchResult = SearchResult(
        this.artistList.map { it.toDomainEntity() },
        this.albumList.map { it.toDomainEntity() },
        this.songList.map { it.toDomainEntity() })

fun SearchThreeResult.toDomainEntity(): SearchResult = SearchResult(
        this.artistList.map { it.toDomainEntity() },
        this.albumList.map { it.toDomainEntity() },
        this.songList.map { it.toDomainEntity() })

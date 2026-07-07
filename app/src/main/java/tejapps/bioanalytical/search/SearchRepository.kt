package tejapps.bioanalytical.search

import tejapps.bioanalytical.data.ChapterRepository
import tejapps.bioanalytical.models.Chapter

object SearchRepository {

    fun search(query: String): List<Chapter> {

        if (query.isBlank()) {
            return emptyList()
        }

        return ChapterRepository.chapters.filter {

            it.title.contains(query, ignoreCase = true)

        }

    }

}

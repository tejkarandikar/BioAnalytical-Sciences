package tejapps.bioanalytical

data class Bookmark(

    override val chapter: Chapter,

    override val timestamp: Long

) : ChapterReference

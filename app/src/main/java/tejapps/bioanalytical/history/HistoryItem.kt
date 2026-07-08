package tejapps.bioanalytical

data class HistoryItem(

    override val chapter: Chapter,

    override val timestamp: Long

) : ChapterReference

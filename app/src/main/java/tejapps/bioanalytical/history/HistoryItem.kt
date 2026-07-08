package tejapps.bioanalytical

data class HistoryItem(

    override val title: String,

    override val assetFile: String,

    override val timestamp: Long

) : ChapterReference(

    title,

    assetFile,

    timestamp

)

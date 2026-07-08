package tejapps.bioanalytical

data class Chapter(

    val menuId: Int,

    val title: String,

    val assetFile: String,

    val keywords: List<String> = emptyList()

)

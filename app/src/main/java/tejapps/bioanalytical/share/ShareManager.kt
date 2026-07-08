package tejapps.bioanalytical

import android.content.Context
import android.content.Intent

class ShareManager(

    private val context: Context

) {

    fun shareChapter(chapter: Chapter) {

    val shareText = buildString {

        append("BioAnalytical Sciences\n\n")

        append("Chapter: ")

        append(chapter.title)

        append("\n\n")

        append("This chapter is available in the BioAnalytical Sciences Android application.")

    }

    val intent = Intent(Intent.ACTION_SEND).apply {

        type = "text/plain"

        putExtra(Intent.EXTRA_SUBJECT, chapter.title)

        putExtra(Intent.EXTRA_TEXT, shareText)

    }

    context.startActivity(

        Intent.createChooser(

            intent,

            "Share Chapter"

        )

    )

}
    fun shareApp() {

    val shareText =

        """
        BioAnalytical Sciences
        
        Learn Chromatography, Spectroscopy,
        Electrophoresis, Immunoassays,
        Pharmacopoeias and more.
        
        Download from Google Play:
        
        https://play.google.com/store/apps/details?id=tejapps.bioanalytical
        """.trimIndent()

    val intent = Intent(Intent.ACTION_SEND).apply {

        type = "text/plain"

        putExtra(Intent.EXTRA_TEXT, shareText)

    }

    context.startActivity(

        Intent.createChooser(

            intent,

            "Share App"

        )

    )

}
    }

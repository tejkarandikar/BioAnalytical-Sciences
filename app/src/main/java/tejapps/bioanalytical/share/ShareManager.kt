package tejapps.bioanalytical.share

import android.content.Context
import android.content.Intent

class ShareManager(
    private val context: Context
) {

    fun share(title: String, assetFile: String) {

        val text = """
BioAnalytical Sciences

Chapter:
$title

Currently viewing:
$assetFile
""".trimIndent()

        val intent = Intent(Intent.ACTION_SEND)

        intent.type = "text/plain"

        intent.putExtra(Intent.EXTRA_TEXT, text)

        context.startActivity(

            Intent.createChooser(
                intent,
                "Share using"
            )

        )

    }

}

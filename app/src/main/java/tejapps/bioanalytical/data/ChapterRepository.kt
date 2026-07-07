package tejapps.bioanalytical.data

import tejapps.bioanalytical.R
import tejapps.bioanalytical.models.Chapter

object ChapterRepository {

    val chapters = listOf(

        Chapter(
            1,
            "Home",
            "index.html",
            R.id.nav_home
        ),

        Chapter(
            2,
            "Chromatographic Techniques",
            "chromatographic-techniques.html",
            R.id.nav_chromatography
        ),

        Chapter(
            3,
            "Spectroscopic Techniques",
            "spectroscopic-techniques.html",
            R.id.nav_spectroscopy
        ),

        Chapter(
            4,
            "Electrophoresis",
            "electrophoresis.html",
            R.id.nav_electrophoresis
        ),

        Chapter(
            5,
            "Immunoassays",
            "immunoassays.html",
            R.id.nav_immunoassays
        ),

        Chapter(
            6,
            "Sample Preparation",
            "sample-preparation.html",
            R.id.nav_sampleprep
        ),

        Chapter(
            7,
            "Pharmacopoeias",
            "pharmacopoeias.html",
            R.id.nav_pharmacopoeias
        ),

        Chapter(
            8,
            "Pharmacokinetics & Pharmacodynamics",
            "pharmacokinetics-pharmacodynamics.html",
            R.id.nav_pkpd
        ),

        Chapter(
            9,
            "Ayurvedic Formulations",
            "ayurvedic-formulations.html",
            R.id.nav_ayurveda
        ),

        Chapter(
            10,
            "Drugs & Cosmetics Act",
            "drugs-and-cosmetics-act.html",
            R.id.nav_drugs
        ),

        Chapter(
            11,
            "About the Author",
            "about-the-author.html",
            R.id.nav_author
        ),

        Chapter(
            12,
            "How to Use",
            "how-to-use.html",
            R.id.nav_help
        ),

        Chapter(
            13,
            "Privacy Policy",
            "privacy.html",
            R.id.nav_privacy
        )

    )

}

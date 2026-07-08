package tejapps.bioanalytical

import tejapps.bioanalytical.R
import tejapps.bioanalytical.models.Chapter

object ChapterRepository {

    val chapters = listOf(

           private val analyticalTechniques = listOf(

        Chapter(
            menuId = R.id.nav_chromatography,
            title = "Chromatographic Techniques",
            assetFile = "chromatographic-techniques.html",
            keywords = listOf(
                "Chromatography",
                "HPLC",
                "UPLC",
                "GC",
                "GCMS",
                "GC-MS",
                "TLC",
                "HPTLC",
                "Column Chromatography"
            )
        ),

        Chapter(
            menuId = R.id.nav_spectroscopy,
            title = "Spectroscopic Techniques",
            assetFile = "spectroscopic-techniques.html",
            keywords = listOf(
                "UV",
                "UV-Visible",
                "FTIR",
                "IR",
                "NMR",
                "AAS",
                "Atomic Absorption",
                "Fluorescence"
            )
        ),

        Chapter(
            menuId = R.id.nav_electrophoresis,
            title = "Electrophoresis",
            assetFile = "electrophoresis.html",
            keywords = listOf(
                "PAGE",
                "SDS-PAGE",
                "Agarose",
                "Gel Electrophoresis",
                "Capillary Electrophoresis"
            )
        ),

        Chapter(
            menuId = R.id.nav_immunoassays,
            title = "Immunoassays",
            assetFile = "immunoassays.html",
            keywords = listOf(
                "ELISA",
                "RIA",
                "CLIA",
                "Immunoassay"
            )
        ),

        Chapter(
            menuId = R.id.nav_sampleprep,
            title = "Sample Preparation",
            assetFile = "sample-preparation.html",
            keywords = listOf(
                "SPE",
                "Solid Phase Extraction",
                "LLE",
                "Extraction"
            )
        )

               ,

        Chapter(
            menuId = R.id.nav_pharmacopoeias,
            title = "Pharmacopoeias",
            assetFile = "pharmacopoeias.html",
            keywords = listOf(
                "IP",
                "USP",
                "BP",
                "EP",
                "JP"
            )
        ),

        Chapter(
            menuId = R.id.nav_pkpd,
            title = "Pharmacokinetics & Pharmacodynamics",
            assetFile = "pharmacokinetics-pharmacodynamics.html",
            keywords = listOf(
                "PK",
                "PD",
                "ADME",
                "Half Life",
                "Bioavailability"
            )
        ),

        Chapter(
            menuId = R.id.nav_ayurveda,
            title = "Ayurvedic Formulations",
            assetFile = "ayurvedic-formulations.html",
            keywords = listOf(
                "Bhasma",
                "Churna",
                "Taila",
                "Ghrita",
                "Ayurveda"
            )
        ),

        Chapter(
            menuId = R.id.nav_drugs,
            title = "Drugs & Cosmetics Act",
            assetFile = "drugs-and-cosmetics-act.html",
            keywords = listOf(
                "Drugs Act",
                "Schedule M",
                "Schedule Y",
                "CDSCO"
            )
        )

    )
               private val home = listOf(

        Chapter(

            menuId = R.id.nav_home,

            title = "Home",

            assetFile = "index.html",

            keywords = listOf(
                "Home",
                "Welcome"
            )

        )

    )
                   val chapters =

        home +

        analyticalTechniques
            fun getAllChapters(): List<Chapter> = chapters

    fun getChapterByMenuId(menuId: Int): Chapter? {

        return chapters.find {

            it.menuId == menuId

        }

    }

    fun getChapterByAssetFile(assetFile: String): Chapter? {

        return chapters.find {

            it.assetFile == assetFile

        }

    }

    fun search(query: String): List<Chapter> {

        return chapters.filter {

            it.title.contains(query, true) ||

            it.keywords.any { keyword ->

                keyword.contains(query, true)

            }

        }

    }

}

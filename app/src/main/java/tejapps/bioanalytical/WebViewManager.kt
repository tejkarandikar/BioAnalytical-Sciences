package tejapps.bioanalytical

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Build
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
class WebViewManager(
    private val webView: WebView
    private val progressBar: ProgressBar
)
    var currentChapter: Chapter? = null
        private set
{

    @SuppressLint("SetJavaScriptEnabled")
    fun initialize() {

        val settings = webView.settings

       settings.loadsImagesAutomatically = true

    settings.useWideViewPort = true

    settings.loadWithOverviewMode = true

    settings.builtInZoomControls = true

    settings.displayZoomControls = false

    settings.cacheMode = WebSettings.LOAD_DEFAULT

    settings.allowFileAccess = true

    settings.allowContentAccess = true

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

        settings.safeBrowsingEnabled = true

    }
private fun createWebViewClient(): WebViewClient {

    return object : WebViewClient() {

        override fun onPageStarted(
            view: WebView?,
            url: String?,
            favicon: Bitmap?
        ) {

            progressBar.visibility = View.VISIBLE

        }

        override fun onPageFinished(
            view: WebView?,
            url: String?
        ) {

            progressBar.visibility = View.GONE

        }

    }

}
private fun createChromeClient(): WebChromeClient {

    return object : WebChromeClient() {

        override fun onProgressChanged(

            view: WebView?,

            newProgress: Int

        ) {

            progressBar.progress = newProgress

        }

    }

}
    webView.webViewClient = createWebViewClient()

    webView.webChromeClient = createChromeClient()

}
}

        
        settings.setSupportZoom(true)

        webView.webChromeClient = WebChromeClient()
        webView.webChromeClient = object : WebChromeClient() {

    override fun onProgressChanged(
        view: WebView?,
        newProgress: Int
    ) {

        progressBar.progress = newProgress

        if (newProgress == 100) {

            progressBar.visibility = View.GONE

        } else {

            progressBar.visibility = View.VISIBLE

        }

    }

}

        webView.webViewClient = object : WebViewClient() {

    override fun onPageStarted(
        view: WebView?,
        url: String?,
        favicon: Bitmap?
    ) {

        progressBar.visibility = View.VISIBLE

    }

    override fun onPageFinished(
        view: WebView?,
        url: String?
    ) {

        progressBar.visibility = View.GONE

    }
override fun onReceivedError(
    view: WebView?,
    request: WebResourceRequest?,
    error: WebResourceError?
) 
            {

    Toast.makeText(

        view?.context,

        "Unable to load page",

        Toast.LENGTH_SHORT

    ).show()

}
}
            ): Boolean {

                return false

            }

            override fun onPageStarted(
                view: WebView?,
                url: String?,
                favicon: Bitmap?
            ) {

                super.onPageStarted(view, url, favicon)

            }

            override fun onPageFinished(
                view: WebView?,
                url: String?
            ) {

                super.onPageFinished(view, url)

            }

        }

    }

   fun loadHomePage() {

    loadPage("index.html")

}

        webView.loadUrl("file:///android_asset/index.html")
        fun loadPage(assetFile: String){
       webView.loadUrl(

        "file:///android_asset/$assetFile"

    )

}
fun loadChapter(chapter: Chapter) {

    currentChapter = chapter

    loadPage(chapter.assetFile)

}
fun getCurrentPage(): String {

    return currentChapter?.assetFile ?: "index.html"

}
fun getCurrentTitle(): String {

    return currentChapter?.title ?: "Home"

}

    fun goBack(): Boolean {

        return if (webView.canGoBack()) {

            webView.goBack()

            true

        } else {

            false

        }

    }

}
fun loadPage(assetFile: String) {

    webView.loadUrl(
        "file:///android_asset/$assetFile"
    )

}
fun getCurrentPage(): String {

    return webView.url ?: "index.html"

}

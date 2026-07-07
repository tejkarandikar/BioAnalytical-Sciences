package tejapps.bioanalytical

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient

class WebViewManager(
    private val webView: WebView
    private val progressBar: ProgressBar
) 
{

    @SuppressLint("SetJavaScriptEnabled")
    fun initialize() {

        val settings = webView.settings

        settings.javaScriptEnabled = true
        settings.domStorageEnabled = true
        settings.databaseEnabled = true

        settings.loadsImagesAutomatically = true

        settings.allowFileAccess = true
        settings.allowContentAccess = true

        settings.useWideViewPort = true
        settings.loadWithOverviewMode = true

        settings.builtInZoomControls = false
        settings.displayZoomControls = false

        settings.cacheMode = WebSettings.LOAD_DEFAULT

        settings.setSupportZoom(true)

        webView.webChromeClient = WebChromeClient()

        webView.webViewClient = object : WebViewClient() {

            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
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

        webView.loadUrl("file:///android_asset/index.html")

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

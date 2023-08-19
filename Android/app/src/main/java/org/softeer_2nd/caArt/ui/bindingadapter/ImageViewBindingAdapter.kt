package org.softeer_2nd.caArt.ui.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.decode.SvgDecoder
import coil.load
import org.softeer_2nd.caArt.ui.custom.DynamicOptionFloatingImageView
import org.softeer_2nd.caArt.util.dp2px


@BindingAdapter("url")
fun ImageView.setImageSrcWithUrl(url: String?) {

    load(url) {
        scale(coil.size.Scale.FILL)
    }
}

@BindingAdapter("svgUrl")
fun ImageView.setImageSrcWithSvgUrl(svgUrl: String?) {
    load(svgUrl) {

        decoderFactory { result, options, _ ->
            SvgDecoder(result.source, options)
        }
        size(24f.dp2px(context), 24f.dp2px(context))
    }
}

@BindingAdapter("app:tint")
fun ImageView.setTint(color: Int) {
    setColorFilter(color)
}

@BindingAdapter("url")
fun DynamicOptionFloatingImageView.setImageSrcWithUrl(url: String?) {
    setImage(url)
}

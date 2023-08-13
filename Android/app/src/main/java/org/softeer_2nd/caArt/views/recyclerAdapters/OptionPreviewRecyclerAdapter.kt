package org.softeer_2nd.caArt.views.recyclerAdapters

import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.softeer_2nd.caArt.R
import org.softeer_2nd.caArt.models.datas.Option
import org.softeer_2nd.caArt.databinding.ItemOptionPreviewBinding
import org.softeer_2nd.caArt.views.callbackListener.OnRecyclerItemClickListener

class OptionPreviewRecyclerAdapter(private val listener: OnRecyclerItemClickListener<Option>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val optionList = mutableListOf<Option>()

    private val OPTION = 0
    private val SEE_MORE = 1
    private val OPTION_COUNT_INDICATOR=2

    override fun getItemViewType(position: Int): Int {
        return when(position){
            0-> OPTION_COUNT_INDICATOR
            itemCount-1-> SEE_MORE
            else -> OPTION
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            OPTION_COUNT_INDICATOR->{
                val textView=TextView(parent.context).apply{
                    layoutParams=ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                    typeface=resources.getFont(R.font.hyundaisanstextkrmedium)
                    textSize=16f
                    setTextColor(parent.context.getColor(R.color.gray_300))
                    //setBackgroundColor(Color.GRAY)
                }
                OptionCountIndicatorViewHolder(textView)
            }
            SEE_MORE->{
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_option_preivew_see_more, parent, false)
                OptionPreviewSeeMoreViewHolder(view)
            }
            else->{
                val binding =
                    ItemOptionPreviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                OptionPreviewViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is OptionPreviewViewHolder){
            holder.bind(optionList[position-1],position)
        }
        if(holder is OptionCountIndicatorViewHolder){
            holder.setOptionCount(optionList.size)
        }
    }

    override fun getItemCount(): Int = optionList.size + 2

    fun addOptionList(options:List<Option>){
        optionList.addAll(options)
    }

    inner class OptionPreviewViewHolder(private val binding: ItemOptionPreviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(option: Option, position: Int){
                binding.url=option.url
                binding.optionName=option.name
                binding.tvOptionPreviewMore.setOnClickListener {
                    listener.onItemClicked(position,option)
                }
            }
        }

    inner class OptionPreviewSeeMoreViewHolder(private val view: View) :
        RecyclerView.ViewHolder(view) {}

    inner class OptionCountIndicatorViewHolder(private val textView: TextView):RecyclerView.ViewHolder(textView) {

        private val prefixText = textView.context.getText(R.string.total)
        fun setOptionCount(optionCount: Int) {

            val appendString=" $optionCount"
            val spannable = SpannableStringBuilder(prefixText).apply{
                append(appendString)
                setSpan(
                    ForegroundColorSpan(itemView.context.getColor(R.color.blue)),
                    prefixText.length,
                    prefixText.length+appendString.length,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }
            textView.text =spannable
        }

    }
}
package com.example.infinotest.logic

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.infinotest.R
import com.example.infinotest.model.ItemFill
import com.squareup.picasso.Picasso

class FillAdapter(
    private val dataSet:Array<ItemFill>
    ):RecyclerView.Adapter<FillAdapter.ViewHolder>() {
     var onClickListener: OnCardClickListner? = null
     private var ctx:Context?=null

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val avatar :ImageView = view.findViewById(R.id.avatarBox)
        val avatarText:TextView=view.findViewById(R.id.avatarTextView)
        val names:TextView = view.findViewById(R.id.namesBox)
        val postinfo:TextView = view.findViewById(R.id.postinfoBox)
        val statename:TextView = view.findViewById(R.id.statenameBox)
        val stateresult : TextView = view.findViewById(R.id.stateresultBox)
        val kid : TextView = view.findViewById(R.id.kidBox)
        val button : Button = view.findViewById(R.id.button)
        val sumlabel: TextView=view.findViewById(R.id.sumLabelBox)
        val sum: TextView=view.findViewById(R.id.sumBox)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        //card view layout
       // val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.row_fill, viewGroup, false)

        //native layout
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.row_fill_without_cardview, viewGroup, false)
        ctx=viewGroup.context
        return ViewHolder(view)
    }

    override fun onBindViewHolder(v: ViewHolder, position: Int) {
        val data=dataSet[position]
         v.names.text=data.person.name
        data.person.surName?.let {  v.names.append(" $it")}
        v.names.append(" ${data.person.familyName}")
        v.postinfo.text=data.postInfo
        v.kid.text="КИД ${data.kid}"
        v.statename.text=data.state.name
        v.stateresult.text=data.stateResult
        v.statename.background= ctx?.let { ContextCompat.getDrawable(it,data.state.colorResId) }
        v.stateresult.background= ctx?.let { ContextCompat.getDrawable(it,data.state.colorResId) }
        if(data.amount==null)
        {
            v.sum.visibility=View.GONE
            v.sumlabel.visibility=View.GONE
            v.button.setText(R.string.open)
        }else
        {
            v.sum.visibility=View.VISIBLE
            v.sumlabel.visibility=View.VISIBLE
            v.sum.text=data.amount
            v.button.setText(R.string.show)
        }

        v.button.setOnClickListener { onClickListener?.onCardClicked(dataSet[position]) }

        if(data.person.avatarResId!=null)
        {
            v.avatar.visibility=View.VISIBLE
            v.avatarText.visibility=View.INVISIBLE
            Picasso.get().load(data.person.avatarResId).transform(CircleTransformer()).into(v.avatar)
        }else
        {
            v.avatar.visibility=View.INVISIBLE
            v.avatarText.visibility=View.VISIBLE
            v.avatarText.text="${data.person.name[0]}${data.person.familyName[0]}"
        }
    }

    override fun getItemCount() = dataSet.size

    interface OnCardClickListner {
        fun onCardClicked(rowData : ItemFill)
    }
}
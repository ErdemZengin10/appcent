package com.erdemzengin.myapplication.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.erdemzengin.myapplication.R
import com.erdemzengin.myapplication.models.FlightModel


class rvAdapter(val flightList:List<FlightModel>,private val listener:Listener):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var green=0
    private var yellow=1
    private var red=2


    class ViewHolderGreen(view: View):RecyclerView.ViewHolder(view){
        var havayoluText:TextView=view.findViewById(R.id.havayoluedit_green)
        var kalkisText:TextView=view.findViewById(R.id.kalkisedit_green)
        var varisText:TextView=view.findViewById(R.id.varisedit_green)
        var delayText:TextView=view.findViewById(R.id.rv_delay_green)
        fun bindGreen(item:FlightModel,listener: Listener){
            itemView.setOnClickListener {
                listener.onItemClick(item)
            }
            val dateTime_dep = item.departure?.estimated?.subSequence(11,16)
            val dep_name = item.departure?.icao
            val final_string_dep= dateTime_dep.toString()+"  "+dep_name


            val dateTime_arv=item.arrival?.estimated?.subSequence(11,16)
            val arv_name=item.arrival?.icao
            val final_string_arv= dateTime_arv.toString()+"  "+arv_name

            if(item.departure?.delay==null){

                delayText.setText("0")

            }else{
                var delay=item.departure?.delay
                delayText.setText(delay.toString())
            }






            havayoluText.setText(item.airline.name)
            kalkisText.setText(final_string_arv)
            varisText.setText((final_string_dep))
        }



    }

    class ViewHolderRed(view: View):RecyclerView.ViewHolder(view){
        var havayoluText:TextView=view.findViewById(R.id.havayoluedit_red)
        var kalkisText:TextView=view.findViewById(R.id.kalkisedit_red)
        var varisText:TextView=view.findViewById(R.id.varisedit_red)
        var delayText:TextView=view.findViewById(R.id.rv_delay_red)
        fun bindRed(item:FlightModel,listener: Listener){
            itemView.setOnClickListener {
                listener.onItemClick(item)
            }
            val dateTime_dep = item.departure?.estimated?.subSequence(11,16)
            val dep_name = item.departure?.icao
            val final_string_dep= dateTime_dep.toString()+"  "+dep_name


            val dateTime_arv=item.arrival?.estimated?.subSequence(11,16)
            val arv_name=item.arrival?.icao
            val final_string_arv= dateTime_arv.toString()+"  "+arv_name

            if(item.departure?.delay==null){

                delayText.setText("0")

            }else{
                var delay=item.departure?.delay
                delayText.setText(delay.toString())
            }

            havayoluText.setText(item.airline.name)
            kalkisText.setText(final_string_dep)
            varisText.setText((final_string_arv))


        }







    }
    class ViewHolderYellow(view: View):RecyclerView.ViewHolder(view){
        var havayoluText:TextView=view.findViewById(R.id.havayoluedit_yellow)
        var kalkisText:TextView=view.findViewById(R.id.kalkisedit_yellow)
        var varisText:TextView=view.findViewById(R.id.varisedit_yellow)
        var delayText:TextView=view.findViewById(R.id.rv_delay_yellow)
        fun bindYellow(item:FlightModel,listener: Listener){

            itemView.setOnClickListener {
                listener.onItemClick(item)
            }
            val dateTime_dep = item.departure?.estimated?.subSequence(11,16)
            val dep_name = item.departure?.icao
            val final_string_dep= dateTime_dep.toString()+"  "+dep_name


            val dateTime_arv=item.arrival?.estimated?.subSequence(11,16)
            val arv_name=item.arrival?.icao
            val final_string_arv= dateTime_arv.toString()+"  "+arv_name

            if(item.departure?.delay==null){

                delayText.setText("0")

            }else{
                var delay=item.departure?.delay
                delayText.setText(delay.toString())
            }


            havayoluText.setText(item.airline.name)
            kalkisText.setText(final_string_dep)
            varisText.setText((final_string_arv))

        }

    }


    interface Listener{
        fun onItemClick(flightModel:FlightModel)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return if(viewType==green){
            val view=inflater.inflate(R.layout.flight_cardview_green,parent,false)
            val vh =ViewHolderGreen(view)
            vh


        }
        else if(viewType==yellow){
            val view=inflater.inflate(R.layout.flight_cardview_yellow,parent,false)
            val vh =ViewHolderYellow(view)
            vh

        }
        else{
            val view=inflater.inflate(R.layout.flight_cardview_red,parent,false)
            val vh =ViewHolderRed(view)
            vh

        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is ViewHolderGreen ->{
                holder.bindGreen(flightList[position],listener)
            }
            is ViewHolderYellow ->{
                holder.bindYellow(flightList[position],listener)
            }
            is ViewHolderRed ->{
                holder.bindRed(flightList[position],listener)

            }
        }

    }

    override fun getItemCount(): Int {
        return flightList.size
    }
    override fun getItemViewType(position:  Int):Int{
        return if(flightList[position].flight_status=="active"){
            green

        }else if(flightList[position].flight_status=="scheduled"){
            yellow
        }
        else{
            red
        }
    }

}
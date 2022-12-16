package com.example.planeto

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view.view.*

class adapter(var planet: List<planetData>) : RecyclerView.Adapter<adapter.myViewHolder>() {

    class myViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {  //yeah view se value nikalta ha
        var title = view.title    //view.id
        var planetimg = view.planet_img
        var galaxy = view.galaxy
        var distance = view.distance
        var gravity = view.gravity
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.view, parent, false)
        return myViewHolder(itemView)   // act as adapter
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
       var dummyImage:Int?=null
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,PlanetDetail::class.java)
            intent.putExtra("data",planet[position])
            intent.putExtra("planetImage",dummyImage)
            holder.itemView.context.startActivity(intent)
        }
        holder.title.text = planet[position].title
        holder.galaxy.text = planet[position].galaxy
        holder.distance.text = planet[position].distance + "m km"
        holder.gravity.text = planet[position].gravity + " m/ss"

        when (planet[position].title!!.toLowerCase())   // title hi planet ka naam hoga aur lowercase karne se yeah farak pdega ki agar 1st letter capital hoga toh small ho jayega...ex ic_earth
        {
            "mars"->{
                dummyImage=R.drawable.ic_mars
            }
            "neptune"->{
                dummyImage=R.drawable.ic_neptune
            }
            "earth"->{
                dummyImage=R.drawable.ic_earth
            }
            "moon"->{
                dummyImage=R.drawable.ic_moon
            }
            "venus"->{
                dummyImage=R.drawable.ic_venus
            }
            "jupiter"->{
                dummyImage=R.drawable.ic_jupiter
            }
            "saturn"->{
                dummyImage=R.drawable.ic_saturn
            }
            "uranus"->{
                dummyImage=R.drawable.ic_uranus
            }
            "mercury"->{
                dummyImage=R.drawable.ic_mercury
            }
            "sun"->{
                dummyImage=R.drawable.ic_sun
            }



        }
        holder.planetimg.setImageResource(dummyImage!!)
    }

    override fun getItemCount(): Int {
        return planet.size           // kitne view bnane ha
    }


}

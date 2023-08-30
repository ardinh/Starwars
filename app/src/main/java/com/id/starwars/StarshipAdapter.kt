package com.id.starwars

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.id.starwars.models.Starship
import com.id.starwars.util.convertCurrency

class StarshipAdapter(private val starships: List<Starship>) : RecyclerView.Adapter<StarshipAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.textName)
        val modelTextView: TextView = itemView.findViewById(R.id.textModel)
        val manufacturerTextView: TextView = itemView.findViewById(R.id.textManufacturer)
        val costTextView: TextView = itemView.findViewById(R.id.textCost)
        val cargoCapacityTextView: TextView = itemView.findViewById(R.id.textCargoCapacity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_starship, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val starship = starships[position]
        holder.nameTextView.text = "Name : ${starship.name}"
        holder.modelTextView.text = "Model : ${starship.model}"
        holder.manufacturerTextView.text = "Manufacture : ${starship.manufacturer}"
        holder.costTextView.text = "Cost : ${convertCurrency(starship.costInCredits, 3, '.')}"
        holder.cargoCapacityTextView.text = "Capacity : ${convertCurrency(starship.cargoCapacity,3,'.')}"
    }

    override fun getItemCount(): Int = starships.size
}

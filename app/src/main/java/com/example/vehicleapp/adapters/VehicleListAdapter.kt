package com.example.vehicleapp.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.vehicleapp.model.Attendance
import com.example.vehicleapp.model.VehicleAttendance
import com.example.vehicleapp.model.VehiclesItem
import com.example.vehicleapp.viewholder.VehicleViewHolder
import kotlinx.android.synthetic.main.item_vehicle_layout.view.*
import org.apache.commons.lang3.StringUtils

/**
 * @author AliAzazAlam on 5/4/2021.
 */
class VehicleListAdapter(private val clickListener: OnItemClickListener) :
    RecyclerView.Adapter<VehicleViewHolder>() {

    var vehicleItems: ArrayList<VehicleAttendance> = ArrayList()
        set(value) {
            field = value
            val diffCallback =
                VehicleViewHolder.ChildViewDiffUtils(filteredVehicleItems, vehicleItems)
            val diffResult = DiffUtil.calculateDiff(diffCallback)
            if (filteredVehicleItems.size > 0)
                filteredVehicleItems.clear()
            filteredVehicleItems.addAll(value)
            diffResult.dispatchUpdatesTo(this)
        }

    private var filteredVehicleItems: ArrayList<VehicleAttendance> = ArrayList()
        set(value) {
            field = value
            val diffCallback =
                VehicleViewHolder.ChildViewDiffUtils(filteredVehicleItems, vehicleItems)
            val diffResult = DiffUtil.calculateDiff(diffCallback)
            diffResult.dispatchUpdatesTo(this)
        }

    fun clearProductItem() {
        filteredVehicleItems.clear()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): VehicleViewHolder {
        return VehicleViewHolder.create(viewGroup)
    }

    override fun onBindViewHolder(holder: VehicleViewHolder, i: Int) {
        val item = filteredVehicleItems[i]

        item.attendance?.let {
            if (it.meter_in != null && it.meter_out != null)
                item.attendance = null
        }

        holder.bind(item)
        holder.itemView.timeBtn.setOnClickListener {
            clickListener.onItemClick(item.vehicles, item.attendance, i)
        }
    }

    override fun getItemCount(): Int = filteredVehicleItems.size

    interface OnItemClickListener {
        fun onItemClick(item: VehiclesItem, attendance: Attendance?, position: Int)
    }
}
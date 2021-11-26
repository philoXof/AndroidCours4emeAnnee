/*package com.example.androidcoursJEHANNO

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_fragment.xml.*
import kotlinx.android.synthetic.main.list_item_cell.view.*
import java.util.*

class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.list_fragment.xml,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val days = List(30) { day ->
            "${
                Calendar.getInstance().run {
                    set(Calendar.DAY_OF_WEEK, day)
                    get(Calendar.DAY_OF_WEEK)
                }
            }"
        }

        main_list.run {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = ListAdapter(days, object: OnItemClickedListener {
                override fun onItemClicked(day: String) {

                    findNavController().navigate(
                        ListFragmentDirections.actionListFragmentToDetailsFragment(
                            day = day
                        )
                    )
                }
            })
            addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    DividerItemDecoration.VERTICAL
                )
            )
        }

    }

    class ListAdapter(val days: List<String>, val listener: OnItemClickedListener) : RecyclerView.Adapter<ListItemCell>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemCell {
            return ListItemCell(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.list_item_cell, parent, false)
            )
        }

        override fun onBindViewHolder(cell: ListItemCell, position: Int) {
            cell.text.text = when (days[position].toInt()) {
                Calendar.MONDAY -> "Lundi"
                Calendar.TUESDAY -> "Mardi"
                Calendar.WEDNESDAY -> "Mercredi"
                Calendar.THURSDAY -> "Jeudi"
                Calendar.FRIDAY -> "Vendredi"
                Calendar.SATURDAY -> "Samedi"
                Calendar.SUNDAY -> "Dimanche"
                else -> throw Exception("???")
            }

            cell.text.setOnClickListener {
                listener.onItemClicked(days[position])
            }
        }

        override fun getItemCount(): Int {
            return days.size
        }

    }

    class ListItemCell(v: View) : RecyclerView.ViewHolder(v) {

        val text: TextView = v.text_cell

    }

}

interface OnItemClickedListener {
    fun onItemClicked(day: String)
}*/
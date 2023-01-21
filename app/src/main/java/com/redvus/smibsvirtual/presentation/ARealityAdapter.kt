package com.redvus.smibsvirtual

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import com.redvus.smibsvirtual.data.Project

class ARealityAdapter(projects: Array<Project>) : RecyclerView.Adapter<ARealityAdapter.ARViewHolder>() {

    private var projects: Array<Project> = projects

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ARViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_areality, parent, false)
        return ARViewHolder(view)
    }

    override fun onBindViewHolder(holder: ARViewHolder, position: Int) {
        holder.bindProject(projects[position])
    }

    class ARViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val projectImage: ImageView = itemView.findViewById(R.id.project_image)
        private val projectTitle: TextView = itemView.findViewById(R.id.project_title)
        private val projectText: TextView = itemView.findViewById(R.id.project_text)

        fun bindProject(project: Project) {
            projectImage.setImageResource(project.image)
            projectTitle.text = project.name
            projectText.text = HtmlCompat.fromHtml(project.description, HtmlCompat.FROM_HTML_MODE_LEGACY)
        }
    }

    override fun getItemCount(): Int {
        return projects.size
    }
}

package com.example.leandro.countryapp.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.leandro.countryapp.R;
import com.example.leandro.countryapp.model.data.Country;

import java.util.ArrayList;
import java.util.List;

public class CountryListAdapter extends RecyclerView.Adapter<CountryListAdapter.CountryViewHolder> {

    private List<Country> countries;
    private ClickItemListener<Country> clickItemListener;

    public CountryListAdapter(List<Country> countries, ClickItemListener<Country> clickItemListener) {
        this.countries = countries;
        this.clickItemListener = clickItemListener;
    }

    public void refreshContent(List<Country> countries) {
        if (this.countries == null) {
            this.countries = new ArrayList<>(countries);
        } else {
            this.countries.clear();
            this.countries.addAll(countries);
        }
        notifyDataSetChanged();
    }

    @Override
    public CountryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_coutries_item, parent, false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CountryViewHolder holder, int position) {
        Country country = countries.get(position);
        holder.tvCountryName.setText(country.getName());
    }

    @Override
    public int getItemCount() {
        return (countries != null) ? countries.size() : 0;
    }

    public class CountryViewHolder extends RecyclerView.ViewHolder {

        TextView tvCountryName;

        CountryViewHolder(View itemView) {
            super(itemView);
            tvCountryName = (TextView) itemView.findViewById(R.id.tv_country_name);
            this.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickItemListener.onClickItem(countries.get(getAdapterPosition()));
                }
            });
        }
    }
}

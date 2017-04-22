package com.example.leandro.countryapp.ui.adapter;

import com.example.leandro.countryapp.model.data.BaseEntity;

public interface ClickItemListener<T extends BaseEntity> {
    void onClickItem(T item);
}

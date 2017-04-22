package com.example.leandro.countryapp.model.data;

import org.parceler.Parcel;

@Parcel(Parcel.Serialization.BEAN)
public class BaseEntity {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

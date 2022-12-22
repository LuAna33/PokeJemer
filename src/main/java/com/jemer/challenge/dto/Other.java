package com.jemer.challenge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Other{
    public DreamWorld dream_world;
    public Home home;
    @JsonProperty("official-artwork")
    public OfficialArtwork officialArtwork;
}
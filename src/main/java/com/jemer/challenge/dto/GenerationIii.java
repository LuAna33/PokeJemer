package com.jemer.challenge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GenerationIii{

    public Emerald emerald;
    @JsonProperty("firered-leafgreen")
    public FireredLeafgreen fireredLeafgreen;
    @JsonProperty("ruby-sapphire")
    public RubySapphire rubySapphire;
}
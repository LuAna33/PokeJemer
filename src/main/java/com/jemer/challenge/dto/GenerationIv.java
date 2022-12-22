package com.jemer.challenge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GenerationIv{
    @JsonProperty("diamond-pearl")
    public DiamondPearl diamondPearl;
    @JsonProperty("heartgold-soulsilver")
    public HeartgoldSoulsilver heartgoldSoulsilver;
    public Platinum platinum;
}

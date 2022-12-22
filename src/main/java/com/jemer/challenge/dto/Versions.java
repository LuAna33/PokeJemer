package com.jemer.challenge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Versions{
    @JsonProperty("generation-i")
    public GenerationI generationI;
    @JsonProperty("generation-ii")
    public GenerationIi generationIi;
    @JsonProperty("generation-iii")
    public GenerationIii generationIii;
    @JsonProperty("generation-iv")
    public GenerationIv generationIv;
    @JsonProperty("generation-v")
    public GenerationV generationV;
    @JsonProperty("generation-vi")
    public GenerationVi generationVi;
    @JsonProperty("generation-vii")
    public GenerationVii generationVii;
    @JsonProperty("generation-viii")
    public GenerationViii generationViii;
}
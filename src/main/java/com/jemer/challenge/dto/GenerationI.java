package com.jemer.challenge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GenerationI{
    @JsonProperty("red-blue")
    public RedBlue redBlue;
    public Yellow yellow;
}
package com.jemer.challenge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Move{

    @JsonProperty("move")
    public Move2 move;
    public ArrayList<VersionGroupDetail> version_group_details;
}


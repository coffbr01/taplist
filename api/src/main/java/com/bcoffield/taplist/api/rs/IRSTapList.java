package com.bcoffield.taplist.api.rs;

import com.bcoffield.taplist.dto.DTOTapList;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("taplist")
public interface IRSTapList {
    @GET
    DTOTapList get(@DefaultValue("4") @QueryParam("count") Integer count);
}

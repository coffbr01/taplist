package com.bcoffield.taplist.api;

import com.bcoffield.taplist.dto.DTOTapList;

import javax.ejb.Local;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Local
@Path("taplist")
public interface IRSTapList {
    @GET
    DTOTapList get(@DefaultValue("4") @QueryParam("count") Integer count);
}

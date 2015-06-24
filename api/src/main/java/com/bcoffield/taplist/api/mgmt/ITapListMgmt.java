package com.bcoffield.taplist.api.mgmt;

import com.bcoffield.taplist.entity.EBeer;

import java.util.List;

public interface ITapListMgmt {
    List<EBeer> getTapList(Integer count);
}

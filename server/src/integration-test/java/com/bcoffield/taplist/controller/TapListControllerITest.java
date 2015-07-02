package com.bcoffield.taplist.controller;

import com.bcoffield.taplist.ITest;
import com.bcoffield.taplist.dto.DTOBeer;
import com.bcoffield.taplist.dto.DTOTapList;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TapListControllerITest extends ITest {

    @Test
    public void testGetTapList() throws Exception {
        DTOBeer dtoBeer1 = createDtoBeer();
        DTOBeer dtoBeer2 = createDtoBeer();
        DTOBeer dtoBeer3 = createDtoBeer();

        DTOBeer postResult1 = makePostRequest(BeerController.class, null, DTOBeer.class, dtoBeer1);
        DTOBeer postResult2 = makePostRequest(BeerController.class, null, DTOBeer.class, dtoBeer2);
        DTOBeer postResult3 = makePostRequest(BeerController.class, null, DTOBeer.class, dtoBeer3);
        Assert.assertTrue(postResult1.getId() > 0);
        Assert.assertEquals((Integer)(postResult1.getId() + 1), postResult2.getId());
        Assert.assertEquals((Integer)(postResult2.getId() + 1), postResult3.getId());

        Map<String, String> params = new HashMap<>();
        params.put("count", "3");
        DTOTapList dtoTapList = makeGetRequest(TapListController.class, null, DTOTapList.class, params);
        Assert.assertNotNull(dtoTapList);
        List<DTOBeer> beers = dtoTapList.getBeers();
        Assert.assertNotNull(beers);
        Assert.assertEquals(3, beers.size());
    }

    private DTOBeer createDtoBeer() {
        DTOBeer dtoBeer = new DTOBeer();
        dtoBeer.setName("Some name");
        dtoBeer.setDescription("Some description");
        dtoBeer.setAbv(6.5f);
        dtoBeer.setOg(1.060f);
        dtoBeer.setFg(1.010f);
        dtoBeer.setSrm(8);
        return dtoBeer;
    }

}

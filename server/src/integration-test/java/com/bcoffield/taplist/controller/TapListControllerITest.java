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
        DTOBeer dtoBeer1 = createDtoBeer("1");
        DTOBeer dtoBeer2 = createDtoBeer("2");
        DTOBeer dtoBeer3 = createDtoBeer("3");
        DTOBeer dtoBeer4 = createDtoBeer("4");

        DTOBeer postResult1 = makePostRequest(BeerController.class, null, DTOBeer.class, dtoBeer1);
        DTOBeer postResult2 = makePostRequest(BeerController.class, null, DTOBeer.class, dtoBeer2);
        DTOBeer postResult3 = makePostRequest(BeerController.class, null, DTOBeer.class, dtoBeer3);
        DTOBeer postResult4 = makePostRequest(BeerController.class, null, DTOBeer.class, dtoBeer4);
        Assert.assertTrue(postResult1.getId() > 0);
        Assert.assertEquals((Integer)(postResult1.getId() + 1), postResult2.getId());
        Assert.assertEquals((Integer)(postResult2.getId() + 1), postResult3.getId());
        Assert.assertEquals((Integer)(postResult3.getId() + 1), postResult4.getId());

        Assert.assertEquals(dtoBeer1.getName(), postResult1.getName());
        Assert.assertEquals(dtoBeer2.getName(), postResult2.getName());
        Assert.assertEquals(dtoBeer3.getName(), postResult3.getName());
        Assert.assertEquals(dtoBeer4.getName(), postResult4.getName());

        Map<String, String> params = new HashMap<>();
        params.put("count", "3");
        DTOTapList dtoTapList = makeGetRequest(TapListController.class, null, DTOTapList.class, params);
        Assert.assertNotNull(dtoTapList);
        List<DTOBeer> beers = dtoTapList.getBeers();
        Assert.assertNotNull(beers);
        Assert.assertEquals(3, beers.size());
        Assert.assertEquals(dtoBeer1.getName(), beers.get(0).getName());
        Assert.assertEquals(dtoBeer2.getName(), beers.get(1).getName());
        Assert.assertEquals(dtoBeer3.getName(), beers.get(2).getName());
    }
}

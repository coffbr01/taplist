package com.bcoffield.taplist.controller;

import com.bcoffield.taplist.ITest;
import com.bcoffield.taplist.dto.DTOBeer;
import com.bcoffield.taplist.dto.DTODispenser;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class DispenserControllerITest extends ITest {

    @Test
    public void testDispenser() throws Exception {
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

        DTODispenser dtoDispenser = new DTODispenser();
        dtoDispenser.setName("Keezer");
        DTODispenser postResult = makePostRequest(DispenserController.class, null, DTODispenser.class, dtoDispenser);
        DTODispenser getResult = makeGetRequest(DispenserController.class, String.valueOf(postResult.getId()), DTODispenser.class, null);
        Assert.assertNotNull(getResult);
        Assert.assertEquals(dtoDispenser.getName(), getResult.getName());

        String path1 = postResult1.getId() + "/dispenser/" + getResult.getId();
        String path2 = postResult2.getId() + "/dispenser/" + getResult.getId();
        String path3 = postResult3.getId() + "/dispenser/" + getResult.getId();
        makePutRequest(BeerController.class, path1, DTODispenser.class, null);
        makePutRequest(BeerController.class, path2, DTODispenser.class, null);
        makePutRequest(BeerController.class, path3, DTODispenser.class, null);

        getResult = makeGetRequest(DispenserController.class, String.valueOf(postResult.getId()), DTODispenser.class, null);

        List<DTOBeer> beers = getResult.getBeers();
        Assert.assertNotNull(beers);
        Assert.assertEquals(3, beers.size());
        Assert.assertEquals(dtoBeer1.getName(), beers.get(0).getName());
        Assert.assertEquals(dtoBeer2.getName(), beers.get(1).getName());
        Assert.assertEquals(dtoBeer3.getName(), beers.get(2).getName());
    }
}

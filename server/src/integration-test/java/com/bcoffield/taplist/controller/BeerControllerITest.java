package com.bcoffield.taplist.controller;

import com.bcoffield.taplist.ITest;
import com.bcoffield.taplist.dto.DTOBeer;
import org.junit.Assert;
import org.junit.Test;

public class BeerControllerITest extends ITest {

    @Test
    public void testCreateBeer() throws Exception {
        DTOBeer dtoBeer = createDtoBeer();

        DTOBeer postResult = makePostRequest(BeerController.class, null, DTOBeer.class, dtoBeer);
        Assert.assertTrue(postResult.getId() > 0);
        Assert.assertEquals(dtoBeer.getName(), postResult.getName());
        Assert.assertEquals(dtoBeer.getDescription(), postResult.getDescription());
        Assert.assertEquals(dtoBeer.getAbv(), postResult.getAbv());
        Assert.assertEquals(dtoBeer.getOg(), postResult.getOg());
        Assert.assertEquals(dtoBeer.getFg(), postResult.getFg());
        Assert.assertEquals(dtoBeer.getSrm(), postResult.getSrm());
    }

    @Test
    public void testGetBeer() throws Exception {
        DTOBeer dtoBeer = createDtoBeer();

        DTOBeer postResult = makePostRequest(BeerController.class, null, DTOBeer.class, dtoBeer);
        DTOBeer getResult = makeGetRequest(BeerController.class, postResult.getId().toString(), DTOBeer.class, null);
        Assert.assertTrue(getResult.getId() > 0);
        Assert.assertEquals(postResult.getId(), getResult.getId());
        Assert.assertEquals(dtoBeer.getName(), getResult.getName());
        Assert.assertEquals(dtoBeer.getDescription(), getResult.getDescription());
        Assert.assertEquals(dtoBeer.getAbv(), getResult.getAbv());
        Assert.assertEquals(dtoBeer.getOg(), getResult.getOg());
        Assert.assertEquals(dtoBeer.getFg(), getResult.getFg());
        Assert.assertEquals(dtoBeer.getSrm(), getResult.getSrm());
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

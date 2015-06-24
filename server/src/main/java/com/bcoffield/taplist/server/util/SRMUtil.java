package com.bcoffield.taplist.server.util;

import com.bcoffield.taplist.entity.ESRMValue;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class SRMUtil {
    @Inject
    private static EntityManager em;

    private static List<ESRMValue> srmValues;

    public static String toColor(Integer srm) {
        init();
        ESRMValue match = null;
        for (ESRMValue value : srmValues) {
            if (value.getSrm().equals(srm)) {
                match = value;
                break;
            }
        }
        if (match == null) {
            throw new RuntimeException("SRM value " + srm + " was not recognized. It should be between 1 and 40");
        }
        return match.getColor();
    }

    private static void init() {
        if (srmValues == null) {
            srmValues = em.createNamedQuery(ESRMValue.FIND_ALL, ESRMValue.class).getResultList();
        }
    }

    public static Integer toSrm(String srm) {
        init();
        ESRMValue match = null;
        for (ESRMValue value : srmValues) {
            if (value.getColor().equals(srm)) {
                match = value;
                break;
            }
        }
        if (match == null) {
            throw new RuntimeException("SRM color value " + srm + " was not recognized.");
        }
        return match.getSrm();
    }
}

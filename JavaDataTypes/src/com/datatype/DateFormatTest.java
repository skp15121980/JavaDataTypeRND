package com.datatype;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class DateFormatTest {

    @Parameters
    private static final Object[] getCorrectDate() {
        return new Object[] {
                new Object[]{"2014-12-13 12:12:12"},
                new Object[]{"2014-12-13 12:12:1"},
                new Object[]{"2014-12-13 12:12:01"},
                new Object[]{"2014-12-13 12:1"},
                new Object[]{"2014-12-13 12:01"},
                new Object[]{"2014-12-13 12"},
                new Object[]{"2014-12-13 1"},
                new Object[]{"2014-12-31 12:12:01"},
                new Object[]{"2014-12-30 23:59:59"},
        };
    }
    @Parameters
    private static final Object[] getWrongDate() {
        return new Object[] {
                new Object[]{"201-12-13 12:12:12"},
                new Object[]{"2014-12- 12:12:12"},
                new Object[]{"2014- 12:12:12"},
                new Object[]{"3014-12-12 12:12:12"},
                new Object[]{"2014-22-12 12:12:12"},
                new Object[]{"2014-12-42 12:12:12"},
                new Object[]{"2014-12-32 12:12:12"},
                new Object[]{"2014-13-31 12:12:12"},
                new Object[]{"2014-12-31 32:12:12"},
                new Object[]{"2014-12-31 24:12:12"},
                new Object[]{"2014-12-31 23:60:12"},
                new Object[]{"2014-12-31 23:59:60"},
                new Object[]{"2014-12-31 23:59:50."},
                new Object[]{"2014-12-31 "},
                new Object[]{"2014-12 23:59:50"},
                new Object[]{"2014 23:59:50"}
        };
    }

    @Test
    @Parameters(method="getCorrectDate")
    public void testMethodHasReturnTrueForCorrectDate(String dateToValidate) {
        assertTrue(DataType.validateDateTimeFormat(dateToValidate));
    }

    @Test
    @Parameters(method="getWrongDate")
    public void testMethodHasReturnFalseForWrongDate(String dateToValidate) {
        assertFalse(DataType.validateDateTimeFormat(dateToValidate));
    }

}

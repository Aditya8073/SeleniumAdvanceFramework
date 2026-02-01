package com.thetestingacademy.utils;

import org.testng.Assert;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.AssertJUnit.assertEquals;

public class AssertHelpers {

    public static void verifyEquals(String actual, String expected){
        assertEquals(actual, expected);
    }

    public static void verifyEquals(int actual, int expected, int description) {
        assertEquals(actual, expected, description);
    }

    public static void verifyStringKey(String keyExpect, String KeyActual){
            //Assertj
            assertThat(keyExpect).isNotNull();
            assertThat(keyExpect).isNotBlank();
            assertThat(keyExpect).isEqualTo(KeyActual);
        }

        public static void verifyStringKeyNotNull(String keyExpect){
            assertThat(keyExpect).isNotNull();
        }

        public static void verifyStringKeyNotNull(Integer keyExpect){
            assertThat(keyExpect).isNotNull();
        }

        public static void verifyTrue(boolean keyExpect){
            assertThat(keyExpect);
        }
    }


package com.github.knightliao.hermesjsonrpc.core.test.protocol;

import org.junit.Assert;
import org.junit.Test;

import com.github.knightliao.hermesjsonrpc.core.codec.gson.GsonProcessor;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * 
 * @author liaoqiqi
 * @version 2014-8-28
 */
public class JsonProcessorTestCase {

    @Test
    public void deserializeTest() {

        GsonProcessor processor = new GsonProcessor();

        String data = "[{\"name\":\"kevin\",\"age\":25},{\"name\":\"cissy\",\"age\":24}]";

        JsonElement el = processor.deserialize("UTF-8", data.getBytes());

        Assert.assertEquals(data, el.toString());
    }

    @Test
    public void serializeTest() {

        GsonProcessor processor = new GsonProcessor();

        String str = "[{'name':'kevin','age':25},{'name':'cissy','age':24}]";
        JsonParser parser = new JsonParser();
        JsonElement el = parser.parse(str);

        byte[] byteData = processor.serialize("UTF-8", el);

        System.out.println(new String(byteData));
        Assert.assertEquals(
                "[{\"name\":\"kevin\",\"age\":25},{\"name\":\"cissy\",\"age\":24}]",
                new String(byteData));
    }

}

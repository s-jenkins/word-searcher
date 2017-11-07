package com.suhasini.searcher.com.suhasini.searcher.controller;

import com.suhasini.searcher.com.suhasini.searcher.MockServletResponse;
import com.suhasini.searcher.com.suhasini.searcher.entity.dto.BaseDto;
import org.junit.Assert;
import org.junit.Test;

import javax.servlet.http.HttpServletResponse;

import static org.junit.Assert.assertTrue;

/**
 * Created by simon on 05/11/2017.
 */
public class DefaultControllerTest
{
    @Test
    public void testChangeSearchRootDir() throws Exception
    {
        String newDir = "/src/main/resources";
        DefaultController controller = new DefaultController(null);
        HttpServletResponse http = new MockServletResponse();
        BaseDto req = new BaseDto("." + newDir);
        BaseDto resp = controller.changeSearchRootDir(req, http);
        Assert.assertEquals(http.getStatus(), 200);
        Assert.assertTrue(resp.getMessage().endsWith(newDir));
    }

    @Test
    public void testChangeSearchRootDirInvalid() throws Exception
    {
        String newDir = "/src/main/dummy";
        DefaultController controller = new DefaultController(null);
        HttpServletResponse http = new MockServletResponse();
        BaseDto req = new BaseDto("." + newDir);
        BaseDto resp = controller.changeSearchRootDir(req, http);
        Assert.assertEquals(http.getStatus(), 404);
        Assert.assertTrue(resp.getMessage().contains("Error"));
    }


    @Test
    public void fetchSearchRootDir() throws Exception
    {
        DefaultController controller = new DefaultController(null);
        BaseDto bd = controller.fetchSearchRootDir();
        assertTrue(bd.getMessage().contains("word-search"));
    }

    @Test
    public void searchFilesForWords() throws Exception
    {

    }

    @Test
    public void searchFilesForWordsNoneFound() throws Exception
    {

    }



}
package com.suhasini.searcher.com.suhasini.searcher.controller;

import com.suhasini.searcher.com.suhasini.searcher.entity.dto.FileWordSearchResponse;
import com.suhasini.searcher.com.suhasini.searcher.entity.dto.BaseDto;
import com.suhasini.searcher.com.suhasini.searcher.service.SearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by simon on 05/11/2017.
 */

@RestController("/api/wordsearch")
public class DefaultController
{
    private final SearchService service;
    private Path searchRootDir = Paths.get(".");

    public DefaultController(SearchService service)
    {
        this.service = service;
    }

    @PostMapping("/changerootdir")
    public BaseDto changeSearchRootDir(BaseDto request, HttpServletResponse http) {

        BaseDto resp = new BaseDto();
        Path dir = Paths.get(request.getMessage());
        if (Files.isDirectory(dir)) {
            searchRootDir = dir;
            resp.setMessage("search root dir is now: " + searchRootDir.toAbsolutePath());
        }
        else {
            resp.setMessage("Error - directory not found: " + request.getMessage());
            http.setStatus(404);
        }
        return resp;
    }

    @GetMapping("/searchrootdir")
    public BaseDto fetchSearchRootDir() {

        BaseDto response = new BaseDto(searchRootDir.toAbsolutePath().toString());
        return response;
    }

    @PostMapping("/findinfiles.")
    public FileWordSearchResponse searchFilesForWords(List<String> words) {

        FileWordSearchResponse response = new FileWordSearchResponse();
        return response;
    }
}

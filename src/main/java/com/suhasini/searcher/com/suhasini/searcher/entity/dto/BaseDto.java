package com.suhasini.searcher.com.suhasini.searcher.entity.dto;

/**
 * Created by simon on 05/11/2017.
 */
public class BaseDto
{
    private String message;

    public BaseDto() {}

    public BaseDto(String message)
    {
        this.message = message;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
}

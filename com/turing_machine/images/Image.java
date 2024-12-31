package com.turing_machine.images;

public class Image
{
    private final String base64_content;

    public Image(String base64)
    {
        this.base64_content = base64;
    }

    public String getBase64()
    {
        return this.base64_content;
    }
}


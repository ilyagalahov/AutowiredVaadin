package ru.ecmsolutions.beans;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author xpoft
 */
@Component
public class CustomCounter implements Serializable
{
    public Integer count = 0;

    public int getCount()
    {
        return 999;
    }
}

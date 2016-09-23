/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linux.lean.javaee.elibrary.business.book.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author guru.a.kulkarni
 */
class DateMapper extends XmlAdapter<String, Date>{

    private static final String DATE_FORMAT = "dd-MM-yyyy";
    
    @Override
    public Date unmarshal(String v) throws Exception {
        return new SimpleDateFormat(DATE_FORMAT).parse(v);
    }

    @Override
    public String marshal(Date v) throws Exception {
        return new SimpleDateFormat(DATE_FORMAT).format(v);
    }
    
}

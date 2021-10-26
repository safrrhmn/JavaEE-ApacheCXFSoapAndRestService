package com.example.rest;

import com.example.domain.Student;
import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Service
@Path("/student")
public class MyRestService {

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Student getStudent() {
        return new Student("Saifur", "Rahman", "061240");
    }
}

package com.example.soap;

import com.example.domain.Student;
import org.springframework.stereotype.Service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlElement;

@Service
@WebService(serviceName = "/MySuperSoapAPI", targetNamespace = "http://mysuperapp.com")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE,use = SOAPBinding.Use.LITERAL)
public class MySuperSoapService {

    @WebMethod(operationName = "GetStudent")
    @WebResult(name = "Student")
    public Student getStudent(@XmlElement(required = true) @WebParam(name = "Student") Student student){
        return student;
    }
}

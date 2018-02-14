package com.concretepage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.concretepage.soap.GetAllStudentsResponse;
import com.concretepage.soap.GetStudentRequest;
import com.concretepage.soap.GetStudentResponse;

@Endpoint
public class StudentEndpoint {
	private static final String NAMESPACE_URI = "http://concretepage.com/soap";
	@Autowired
	private StudentUtility studentUtility;	

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getStudentRequest")
	@ResponsePayload
	public GetStudentResponse getStudent(@RequestPayload GetStudentRequest request) {
		GetStudentResponse response = new GetStudentResponse();
		response.setStudent(studentUtility.getStudent(request.getStudentId()));
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllStudentsRequest")
	@ResponsePayload
	public GetAllStudentsResponse getAllStudents() {
		GetAllStudentsResponse response = new GetAllStudentsResponse();
		response.getStudents().addAll(studentUtility.getAllStudents());
		return response;
	}
	
}

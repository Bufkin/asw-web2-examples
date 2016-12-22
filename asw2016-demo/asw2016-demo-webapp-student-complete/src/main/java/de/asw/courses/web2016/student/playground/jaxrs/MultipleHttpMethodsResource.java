// copy and paste this text into a new java class called MultipleHttpMethodsResource
// call the "postMethod" and "deleteMethod" methods via curl

package de.asw.courses.web2016.student.playground.jaxrs;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

/**
 * Example for using multiple different HTTP methods
 */
@Path("/http")
public class MultipleHttpMethodsResource {

	/**
	 * <pre>
	 * {@code curl -v http://localhost:8080/asw2016-demo-webapp-student/resources/http }
	 * </pre>
	 * 
	 * @return
	 */
	@GET
	public String getMethod() {

		System.out.printf("getMethod()%n");
		return "GET Executed";
	}

	/**
	 * <pre>
	 * {@code curl -v -d "post-body" http://localhost:8080/asw2016-demo-webapp-student/resources/http }
	 * </pre>
	 * 
	 * @param data
	 * @return
	 */
	@POST
	public String postMethod(String data) {

		System.out.printf("postMethod(%s)%n", data);
		return "POST Executed";
	}

	/**
	 * <pre>
	 * {@code curl -v -X PUT -d "post-body" http://localhost:8080/asw2016-demo-webapp-student/resources/http }
	 * </pre>
	 * 
	 * @param data
	 * @return
	 */
	@PUT
	public String putMethod(String data) {

		System.out.printf("putMethod(%s)%n", data);
		return "PUT Executed";
	}

	/**
	 * <pre>
	 * {@code curl -v -X DELETE http://localhost:8080/asw2016-demo-webapp-student/resources/http }
	 * </pre>
	 * 
	 * @return
	 */
	@DELETE
	public String deleteMethod() {

		System.out.println("HttpMethodExampleResource.deleteMethod()");
		return "DELETE Executed";
	}
}

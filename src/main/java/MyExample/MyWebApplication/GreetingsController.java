package MyExample.MyWebApplication;

import org.springframework.web.bind.annotation
	.RestController;
import org.springframework.web.bind.annotation
	.GetMapping;
import org.springframework.web.bind.annotation
	.RequestParam;

@RestController
public class GreetingsController {
	
	@GetMapping("/hello") //mapping http Get Request! need to provide string
	public HelloResponse greetings(
			//localhost:8080/hello?n=Mars->name="Mars"
			//localhost:8080/hello       ->name="World"
			@RequestParam(
					value = "n",
					defaultValue = "World"
					)
			String name) {
		HelloResponse res = new HelloResponse();
		res.message=String.format("Hello, %s!!!", name);
		return res;
	}
	class HelloResponse {
		public String message="";
	}
}

//this is POJO - Plain Old Java Object
//having a class name that ends with controller doesn't make the class a controller

//Spring is not a wizard and spring doesn't know when to execute the method controller
//spring knows greetingscontroller is a controller and method greetings should be executed on a http get request ends with /hello, spring don't know how it will get the parameter 'name' from the request 

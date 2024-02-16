package hello.advance;

import jakarta.persistence.Id;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class AdvanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvanceApplication.class, args);
	}

}

sealed interface  Loan permits  SecuredLoan,UnsecuredLoan{}

final  class SecuredLoan implements Loan{}

record UnsecuredLoan(float interest) implements Loan{}


class Message{

	String messageForLoan(Loan l){


		return switch (l){
            case SecuredLoan s -> "Good job getting Secured Loan";
			case UnsecuredLoan (var interest) -> "Bad thing getting Unsecured Loan with interest "+interest;
		};

		/*
		if(l instanceof SecuredLoan){
			return "Secured Loan";
		}
		else if(l instanceof UnsecuredLoan){
			return "Unsecured Loan";
		}
		else{
			return "Unknown Loan";
		}

		 */
	}
}



record  Customer(@Id Long id, String name, String email) {}

@RestController
class HelloController {
	@GetMapping("/hello")
	public String hello() {
		return "Hello, World!";
	}
}


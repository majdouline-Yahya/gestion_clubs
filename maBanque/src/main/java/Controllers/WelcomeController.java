package Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class WelcomeController {

	@GetMapping(value="/welcome")
	public @ResponseBody String welcome() {
		return "Welcome";
	}
}

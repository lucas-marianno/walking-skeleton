package online.olaria.hello_stupid;

import java.util.concurrent.TimeUnit;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {

  @GetMapping("/hello")
  ResponseEntity<Object> helloStupid(
      @RequestParam(required = false) String name,
      @RequestParam(required = false) Integer delay) {
    if (delay != null) {
      try {
        TimeUnit.SECONDS.sleep(delay);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    if (name == null)
      return ResponseEntity.ok("Hello stupid");

    return ResponseEntity.ok("Hello " + name);
  }
}

package ro.go.bogdanenache.devopsdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Slf4j
@RestController
public class DevOpsController {


    @GetMapping
    public ResponseEntity<String> testApi() {
        log.info("test API");
        return new ResponseEntity<>("OK" + LocalDateTime.now(), HttpStatus.OK);
    }
}

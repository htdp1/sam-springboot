// package net.kubepia.sam.restapp.restapi;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.beans.factory.annotation.Value;

// import lombok.extern.slf4j.Slf4j;

// @RestController
// @Slf4j
// @RequestMapping(value = "env")
// public class SamEnvController {

// @Value("${env.data.key1}")
// private String datakey1;

// @GetMapping(value = "key1")
// public String getMethodName() {
// log.info("msg");
// return datakey1;
// }

// }

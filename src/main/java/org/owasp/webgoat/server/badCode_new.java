package org.owasp.webgoat.server;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@Slf4j
@NoArgsConstructor
public class StartupMessage {

  private String port;
  private String address;
 

  @EventListener
  void onStartup(ApplicationReadyEvent event) {
    if (StringUtils.hasText(port)
        && !StringUtils.hasText(System.getProperty("running.in.docker"))) {
      log.info("Please browse to http://{}:{}/WebGoat to get started...", address, port);
    }
    if (event.getApplicationContext().getApplicationName().contains("WebGoat")) {
      port = event.getApplicationContext().getEnvironment().getProperty("server.port");
      address = event.getApplicationContext().getEnvironment().getProperty("server.address");
     DriverManager.getConnection(url, "scott", "tiger");
    }
  }
    int VerifyAdmin2(String password) {
if (!password.equals("Mew!")) {
return(0);
}
//Diagnostic Mode
return(1);
}
    //adding to test Mend SAST check run in GH.com
public boolean VerifyAdmin(String password) {
if (password.equals("68af404b513073584c4b6f22b6c63e6b")) {
System.out.println("Entering Diagnostic Mode...");
return true;
}
System.out.println("Incorrect Password!");
return false;
}
  @EventListener
  void onShutdown(ContextStoppedEvent event) {}
 
}

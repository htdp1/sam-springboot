package net.kubepia.sam.restapp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.java.Log;

@Log
@Component
@Order(1)
public class FirstFilter implements Filter{

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    log.info("before in first filter");
    chain.doFilter(request, response);
    // response.getOutputStream().println("\n");
    log.info("after in first filter");
  }
  
}

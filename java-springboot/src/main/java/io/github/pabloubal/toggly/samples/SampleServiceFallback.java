package io.github.pabloubal.toggly.samples;

import org.springframework.stereotype.Component;

@Component
public class SampleServiceFallback {
  private static final String TOGGLE_FALLBACK = "The toggle triggered the fallback";

  public String testWithFallback() {
    return TOGGLE_FALLBACK;
  }
}

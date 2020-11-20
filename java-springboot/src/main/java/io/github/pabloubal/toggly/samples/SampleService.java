package io.github.pabloubal.toggly.samples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.pabloubal.togglysbstarter.core.TogglyManager;
import io.github.pabloubal.togglysbstarter.core.interfaces.Toggly;

@Component
public class SampleService {
  @Autowired
  TogglyManager manager;

  private static final String TOGGLE_ENABLED = "The toggle is enabled";

  @Toggly(value = SampleFeaturesEnum.MY_FEATURE)
  public String testWithoutFallback() {
    return TOGGLE_ENABLED;
  }

  @Toggly(value = SampleFeaturesEnum.MY_FEATURE, fallbackClass = SampleServiceFallback.class)
  public String testWithFallback() {
    return TOGGLE_ENABLED;
  }

  public String testWithoutAnnotation() {
    if (manager.isActive(SampleFeaturesEnum.MY_FEATURE))
      return TOGGLE_ENABLED;
    else
      return "Not enabled";
  }

}
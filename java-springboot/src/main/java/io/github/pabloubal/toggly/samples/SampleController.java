package io.github.pabloubal.toggly.samples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class SampleController {
  private final SampleService sampleService;

  @Autowired
  public SampleController(SampleService sampleService) {
    this.sampleService = sampleService;
  }

  @GetMapping("/fallback")
  public String withFallback(){
    return sampleService.testWithFallback();
  }

  @GetMapping("/nofallback")
  public String withoutFallback(){
    return sampleService.testWithoutFallback();
  }

  @GetMapping("/noAnnotation")
  public String withoutAnnotation(){
    return sampleService.testWithoutAnnotation();
  }
}

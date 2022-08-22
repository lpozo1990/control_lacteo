package com.lacteo.control_lacteo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ProvidersController
 */
@Controller
public class ProvidersController {
    @GetMapping("/providers")
    String GetProviders(){
    return "providers";
    }
}
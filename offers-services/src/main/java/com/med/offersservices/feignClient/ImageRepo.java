package com.med.offersservices.feignClient;

import com.med.offersservices.model.Image;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "image-service", url = "http://localhost:8082/images")
public interface ImageRepo {
    @RequestMapping(method = RequestMethod.GET , value = "/{idImage}")
    public Image getImageById(@PathVariable("idImage") int id) ;
}

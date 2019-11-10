package com.pradeep.moviecatalogservice.resource;

import com.pradeep.moviecatalogservice.model.CatalogItem;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogService {
    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalogs(@PathVariable("userId") String userId) {
        return Collections.singletonList(
                new CatalogItem("Transformer", "description", 4)
        );
    }

}
